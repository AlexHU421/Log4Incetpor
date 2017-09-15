package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.RegexLib.ContextRegexLib;
import entity.RegexLib.DAGRegexLib;
import entity.RegexLib.LeviathanRegexLib;
import entity.RegexLib.TaskSetManagerRegexLib;
import entity.RegexLib.qlDriverRegexLib;
import entity.entityset.ErrorVector;
import entity.entityset.SessionVector;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;

public class FilterByKey {
	public SessionVector sessionVector;
	public StageVector stageVector;
	public TaskVector taskVector;
	public ErrorVector errorVector;
	public   DAGRegexLib DAG = new DAGRegexLib();
	public   LeviathanRegexLib Leviathan = new LeviathanRegexLib();
	public   qlDriverRegexLib qlDriver = new qlDriverRegexLib();
	public   TaskSetManagerRegexLib TaskSetManager = new TaskSetManagerRegexLib();
	public   ContextRegexLib Context = new ContextRegexLib();
	public   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS ");
	static String[] sz1;
	private String LID = "";
	private String JID = "";
	private String SID = "";
	boolean check = false;
	private String savetemp = "";
	private String temp2;
	private String temp = "";
	private String LogTime = "";
	private String SessionID = "";
	private String StageID = "";
	private String TaskID = "";
	private String TaskNodeName = "";
	private String separator = ":this is separator:";
	private metaRows4Row mr = new metaRows4Row();
	private boolean checkInfo = false;
	private String tempInfo = "";
	private FilterByKey(){
		
	}
	public FilterByKey(SessionVector sessionVector,StageVector stageVector,TaskVector taskVector,ErrorVector errorVector){
		this.sessionVector=sessionVector;
		this.stageVector=stageVector;
		this.taskVector=taskVector;
		this.errorVector=errorVector;
	}
	public void filterOtherError(Pattern p ,Matcher matcher,ErrorVector errorVector){
		Iterator<String> it = errorVector.getErerorSetVectorVector().iterator();
		while (it.hasNext()){
			temp = it.next();
			if(p.compile("SessionHandle\\=").matcher(temp).find()){
				SessionID = temp.split("SessionHandle\\=")[1].split("\\)\\] \\- ")[0];
			}
			if(p.compile(" Lost task \\d+\\.\\d+ in stage ").matcher(temp).find()){
				StageID = temp.split(" Lost task \\d+\\.\\d+ in stage ")[1].split("\\.\\d+ \\(TID")[0];
			}
			if(p.compile(" \\(TID ").matcher(temp).find()){
				temp2 = temp.split(" \\(TID ")[1];
				TaskID = temp2.split("\\, ")[0];
				TaskNodeName = temp2.split("\\, ")[1].split("\\)\\: org")[0];
			}
			savetemp+=temp+"\\: NewLine \\:";
			if(it.equals("\\:this is error separate rows\\:")){
			errorVector.setEreror4OneOtherErrorTempVectorByKey(SessionID+separator
					  +StageID+separator
					  +TaskID+separator
					  +TaskNodeName+separator
					  +savetemp);
			SessionID="";
			StageID="";
			TaskID="";
			TaskNodeName="";
			savetemp="";
			}
			it.remove();
	}
			if (!savetemp.equals("")){
				for(String str:savetemp.split("\\: NewLine \\:")){
					errorVector.setErerorSetVectorByKey(str);
				}
			}
		mr.metaErrorInfo4Vector(sessionVector,stageVector,taskVector,errorVector,p);
	}
	
