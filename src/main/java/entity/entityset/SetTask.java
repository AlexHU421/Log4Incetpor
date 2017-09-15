package entity.entityset;

public class SetTask {
	private String TaskID;
	private String Task;
	public String getTaskID() {
		return TaskID;
	}
	public void setTaskID(String taskID) {
		TaskID = taskID;
	}
	public String getTask() {
		return Task;
	}
	public void setTask(String task) {
		Task = task;
	}
	@Override
	public String toString() {
		return "Task [TaskID=" + TaskID + ", Task=" + Task + "]";
	}
}
