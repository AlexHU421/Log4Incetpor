package entity.RegexLib;


import entity.Task;
import entity.entityset.TaskVector;
import util.metaRows4Row;

public class TaskSetManagerRegexLib {
	private String[] sz1;
	private String[] sz2;

	
	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private Task task =  new Task();
	private metaRows4Row mr = new metaRows4Row();
	
	public void FilterDetail4RegexLib (String Key,String row,Long LogTime,String LogType,TaskVector taskVector){
//		System.out.print("LogTime:"+LogTime);
//		System.out.print(" LogType:"+LogType);
		if ("start".equals(Key)){
//			System.out.println(row);
			sz1 =  row.split(" in stage ");
			sz2 = sz1[1].split("\\.\\d+ \\(TID ");
//					System.out.print(" StageId:"+sz2[0]);
					str1 = sz2[0];
			sz1 = sz2[1].split("\\) in ");
			sz2 = sz1[0].split("\\, ");
//					System.out.print(" TaskId:"+sz2[0]);
//					System.out.print(" TaskStartNodeName:"+sz2[1]);
//					System.out.print(" TaskRunPriority:"+sz2[2]);
//					System.out.println(" TaskRunSize:"+sz2[3]);
					task.SetTaskStartINFO(LogTime, str1, sz2[0], sz2[1],sz2[2],sz2[3]);
//					System.out.println("Task-TaskStartINFO:"+task.getTaskStartINFO()); 
					taskVector.setTaskStartTempVectorByKey(task.getTaskStartINFO());
					//记录Task开始信息，并与最新的TaskSet进行匹配保存
		}
		if ("end".equals(Key)){
//			System.out.println(row);
			sz1 =  row.split(" in stage ");
			sz2 = sz1[1].split("\\.\\d+ \\(TID ");
//					System.out.print(" StageId:"+sz2[0]);
					str1 = sz2[0];
			sz1 = sz2[1].split("\\) in ");
//					System.out.print(" TaskId:"+sz1[0]);
					str2 = sz1[0];
			sz2 = sz1[1].split(" on ");
					str3 = sz2[0];
			sz1	=	sz2[1].split(" \\(");
					str4 = sz1[0];
			sz2 = 	sz1[1].split("\\/");
//					System.out.print(" TaskEndTime:"+sz2[0]);
//					System.out.println(" TaskEndNodeName:"+(sz2[1].split(" \\(\\d+\\/\\d+\\)")[0]));
					task.setTaskEndINFO(LogTime, str1, str2, str3, str4,(sz1[1].split("\\/")[0]));
					mr.metaRows2Set("startEnd", taskVector,task.getTaskEndINFO(),"");
//					System.out.println("Task-TaskEndINFO:"+task.getTaskEndINFO());
					//记录Task结束信息，与最新TaskSet进行匹配保存
					
	}
	}
	
	
	

//	public static void main(String[] args) {
//		TaskVector taskv = new TaskVector();
//		 String rows1 = "2017-07-27 08:44:13,417 INFO  scheduler.TaskSetManager: (Logging.scala:logInfo(59)) [sparkDriver-akka.actor.default-dispatcher-47()] - Starting task 0.0 in stage 3080830.0 (TID 3190016, dbclusternode016, NODE_LOCAL, 1357 bytes)";
//		 String rows2 = "2017-07-27 08:44:13,515 INFO  scheduler.TaskSetManager: (Logging.scala:logInfo(59)) [Result resolver thread-1()] - Finished task 0.0 in stage 3080830.0 (TID 3190016) in 98 ms on dbclusternode016 (1/1)";
//		 TaskSetManagerRegexLib lr = new TaskSetManagerRegexLib();
//		  String rows = rows2;
//		  String row = "";
//		  lr.FilterDetail4RegexLib("end",rows,1L,"",taskv);
//	}
	
	
}
