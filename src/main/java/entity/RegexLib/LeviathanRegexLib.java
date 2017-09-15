package entity.RegexLib;


import java.util.Vector;

import entity.Session;
import entity.Task;
import entity.entityset.SessionVector;
//import entity.entityset.SetSession;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;
import util.metaRows4Row;

public class LeviathanRegexLib {
//	public SessionVector sessionVector;
//	public TaskVector taskVector;
//	private String Sessionregex = "(SessionHandle\\=.*\\)\\])";
//	private String Threadregex = "(Thread-)";
	  //SessionSQLRows
	  private static String SessionID ="(SessionHandle\\=)";
	  //SessionSQLRows、Topo
	  private static String RegularId ="(RegularId\\: )";
	  //SessionSQLRows
	  private static String SQL ="(JobNo\\: \\d+ SQL\\: )";
	  //Topo
	  private static String JobId ="(Extra Info\\: Job )";
	  //Topo  →等同于DAG中FinalyStageId
//	  private static String TopoId ="(Topo\\: )";
	  //TaskDetailRowsFilter 123  在保证利维坦值相同的情况下，进行下一步判断，否则无法确定是否为连续数据
	  private static String Leviathan ="(\\[Leviathan\\]\\[)";
	  //TaskDetailRows 1
	  private static String TaskJobId ="(Job\\: )";
	  //TaskDetailRows 1	  
	  private static String TaskStageId ="( Stage\\: )";
	  //TaskDetailRows 1
	  private static String TaskDetail1 ="( Duration\\: )";
	  //TaskDetailRows 2
	  private static String TaskDetail2 ="(\\]Statistics TaskTime\\: )";
	  //TaskDetailRows 3
	  private static String TaskDetail3 ="(\\]Executors num\\:)";
	  
	  private String[] sz1;
	  private String[] sz2;
	  private String str1;
	  private String str2;
	  private String str3;
	  private String str4;
	  private String str5;
//	  public String getLeviathanTaskDetailRowsFilter(String row){
//			return Leviathan;
//	  }
	  private Session session = new Session();
	  private Task task = new Task();
	  private metaRows4Row mr = new metaRows4Row();
//	  
//	  private void LeviathanRegexLib(){
//			
//		}
//		public LeviathanRegexLib(SessionVector sessionVector,TaskVector taskVector){
//			this.sessionVector=sessionVector;
//			this.taskVector=taskVector;
//			this.LeviathanRegexLib();
//		}
	
