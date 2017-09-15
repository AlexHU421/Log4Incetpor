package entity;

public class Job {
	private final static String separator = ":this is separator:";
	
	
	private String JobId;
	private String SQL;
	private String FinalStageId;
	private String StagesID;
	
	
	private String JobInfo;
	
	
	public void setJobInfo(
								Long LogTime,
								String SQL,
								String JobId,
								String FinalStageId,
								String[] StageId){
		String temp = "";
		int i=0;
		for (String str:StageId){
			i++;
			if (i<StageId.length){
				temp=temp+str+",";
			}
			if (i==StageId.length){
				temp=temp+str;
			}
		}
		JobInfo = LogTime+separator
				   +SQL+separator
				   +JobId+separator
				   +FinalStageId+separator
				   +temp;
	}


	public String getJobId() {
		return JobId;
	}


	public void setJobId(String jobId) {
		JobId = jobId;
	}


	public String getSQL() {
		return SQL;
	}


	public void setSQL(String sQL) {
		SQL = sQL;
	}


	public String getFinalStageId() {
		return FinalStageId;
	}


	public void setFinalStageId(String finalStageId) {
		FinalStageId = finalStageId;
	}


	public String getStagesID() {
		return StagesID;
	}


	public void setStagesID(String stagesID) {
		StagesID = stagesID;
	}


	public String getJobInfo() {
		return JobInfo;
	}
	
	
	
	
//	public static void main(String[] args) {
//		Job job = new Job();
//		job.setJobInfo(4L, "select id from esm_sys_role limit 1", "3126977", "3080830", new String[] {"3080830","3080831","3080832"});
//		System.out.println(job.getJobInfo());
//	}
	
	
	


	
	
	
}
