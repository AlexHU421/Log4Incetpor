package entity.RegexLib;


import entity.Job;
import entity.Stage;
import entity.entityset.SessionVector;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;
import util.metaRows4Row;

public class DAGRegexLib {
	private String[] sz1;
	private String[] sz2;
	
	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private Job job =  new Job();
	private Stage stage = new Stage();
	private metaRows4Row mr = new metaRows4Row();
	public void FilterDetail4RegexLib (String Key,String row,Long LogTime,String LogType,SessionVector sessionVector,StageVector stageVector,TaskVector taskVector){
//		System.out.print("LogTime:"+LogTime);
//		System.out.print(" LogType:"+LogType);
		
		
		if ("Job".equals(Key)){
			sz1 =  row.split("(Job \\:)");
			sz2 = sz1[1].split("\\, JobId \\: ");
//					System.out.print(" SQL:"+sz2[0]);
					str1 = sz2[0].substring(1, sz2[0].length());
			sz1 = sz2[1].split("\\, FinalStageId \\: ");
//					System.out.print(" JobID:"+sz1[0]);
					str2 = sz1[0];
			sz2 = sz1[1].split("\\, All StageId \\: \\[");
//					System.out.print(" FinalStageId:"+sz2[0]);
					str3 = sz2[0];
			sz1 = (sz2[1].substring(0, (sz2[1].length()-1))).split(",");
//			for (int i = 0;i<sz1.length;i++){
//					if (i==sz1.length-1){
//						System.out.println(" StageId:"+sz1[i]);
//					}else{
//						System.out.print(" StageId:"+sz1[i]);
//					}
//			}
			job.setJobInfo(LogTime, str1, str2, str3, sz1);
			mr.metaRows2Set("jobCreate", sessionVector, str2, job.getJobInfo());
//			System.out.println(job.getJobInfo());
			//获取到Job详细，获取当前最新SessionSet进行二次、三次判断分别判断SQL是否相同，StageID（JOB中为FINALEDSTAGEID)是否一致，若一致存入完整匹配上session-JOBID的SET供后面继续做Session的使用
			
		}
		if ("StageFinish".equals(Key)){
			sz1 = row.split("(\\(\\)\\] \\- Stage )");
			sz2 = sz1[1].split(" \\(runJob");
//				System.out.print(" finishStageId:"+sz2[0]);
//				System.out.println(" finishStageStatus: Stage "+sz1[1]);
			stage.SetFinishedStageID(LogTime, sz2[0], true);
			str4 = stage.getFinishedStageID();
			taskVector.setTaskfinishedCheckTempSetByKey(str4);
//			System.out.println("Stage-FinishedStageID:"+stage.getFinishedStageID());
		}
	
	}
//	public static void main(String[] args) {
//		 String row1 = "2017-07-27 08:44:13,415 INFO  scheduler.DAGScheduler: (Logging.scala:logInfo(59)) [sparkDriv	er-akka.actor.default-dispatcher-74()] - [Leviathan] Job : select id from esm_sys_role limit 1, JobId : 3126977, FinalStageId : 3080830, All StageId : [3080830]";
//		 String row2 = "2017-07-27 08:44:13,515 INFO  scheduler.DAGScheduler: (Logging.scala:logInfo(59)) [sparkDriver-akka.actor.default-dispatcher-54()] - Stage 3080830 (runJob at FileSinkOperator.scala:223) finished in 0.098 s";
//		 DAGRegexLib lr = new DAGRegexLib();
//		  String rows = row2;
//		  String row = "";
//		  lr.FilterDetail4RegexLib("StageFinish",rows,"","");
//	}
	
	
	
}
