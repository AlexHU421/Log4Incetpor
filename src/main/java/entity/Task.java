package entity;

import java.util.Vector;

public class Task {
	//用于匹配的JobId
	private String JobID;
	//用于匹配的StageId  二次比对确定对应正确性
	private String StageID;
	private String TaskID;
	private String TaskAllotNodeName;
	private String TaskRunPriority;
	private String TaskRunSize;
	private String TaskRunningTime;
	private String TaskRunningNodeName;
	
	
//	private String MethodTempStr;
	private final static String separator = ":this is separator:";
	
	private String TaskStartINFO;
	private String TaskEndINFO;
	private String Task;
	
	private String TaskRunningDetail;
	private String OtherTaskRunningDetail;
	
//	public void setTask(String TaskStartINFO,String TaskEndINFO,String TaskRunningDetail){
//		Task = TaskStartINFO+":this is separator:"+TaskEndINFO+"this is separator"+TaskRunningDetail;
//	}
	
	public String getTask() {
		return Task;
	}

	public String getTaskStartINFO() {
		return TaskStartINFO;
	}


	public String getTaskEndINFO() {
		return TaskEndINFO;
	}




	public String getOtherTaskRunningDetail() {
		return OtherTaskRunningDetail;
	}




	public String getJobID() {
		return JobID;
	}


	public void setJobID(String jobID) {
		JobID = jobID;
	}


	public String getStageID() {
		return StageID;
	}


	public void setStageID(String stageID) {
		StageID = stageID;
	}


	public String getTaskID() {
		return TaskID;
	}


	public void setTaskID(String taskID) {
		TaskID = taskID;
	}


	public String getTaskAllotNodeName() {
		return TaskAllotNodeName;
	}


	public void setTaskAllotNodeName(String taskAllotNodeName) {
		TaskAllotNodeName = taskAllotNodeName;
	}


	public String getTaskRunPriority() {
		return TaskRunPriority;
	}


	public void setTaskRunPriority(String taskRunPriority) {
		TaskRunPriority = taskRunPriority;
	}


	public String getTaskRunSize() {
		return TaskRunSize;
	}


	public void setTaskRunSize(String taskRunSize) {
		TaskRunSize = taskRunSize;
	}


	public String getTaskRunningTime() {
		return TaskRunningTime;
	}


	public void setTaskRunningTime(String taskRunningTime) {
		TaskRunningTime = taskRunningTime;
	}


	public String getTaskRunningNodeName() {
		return TaskRunningNodeName;
	}


	public void setTaskRunningNodeName(String taskRunningNodeName) {
		TaskRunningNodeName = taskRunningNodeName;
	}
	
	

	public String getTaskRunningDetail() {
		return TaskRunningDetail;
	}


	public void setTaskRunningDetail(String taskRunningDetail) {
		TaskRunningDetail = taskRunningDetail;
	}



	public void SetTaskStartINFO(
									Long LogTime,											 
									String stageID,
									String taskID,
									String taskAllotNodeName,
									String taskRunPriority,
									String taskRunSize){
		TaskStartINFO = LogTime+separator
					  +stageID+separator
					  +taskID+separator
					  +taskAllotNodeName+separator
					  +taskRunPriority;
	}
	
	
	public void setTaskEndINFO(
								  Long LogTime,
								  String stageID,
								  String taskID,
								  String taskRunningTime,
								  String TaskRunningNodeName,
								  String StageInsideTaskNum){
		TaskEndINFO = LogTime+separator
					  +stageID+separator
					  +taskID+separator
					  +taskRunningTime+separator
					  +TaskRunningNodeName+separator
					  +StageInsideTaskNum;
	}
	

	

	public void setTaskRunningDetail(
									Long LogTime,
									String Leviathan,
									String TaskJobId,
									String TaskStageId,
									String TotalTask,
									String TaskDetail1){
		TaskRunningDetail =  LogTime+separator
				+Leviathan+separator
				+TaskJobId+separator
				+TaskStageId+separator
				+TotalTask+separator
				+TaskDetail1;
}

	public void setOtherTaskRunningDetail(
									Long LogTime,
									String Leviathan,
									String OtherTaskDetail){
		OtherTaskRunningDetail = LogTime+separator
				+Leviathan+separator
				+OtherTaskDetail;
}

	

	
	public String mergeTaskRunningDetail(String TaskRunningDetail1,String OtherTaskRunningDetail){
		String DetailTemp = TaskRunningDetail1;
		String d1S  = "";
		String d2a  = "";
		String d2b  = "";
		try{
			d1S = TaskRunningDetail1.split(separator)[1];
			String[] d2 = OtherTaskRunningDetail.split(separator);
			d2a = d2[1];
			d2b = d2[2];
		}catch (ArrayIndexOutOfBoundsException e){
		}catch (Exception e){			
		}
		if (TaskRunningDetail1!=null&&d1S!=""){
			if (OtherTaskRunningDetail!=null&&d2a!=""&&d2a.equals(d1S)&&d2b!=""){
				DetailTemp=DetailTemp+"\\\\r"+d2b;
//				System.out.println(DetailTemp);
				return DetailTemp;
			}
			return DetailTemp;
		}
		return DetailTemp;
	}
	
//	public static void main(String[] args) {
//	Task task = new Task();
//	task.SetTaskStartINFO(1L, "a", "b", "c", "d", "e");
//	task.setTaskEndINFO(2L, "a", "2", "c", "4");
//	task.setTaskRunningDetail(3L, "1", "2222", "2333", "xyz");
//	task.setOtherTaskRunningDetail(4L, "1", "zaw");
//	task.setTaskRunningDetail(task.mergeTaskRunningDetail(task.getTaskRunningDetail(),task.getOtherTaskRunningDetail()));
//	task.setOtherTaskRunningDetail(5L, "1", "gaads");
//	task.setTaskRunningDetail(task.mergeTaskRunningDetail(task.getTaskRunningDetail(),task.getOtherTaskRunningDetail()));
//	String  a = task.getTaskStartINFO();
//	String  b = task.getTaskEndINFO();
//	String  c = task.getTaskRunningDetail();
//	task.setTask(a, b, c);
//	System.out.println("TASK:    "+task.getTask());
//}
}