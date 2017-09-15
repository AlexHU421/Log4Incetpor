package Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import File.GetLogFile;
import Out.Output;
import entity.rows;
import entity.RegexLib.RowsFilterRegexLib;
import entity.entityset.ErrorVector;
import entity.entityset.SessionVector;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;
import util.FilterByKey;
import util.metaRows4Row;

public class FindInceptorLog {
	static String s;
	static String regex;
	static Pattern p;
	static Matcher matcher;
	static String s2;
	static String time;
	static String s3;
	static Matcher matcherFilter1;
	static Matcher matcherFilter2;
	static Matcher matcherFilter3;
	static Matcher matcherFilter4;
	static String error;
	static RowsFilterRegexLib rowsfilterregexlib = new RowsFilterRegexLib(); 
	static HashMap<String,String> firstRegexLib = rowsfilterregexlib.getFisterFilterRegexLib();
	static Iterator it;
	static String key;
	static String value;
	static String[] secoundRegexLib;
	static String[] sz1;
	public static SessionVector sessionVector;
	public static StageVector stageVector;
	public static TaskVector taskVector;
	public static ErrorVector errorVector;
	static int temp;
	public static rows row;
	
	private static metaRows4Row mr = new metaRows4Row();
	public FindInceptorLog(){
	}
	