	public void FilterDetail4RegexLib (String Key,String row,Long LogTime,String LogType,SessionVector sessionVector,TaskVector taskVector,StageVector stageVector){//
//		System.out.print("LogTime:"+LogTime);
//		System.out.print(" LogType:"+LogType);
		
		
		if ("SessionSQLRows".equals(Key)){
			sz1 =  row.split(SessionID);
			sz2 =  sz1[1].split("\\)\\]");
//			System.out.print(" SessionID:"+sz2[0]);
				str1 = sz2[0];
			sz1 = sz2[1].split(RegularId);
			sz2 = sz1[1].split(" Ex");
//			System.out.print(" RegularId:"+sz2[0]);
				str2 = sz2[0];
//			System.out.println("SQL:"+sz2[1].split(SQL)[1]);
				str3 = sz2[1].split(SQL)[1];
				str3 = str3.substring(0, str3.length()-1);
				session.setSessionCreate(LogTime, str1,str2,str3);
//				System.out.println("Session-SessionCreate:"+session.getSessionCreate());
				//SessionID为SessionID，Session为SessionCreate整个String语，以制定分隔符划分
				sessionVector.setSessionCreateTempVectorByKey(session.getSessionCreate());
		}
		if("Topo".equals(Key)){
			sz1 =  row.split(RegularId);
			sz2 = sz1[1].split(" Ex");
//				System.out.print(" RegularId:"+sz2[0]);
				str1 = sz2[0];
			sz1 = sz2[1].split(JobId);
			sz2 = sz1[0].split(" ");
//				System.out.print(" JobId:"+sz2[3]);
				str2 = sz2[3];
//				System.out.println(" Topo:"+sz2[5].split("<-")[0]);
				str3 = sz2[5].split("<-")[0];
				session.setJobCreate(LogTime, str1, str2, str3);
//				System.out.println(session.getJobCreate());
//				System.out.println("Session-JobCreate:"+session.getJobCreate());
				sessionVector.setSessionJobCreateTempVectorByKey(session.getJobCreate());
		}
		if("TaskDetailRows1".equals(Key)){
			sz1 =  row.split(Leviathan);
			sz2 = sz1[1].split("]");
//				System.out.print(" Leviathan："+sz2[0]);
				str1 = sz2[0];
			sz1 = (" "+sz2[1]).split(TaskJobId);
			sz2 = sz1[1].split(" Stage:");
//				System.out.print(" TaskJobId:"+sz2[0]);
				str2 = sz2[0];
			sz1 = (" Stage:"+sz2[1]).split(TaskStageId);
			sz2 = sz1[1].split(".0 Duration:");
//				System.out.print(" TaskStageId:"+sz2[0]);
				str3 = sz2[0];
//				System.out.println(" TaskDetail1：{"+" Duration:"+sz2[1]+"}");
				str5 = "Duration:{"+sz2[1]+"}";
			str4 = sz2[1].split("TaskCount\\: ")[1].split(" ShufRead: ")[0];
				task.setTaskRunningDetail(LogTime, str1, str2, str3, str4,str5);
				taskVector.setTaskInfoTempVectorByKey(task.getTaskRunningDetail());
				stageVector.setTotalTaskVectorByKey(str2, str3, str4);
				mr.metaRows2Set("saveTotal",str2,str3,str4,sessionVector,stageVector);
//				System.out.println(task.getTaskRunningDetail());
				//判断获取Task明细行第一行，存入Taskset中（是否需要进行判断为哪个JOB下？的哪个Stage下？的Task进行根据相应内容保存？？）——
		}
		if("TaskDetailRows2".equals(Key)){
			sz1 =  row.split(Leviathan);
			sz2 = sz1[1].split("]Statistics");
//				System.out.print(" Leviathan："+sz2[0]);
				str1 = sz2[0];
//				System.out.println(" TaskDetail2:"+"  Statistics{"+sz2[1]+"}");
				str2 = "Statistics:{"+sz2[1]+"}";
				task.setOtherTaskRunningDetail(LogTime, str1, str2);
				mr.metaRows2Set("detail",taskVector,task.getOtherTaskRunningDetail(),"");
//				System.out.println("Tash-TaskRunningDetail  2 :"+task.getOtherTaskRunningDetail());
				//获取到第二段Task明细，采用与SessionID匹配JobID相同的判断方法，获取一个当前最新的TaskSet，循环集合读取其中Task明细，当Leviathan值相同时，则合并存入到一起（合并存入的判断逻辑已经在entity.Task中有相应合并方法）
					
		}
		if("TaskDetailRows3".equals(Key)){
			sz1 =  row.split(Leviathan);
			sz2 = sz1[1].split("]Executors ");
//				System.out.print(" Leviathan："+sz2[0]);
				str1 = sz2[0];
//				System.out.println(" TaskDetail3:"+"  Executors{"+sz2[1]+"}");
				str2 = "Executors:{"+sz2[1]+"}";
				task.setOtherTaskRunningDetail(LogTime, str1, str2);
				mr.metaRows2Set("detail",taskVector, task.getOtherTaskRunningDetail(),"3");
				mr.metaRows2Set("end", stageVector,taskVector, "","");
//				System.out.println("Tash-TaskRunningDetail  3 :"+task.getOtherTaskRunningDetail());
				//获取到第三段Task明细，采用与SessionID匹配JobID相同的判断方法，获取一个当前最新的TaskSet，循环集合读取其中Task明细，当Leviathan值相同时，则合并存入到一起（合并存入的判断逻辑已经在entity.Task中有相应合并方法）
		}
	}
	
	public String[] Filter2RegexLib(){
		return new String[] {TaskDetail1,TaskDetail2,TaskDetail3};
	}
	
//	public static void main(String[] args) {
//		  String rows11 = "2017-07-27 08:44:13,329 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [HiveServer2-Handler-Pool: Thread-8169627(SessionHandle=31723f4b-2996-47c4-baf8-a5849b594440)] - [Leviathan][18782315]RegularId: 19d5ab1a78ffbfba Extra Info: Session: 31723f4b-2996-47c4-baf8-a5849b594440 JobNo: 0 SQL: select id from esm_sys_role limit 1";
//		  String rows12 = "2017-07-27 08:44:13,415 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [sparkDriver-akka.actor.default-dispatcher-74()] - [Leviathan][18782318]RegularId: 19d5ab1a78ffbfba Extra Info: Job 3126977 Topo: 3080830<-[]";
//		  String rows21 = "2017-07-27 08:44:13,515 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782319]Job: 3126977 Stage: 3080830.0 Duration: 98 ms TaskTime: 70 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms"; 
//		  String rows22 = "2017-07-27 08:44:13,516 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782319]Statistics TaskTime: [70.0,70.0,70.0,70.0,70.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0]"; 
//		  String rows23 = "2017-07-27 08:44:13,516 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782319]Executors num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms";
//		  LeviathanRegexLib lr = new LeviathanRegexLib();
//		  String rows = rows23;
//		  String row = "";
//		  ArrayList<String> Detail = new ArrayList<String>();
//		  String [] ssz = lr.getLeviathanRowsRegexLib("TaskDetailRows1",rows);
//		  lr.FilterDetail4RegexLib("TaskDetailRows3",rows);
//		  for (String str:lr.getLeviathanRowsRegexLib("SessionSQLRows",rows)){
//			  System.out.println(str);
//			  matcher = p.compile(str).matcher(rows);
//			  }
//	}
}