	public void filterError(Pattern p ,Matcher matcher,ErrorVector errorVector){
		Iterator<String> it = errorVector.getErerorSetVectorVector().iterator();
		while (it.hasNext()){
			temp = it.next();
			if(p.compile("Spark task execution is failed").matcher(temp).find()){
				check = true;
				it.remove();
			}
			if (check){
				LogTime = temp.split("Spark")[0];
				while (it.hasNext()){
					temp = it.next();
					if(p.compile("SessionHandle\\=").matcher(temp).find()){
						SessionID = temp.split("SessionHandle\\=")[1].split("\\)\\] \\- ")[0];
					}
					if(p.compile(" Lost task \\d+\\.\\d+ in stage ").matcher(temp).find()){
						StageID = temp.split(" Lost task \\d+\\.\\d+ in stage ")[1].split("\\.\\d+ \\(TID")[0];
					}
					if(p.compile(" \\(TID ").matcher(temp).find()){
						temp2 = temp.split(" \\(TID ")[1];
						TaskID = temp2.split("\\, ")[0];
						TaskNodeName = temp2.split("\\, ")[1].split("\\)\\: org")[0];
					}
					savetemp+=temp+"\\: NewLine \\:";
					it.remove();
				}
				errorVector.setEreror4OneErrorTempVectorByKey(SessionID+separator
															  +StageID+separator
															  +TaskID+separator
															  +TaskNodeName+separator
															  +savetemp);
				SessionID="";
				StageID="";
				TaskID="";
				TaskNodeName="";
				savetemp="";
			}
		}
		
	}
	
	
	public void findFilterByKey(String key,String row,int conditionCode,Pattern p ,Matcher matcher,String LogTimeS,String LogType){
		Long LogTime;
		try {
			LogTime = sdf.parse(LogTimeS).getTime();
		} catch (ParseException e) {
			LogTime = System.currentTimeMillis();
		}
//		System.out.println(key);
		if ("Leviathan".equals(key)){
			switch (conditionCode){
			case 1:
				Leviathan.FilterDetail4RegexLib("Topo", row,LogTime,LogType,sessionVector,taskVector,stageVector);
				break;
			case 2:
				sz1 = Leviathan.Filter2RegexLib();
				conditionCode=0;
				for (String regex:sz1){
					conditionCode++;
						matcher = p.compile(regex).matcher(row);
						if (matcher.find()) {
							Leviathan.FilterDetail4RegexLib(("TaskDetailRows"+conditionCode),row,LogTime,LogType,sessionVector,taskVector,stageVector);
							break;
						}
				}
				break;				
			case 3:
//				System.out.println(row);
//				System.out.println(LogTime);
//				System.out.println(LogType);
				Leviathan.FilterDetail4RegexLib("SessionSQLRows", row,LogTime,LogType,sessionVector,taskVector,stageVector);
			default:
//				System.out.println(conditionCode+"filter is error");
//				break;
			
		}
		}else
		if ("DAG".equals(key)){
			if(conditionCode==1){
				DAG.FilterDetail4RegexLib("Job",row,LogTime,LogType,sessionVector,stageVector,taskVector);
			}else{
				DAG.FilterDetail4RegexLib("StageFinish",row,LogTime,LogType,sessionVector,stageVector,taskVector);
			}
		}else
		if ("qlDrive".equals(key)){
			if(conditionCode==1){
				qlDriver.FilterDetail4RegexLib("JobTime",row,LogTime,LogType,"",sessionVector);
			}else{
				qlDriver.FilterDetail4RegexLib("SessionEnd",row,LogTime,LogType,"",sessionVector);
			}
		}else
		if ("JobFinish".equals(key)){
			Context.FilterDetail4RegexLib(row, LogTime, LogType,sessionVector);
		}else
		if ("TaskSet".equals(key)){
			if(conditionCode==1){
				TaskSetManager.FilterDetail4RegexLib("start",row,LogTime,LogType,taskVector);
			}else{
				TaskSetManager.FilterDetail4RegexLib("end",row,LogTime,LogType,taskVector);
			}
		}else{
			System.out.println(key);
		}
//		String[] nullRegex = {""};
//		key = "leviathan.TimedEventTracker:";
//		System.out.println(key);
//		if(key.equals("DAG")){
//		}else if (key.equals("Leviathan")){
//		}else if (key.equals("Context")){
//		}else{
		
	}
	public void setRelTask(String row){
		stageVector.setRelTaskAllVectorByKey(row);
	}
	public void metaRelTaskGetReady(Pattern p){
		Iterator<String> it = stageVector.getRelTaskAllVector().iterator();
		while(it.hasNext()){
		    String x = it.next();
//		    System.out.println(x);
//		    if(x.equals("b")){
		    if(p.compile("Leviathan").matcher(x).find()){
		    	//临时保存stage的集合
		    	stageVector.setRelTaskStageInfoTempVectorByKey(x);
		    	it.remove();
		    }else if (x.equals("SBUS END")){
		    	if (stageVector.getRelTaskStageInfoTempVector().size()!=0){
		    		for(String str:stageVector.getRelTaskStageInfoTempVector()){
//		    			System.out.println(str);
		    			sz1 =  str.split("(\\[Leviathan\\]\\[)")[1].split("(\\])");
		    			if(!sz1[0].equals("-1")){
		    				LID = sz1[0];
		    			}
		    			if (p.compile("Duration").matcher(sz1[1]).find()){
		    			sz1 = sz1[1].split("Job\\: ")[1].split(" Stage\\: ");
		    				JID = sz1[0];
		    			sz1 = sz1[1].split(" Duration\\: ");
		    				SID = sz1[0];
		    			}
		    			}
		    			//保存ID信息用于匹配及保存	
		    			tempInfo+=LID+": RelTask2OneTask :"+JID+": RelTask2OneTask :"+SID;
		    			if(stageVector.getRelTaskTaskInfoTempVector().size()!=0){
		    			for (String te:stageVector.getRelTaskTaskInfoTempVector()){
				    		sz1 = te.split("\\[SparkListenerBus\\(\\)\\] \\- ");
				    		tempInfo+=": separator :"+sz1[1];
				    	}
		    			checkInfo = true;
//		    			System.out.println(tempInfo);
		    			stageVector.RemoveRelTaskTaskInfoTempVector();
		    			}
		    			if(checkInfo){
		    				stageVector.setRelTask2OneTaskVectorByKey(tempInfo);
		    				tempInfo = "";
		    				checkInfo =  false;
		    			}
		    			stageVector.RemoveRelTaskStageInfoTempVector();
		    		}
		    		it.remove();
		    }else{
		    	//临时保存单个task信息的集合
		    	stageVector.setRelTaskTaskInfoTempVectorByKey(x);
		    	it.remove();
		    }
		}
//		it = taskVector.getTaskInfoTempVector().iterator();
//		while(it.hasNext()){
//			 String x = it.next();
//			 if(p.compile("Leviathan").matcher(x).find()){
//			    	//临时保存stage的集合
//			    	stageVector.setRelTaskStageInfoTempVectorByKey(x);
//			    	it.remove();
//		}
//		System.out.println(stageVector.getRelTaskAllVector().size());
//		System.out.println(stageVector.getRelTask2OneTaskVector().size());
//		System.out.println(stageVector.getRelTaskStageInfoTempVector().size());
//		System.out.println(stageVector.getRelTaskTaskInfoTempVector().size());
//		stageVector.RemoveRelTaskAllVector();
	}
}