	public FindInceptorLog(SessionVector sessionVector,StageVector stageVector,TaskVector taskVector,ErrorVector errorVector,rows row){
		this.sessionVector=sessionVector;
		this.stageVector=stageVector;
		this.taskVector=taskVector;
		this.errorVector=errorVector;
		this.row=row;
	}
	public static void main() {
		FilterByKey filterByKey = new FilterByKey(sessionVector,stageVector,taskVector,errorVector);
		Long starttime = System.currentTimeMillis();		
		do{
			try{
			GetLogFile glog =  new GetLogFile(row);
			
			File file = glog.getFile();
			row.setNewnewfilesize((int)GetLogFile.getFile().length()+1);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
			System.out.println(row.toString());
			br.skip(row.getOldnewfilesize());
			error="!The Error :!";
			s = br.readLine();
			if(s!=null&&!p.compile("(SparkListenerBus)").matcher(s).find()){
				filterByKey.setRelTask("SBUS END");
			}
			int x = 0;
			int y = 0;
			it = firstRegexLib.keySet().iterator();	
			while(s!=null){
				if(p.compile("(SparkListenerBus)").matcher(s).find()){
					if (p.compile("Job\\: \\d+ Stage\\: \\d+\\.\\d+ Duration\\: \\d+ ms TaskTime\\: \\d+ ms TaskCount\\: ").matcher(s).find()){
						filterByKey.setRelTask("SBUS END");
					}
					filterByKey.setRelTask(s);
				}
				matcher = p.compile("\\d+-\\d+-\\d+\\s\\d+:\\d+:\\d+,\\d+\\s\\w+(\\s)*(\\S+\\.)*\\S+:").matcher(s);
		        if(matcher.find()) {
		        	//检测之前行是否为报错行
		        	if(!"!The Error :!".equals(error)){
    		        	s3=s+error;
    		        	y++;
//    		        	System.out.println(s3+"All errors"+y);	//需要替换成保存error信息方法
    		        	errorVector.setErerorSetVectorByKey(":this is error separate rows:");
    		        	error="!The Error :!";
    		        	if(errorVector.isFailedCheck()){
    		        		filterByKey.filterError(p,matcher,errorVector);
    		        		errorVector.setFailedCheck(false);
    		        	}
    		        	}
		        		        	 
		        	 for (Object obj : firstRegexLib.keySet()) {
		     			key = (String)obj;
		     			value = (String)firstRegexLib.get(key);
		     			matcher = p.compile(value).matcher(s);
		     			if(matcher.find()) {
		     				s2 = s.substring(matcher.start(), matcher.end());
		     				if("Leviathan".equals(key)||"DAG".equals(key)||"qlDrive".equals(key)||"TaskSet".equals(key)){
		     					secoundRegexLib = rowsfilterregexlib.getSecoundFilterRegexLib(key);
		     					temp=0;
		     					for (String regex:secoundRegexLib){
		     						temp++;
		     						matcher = p.compile(regex).matcher(s);
		     						if (matcher.find()) {
		     						    matcher = p.compile("[A-Z]+(\\s)*(\\S+\\.)*\\S+:").matcher(s);
		     				            matcher.find();
		     				            s2 = s.substring(matcher.start(), matcher.end());
		     				        	time =  s.substring(0,matcher.start());
		     							sz1 = s.split(s2);
		     							s=time+"“  LogTime  ”"+s2+"“  LogType  ”"+sz1[sz1.length-1];
//		     							System.out.println(s);
		     							filterByKey.findFilterByKey(key,s,temp,p,matcher,time,s2);//,sessionVector);//
		     							break;
		     						}
		     					}
	     					}else{
		     					matcher = p.compile("[A-Z]+(\\s)*(\\S+\\.)*\\S+:").matcher(s);
     				            matcher.find();
     				            s2 = s.substring(matcher.start(), matcher.end());
     				        	time =  s.substring(0,matcher.start());
		     					sz1 = s.split(s2);
     							s=time+"“  LogTime  ”"+s2+"“  LogType  ”"+sz1[sz1.length-1];
//     							System.out.println(s);
     							filterByKey.findFilterByKey(key,s,temp,p,matcher,time,s2);//,sessionVector);
		     					break;	
		     				}
		     			}else if (key.equals("JobFinish")){
		     				matcher = p.compile("Spark task execution is failed").matcher(s);
 				            if(matcher.find()){
// 				            	System.out.println(s);//需要替换成保存error信息方法
 				            	errorVector.setErerorSetVectorByKey(time+"Spark task execution is failed");
 				            	errorVector.setFailedCheck(true);
 				            } 				            
		     			}
		        	}
		        }else{
		        	if (
		        		p.compile("ANONYMOUS BLOCK").matcher(s).find()||
		        		p.compile("org\\.").matcher(s).find()||
		        		p.compile("	at").matcher(s).find()||
		        		p.compile("Caused by\\:").matcher(s).find()||
		        		p.compile("	\\.\\.\\. \\d+ more").matcher(s).find()||
		        		p.compile("        io\\.transwarp").matcher(s).find()||
		        		p.compile("        java").matcher(s).find()||
		        		p.compile("        scala").matcher(s).find()||
		        		p.compile("Driver stacktrace\\:").matcher(s).find()
		        		){
		        		errorVector.setErerorSetVectorByKey(s);
		        		error=error+s+"!NewLine!";

		        	}	
		        }
		        
		        s3=s;
		        s = br.readLine();
				}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}finally{
//			filterByKey.setRelTask("Leviathan");
			if (row.isCheckNewFile()){
				row.setOldnewfilesize(0);
			}else{
				row.setOldnewfilesize(row.getNewnewfilesize());	
			}
		}
		}while(row.isCheckNewFile());
		if(!p.compile("(SparkListenerBus)").matcher(s3).find()){
			System.out.println("OK");
			filterByKey.setRelTask("SBUS END");
		}
		filterByKey.metaRelTaskGetReady(p);
		
		
		Long endtime = System.currentTimeMillis();
		System.out.println("开始时间："+starttime+"    采集结束时间："+endtime+"    采集耗费："+(endtime-starttime)+"毫秒  /  "+((endtime-starttime)/1000L)+"秒");
//		System.out.println("SessionCreateTemoVector:");
//		Vector<String> SS = sessionVector.getSessionCreateTempVector();
//		for(String a : SS){
//			System.out.println(a);
//		}
//		System.out.println("SessionJobCreateTempVector:");
//		Vector<String> SS2 = sessionVector.getSessionJobCreateTempVector();
//		for(String a : SS2){
//			System.out.println(a);
//		}
		
//		
//		Vector<String> SS3 = sessionVector.getSessionFinishedVector();
//		for(String a : SS3){
//			System.out.println(a);
//		}
//		Vector<String> SS =  taskVector.getTaskInfoTempVector();
//		for(String a:SS){
//			System.out.println(a);
////		}
//		Vector<String> SS =  taskVector.getTaskInfoTempVector();
//		for(String a:SS){
//			System.out.println(a);
//		}
//		System.out.println("+-------------------------------------------------------------+");
//		Vector<String> SS1 =  taskVector.getTaskfinishedCheckTempSet();
//		for(String a:SS1){
//			System.out.println(a);
//		}
		mr.metaRows2Set("relTask",stageVector,taskVector,"");
		filterByKey.filterOtherError(p, matcher, errorVector);
		Output out = new Output();
		/**SessionVector		separator:			:this is separator:
		 * LogTime    			1504521341571
		 * SessionID  			bcd61fe4-3d2b-42f3-ada0-add402383782
		 * JobID      	   	 	229756
		 * SQL              	select itemid,value_type from zabbix_items where hostid ='14748' and key_='system.sw.os[name]' and status='0' and state='0'
		 * FinalStageID    		244875
		 * StageIDs				244875
		 * StartTime			1504521341490
		 * EndTime				1504521342076
		 * StageFinishedCheck	true
		 */
		out.outByVector("session", sessionVector.getSessionFinishedVector());
		/**StageVector          separator:			:this is separator:			: separator :(换行分隔符)
		 * LogTime				1504521334697
		 * Leviathan			1558310
		 * JobID				229755
		 * StageID				244874
		 * StageDetail			Duration:{ 254 ms TaskTime: 1952 ms TaskCount: 507 ShufRead: 0 ShufWrite: 96 GCTime: 14.0 ms FSTouchTime: 410.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 27.39123200000001 ms ShufCompactTime: 0.0 ms }
		 * 						Statistics:{ TaskTime: [3.0,3.0,4.0,4.0,12.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,24.0] GC: [0.0,0.0,0.0,0.0,7.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }
		 * 						Executors:{num: 4 Task stat: [103.0,130.0,133.0,141.0,141.0] This event approx. costs 6 ms}
		 * 						StageDetailEnd
		 * StageAllTasksDetail	eparator :Finished stage: org.apache.spark.scheduler.StageInfo@17c58e80
		 * 		   : separator :task runtime:(count: 507, mean: 7.690335, stdev: 5.593103, max: 38.000000, min: 4.000000)
		 * 		   : separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%
		 * 		   : separator :	4.0 ms	5.0 ms	5.0 ms	6.0 ms	6.0 ms	7.0 ms	9.0 ms	17.0 ms	38.0 ms
		 * 		   : separator :shuffle bytes written:(count: 507, mean: 0.189349, stdev: 2.123329, max: 24.000000, min: 0.000000)
		 * 		   : separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%
		 * 		   : separator :	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	24.0 B
		 *		   : separator :task result size:(count: 507, mean: 954.000000, stdev: 0.000000, max: 954.000000, min: 954.000000)
		 *		   : separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%
		 * 		   : separator :	954.0 B	954.0 B	954.0 B	954.0 B	954.0 B	954.0 B	954.0 B	954.0 B	954.0 B
		 * 		   : separator :executor (non-fetch) time pct: (count: 507, mean: 57.110740, stdev: 14.896491, max: 100.000000, min: 8.108108)
		 * 		   : separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%
		 * 		   : separator :	 8 %	38 %	43 %	50 %	57 %	67 %	80 %	80 %	100 %
		 *		   : separator :other time pct: (count: 507, mean: 42.889260, stdev: 14.896491, max: 91.891892, min: 0.000000)
		 *		   : separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%
		 *		   : separator :	 0 %	20 %	20 %	33 %	43 %	50 %	57 %	63 %	92 %
		 */	
		out.outByVector("stage", stageVector.getStageVector());
		/**TaskVector          separator:			:this is separator:
		 * LogTime					1504521334530
		 * StageID					244874
		 * TaskID					734321
		 * TaskRunNodeName			dbclusternode015
		 * TaskRunMode				NODE_LOCAL
		 * TaskRunTime				7 ms
		 * TaskFinishedNodeName		dbclusternode015
		 * StageInsideTaskNum		121
		 */
		
		out.outByVector("task", taskVector.getTaskFinishedVector());
		sessionVector.RemoveSessionFinishedVector();
		taskVector.RemoveTaskFinishedVector();
		stageVector.RemoveStageVector();
		row.setOldnewfilesize(row.getNewnewfilesize());
		Long endtime1 = System.currentTimeMillis();
		System.out.println("解析开始时间："+endtime+"    解析结束时间："+endtime1+"    解析耗费："+(endtime1-endtime)+"毫秒  /  "+((endtime1-endtime)/1000L)+"秒");
		System.out.println("任务结束, 共计耗费："+(endtime1-starttime)+"毫秒  /  "+((endtime1-starttime)/1000L)+"秒");
//		System.out.println("看Ereror4OneErrorTempVector");
		Vector<String> SSx =  errorVector.getEreror4OneErrorTempVector();
		for(String a:SSx){
			System.out.println(a);
		}
		
		
		System.out.println("看SessionVector");
		Vector<String> SS1 =  sessionVector.getSessionVector();
		for(String a:SS1){
			System.out.println(a);
		}
		System.out.println("看SessionFinishedVector");
		Vector<String> SS2 =  sessionVector.getSessionFinishedVector();
		for(String a:SS2){
			System.out.println(a);
		}
		System.out.println("看SessionCreateTempVector");
		Vector<String> SS3 =  sessionVector.getSessionCreateTempVector();
		for(String a:SS3){
			System.out.println(a);
		}
		System.out.println("看SessionJobCreateTempVector");
		Vector<String> SS4 =  sessionVector.getSessionJobCreateTempVector();
		for(String a:SS4){
			System.out.println(a);
		}
		System.out.println("看SessionrunningTimeVector");
		Vector<String> SS5 =  sessionVector.getSessionrunningTimeVector();
		for(String a:SS5){
			System.out.println(a);
		}System.out.println("看SessionrunVector");
		Vector<String> SS6 =  sessionVector.getSessionrunVector();
		for(String a:SS6){
			System.out.println(a);
		}
		
		//stage  有残留
//		System.out.println("看TaskDetailTempVector");
//		Vector<String> SS1 =  stageVector.getTaskDetailTempVector();
//		for(String a:SS1){
//			System.out.println(a);
//		}
//		System.out.println("看RelTaskAllVector");
//		Vector<String> SS12 =  stageVector.getRelTaskAllVector();
//		for(String a:SS1){
//			System.out.println(a);
//		}
//		System.out.println("看RelTask2OneTaskVector");
//		Vector<String> SS3 =  stageVector.getRelTask2OneTaskVector();
//		for(String a:SS1){
//			System.out.println(a);
//		}
//		System.out.println("看RelTaskTaskInfoTempVector");
//		Vector<String> SS4 =  stageVector.getRelTaskTaskInfoTempVector();
//		for(String a:SS1){
//			System.out.println(a);
//		}
//		System.out.println("看RelTaskStageInfoTempVector");
//		Vector<String> SS5 =  stageVector.getRelTaskStageInfoTempVector();
//		for(String a:SS1){
//			System.out.println(a);
//		}
		
		//Task
//		System.out.println("看TaskVector");
//		Vector<String> SS1 =  taskVector.getTaskVector();
//		for(String a:SS1){
//			System.out.println(a);
//		}
//		System.out.println("看TaskFinishedVector");
//		Vector<String> SS2 =  taskVector.getTaskFinishedVector();
//		for(String a:SS2){
//			System.out.println(a);
//		}
//		System.out.println("看TaskInfoTempVector");
//		Vector<String> SS3 =  taskVector.getTaskInfoTempVector();
//		for(String a:SS3){
//			System.out.println(a);
//		}
//		System.out.println("看TaskStartTempVector");
//		Vector<String> SS4 =  taskVector.getTaskStartTempVector();
//		for(String a:SS4){
//			System.out.println(a);
//		}
//		System.out.println("看TaskEndTimeVector");
//		Vector<String> SS5 =  taskVector.getTaskEndTimeVector();
//		for(String a:SS5){
//			System.out.println(a);
//		}
//		System.out.println("看TaskfinishedCheckTempSet");
//		Vector<String> SS6 =  taskVector.getTaskfinishedCheckTempSet();
//		for(String a:SS6){
//			System.out.println(a);
//		}
		
		
	}
}
