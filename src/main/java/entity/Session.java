package entity;

public class Session {
	private final static String separator = ":this is separator:";

	private String SessionID;
	private String RegularId;
	private String SQL;
	private String JobStartTime;
	private String JobEndTime;
	private String FinishDetail;
	private boolean SessionRunStatus;
	
	private String SessionCreate;
	private String JobCreate;
	private String SessionMateJob;
	private String SessionJobFinished;
	private String SessionEndDetail;
	private boolean SessionEndCheck;
	
	
	private String Session;
	
	
	public String getSessionMateJob() {
		return SessionMateJob;
	}





	public void setSessionMateJob(String sessionMateJob) {
		SessionMateJob = sessionMateJob;
	}





	public boolean SessionMateJob(String SessionCreate,String JobCreate,Job job){
		String jobinfo = job.getJobInfo();
		String DetailTemp = SessionCreate;
		String SessionId  = "";
		String RegularId = "";
		String SQL = "";
		String JRegularId  = "";
		String JOBID  = "";
		String JStageID  = "";
		String JobSQL  = "";
		String JobID  = "";
		String JobFinalStageID  = "";
		String JobStagesID = "";
		try{
			String[] d1 = SessionCreate.split(separator);
			SessionId = d1[1];
			RegularId = d1[2];
			SQL = d1[3];
			String[] d2 = JobCreate.split(separator);
			JRegularId = d2[1];
			JOBID = d2[2];
			JStageID = d2[3];
			String[] d3 = jobinfo.split(":JobINFO:");
			JobSQL = d3[1];
			JobID = d3[2];
			JobFinalStageID = d3 [3];
			JobStagesID = d3[4];
		}catch (ArrayIndexOutOfBoundsException e){
		}catch (Exception e){			
		}
		if (SessionCreate!=null&&JobCreate!=null){
			if (SessionId!=""&&RegularId!=""&&JRegularId!=""&&JOBID!=""&&JStageID!=""){
				if(RegularId.equals(JRegularId)&&(SQL.equals(JobSQL))&&JobFinalStageID.equals(JStageID)){
					String SessionMateJob = SessionCreate+separator
											+JobID+separator
											+JobFinalStageID+separator
											+JobStagesID;
					System.out.println(SessionMateJob);
					this.setSessionMateJob(SessionMateJob);
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Session se = new Session();
		se.setSessionCreate(1L, "31723f4b-2996-47c4-baf8-a5849b594440", "19d5ab1a78ffbfba", "select id from esm_sys_role limit 1");
		se.setJobCreate(2L, "19d5ab1a78ffbfba", "3126977", "3080830");
//		Job job = new Job();
//		job.setJobInfo(4L, "select id from esm_sys_role limit 1", "3126977", "3080830", new String[] {"3080830","3080830"});
		System.out.println(se.SessionMateJob(se.getSessionCreate(), se.getJobCreate()));
			
	}
	
	public boolean SessionMateJob(String SessionCreate,String JobCreate){
//		String jobinfo = job.getJobInfo();
		String DetailTemp = SessionCreate;
		String SessionId  = "";
		String RegularId = "";
		String SQL = "";
		String JRegularId  = "";
		String JOBID  = "";
		String JFinalyStageID  = "";
		try{
			String[] d1 = SessionCreate.split(separator);
			SessionId = d1[1];
			RegularId = d1[2];
			SQL = d1[3];
			String[] d2 = JobCreate.split(separator);
			JRegularId = d2[1];
			JOBID = d2[2];
			JFinalyStageID = d2[3];
		}catch (ArrayIndexOutOfBoundsException e){
			return false;
		}catch (Exception e){
			return false;
		}
		if (SessionCreate!=null&&JobCreate!=null){
			if (SessionId!=""&&RegularId!=""&&JRegularId!=""&&JOBID!=""&&JFinalyStageID!=""){
				if(RegularId.equals(JRegularId)){
					String SessionMateJob = SessionCreate+separator
											+JOBID+separator
											+JFinalyStageID;
					System.out.println(SessionMateJob);
					this.setSessionMateJob(SessionMateJob);
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	public String getSession() {
		return Session;
	}
//1	public void setSession(String setSessionCreate,,,,,) {
//		Session = session;
//	}




	public String getSessionCreate() {
		return SessionCreate;
	}
	public void setSessionCreate(
		 						 Long LogTime,
		 						 String SessionID,
		 						 String RegularId,
		 						 String SQL){
		SessionCreate = LogTime+separator
						+SessionID+separator
						+RegularId+separator
						+SQL;
		
		
	}
	public String getJobCreate() {
		return JobCreate;
	}
	public void setJobCreate(
		 					 Long LogTime,
		 					 String RegularId,
		 					 String JobId,
		 					 String Topo){
		JobCreate = LogTime+separator
					+RegularId+separator
					+JobId+separator
					+Topo;
	}
	public String getSessionJobFinished() {
		return SessionJobFinished;
	}
	public void setSessionJobFinished(
		 							  Long LogTime,
		 							  String FinishedJobSessionId,
		 							  String FinishDetail){
		SessionJobFinished = LogTime+separator
							 +FinishedJobSessionId+separator
							 +FinishDetail;
	}
	public String getSessionEndDetail() {
		return SessionEndDetail;
	}
	public void setSessionEndDetail(
									Long LogTime,
									String JobRunTimeSessionID,
									String JobStartTime,
									String JobEndTime){
		SessionJobFinished = LogTime+separator
							 +JobRunTimeSessionID+separator
							 +JobStartTime+separator
							 +JobEndTime;
}
	private String FinishedJobCheckSessionIdDetail = "";
	public void setSessionEndCheck(
								   Long LogTime,
								   String FinishedJobCheckSessionId,
								   boolean SessionRunStatus){
		
		if (SessionRunStatus){
			FinishedJobCheckSessionIdDetail = LogTime+separator+FinishedJobCheckSessionId+separator+true;
		}else{
			FinishedJobCheckSessionIdDetail = LogTime+separator+FinishedJobCheckSessionId+separator+false;	
		}
		
	
}
	
	public String getSessionEndCheck(){
		return FinishedJobCheckSessionIdDetail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public String SetJobCreate(
//			   Long LogTime,
//			   String RegularId,
//			   String JobId,
//			   String Topo){
//return LogTime+separator
//			+RegularId+separator
//			+JobId+separator
//			+Topo;
//}

	
	
	
}

