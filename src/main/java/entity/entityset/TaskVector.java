package entity.entityset;

import java.util.Vector;

public class TaskVector {
	Vector<String> TaskVector = new Vector<String>();
	Vector<String> TaskFinishedVector = new Vector<String>();
	Vector<String> TaskFinishedCheckErrorVector = new Vector<String>();
	Vector<String> TaskInfoTempVector = new Vector<String>();
	Vector<String> TaskStartTempVector = new Vector<String>();
	Vector<String> TaskEndTimeVector = new Vector<String>();
	Vector<String> TaskfinishedCheckTempSet = new Vector<String>();
	
	
	public Vector<String> getTaskfinishedCheckTempSet() {
		return TaskfinishedCheckTempSet;
	}

	public void setTaskfinishedCheckTempSetByKey(String Key) {
		TaskfinishedCheckTempSet.add(Key);
	}
	
	public boolean RemoveTaskfinishedCheckTempSetByKey (String Key){
		return TaskfinishedCheckTempSet.remove(Key);
	}
	
	
	
	
	
	public Vector<String> getTaskStartTempVector() {
		return TaskStartTempVector;
	}

	public void setTaskStartTempVectorByKey(String Key) {
		TaskStartTempVector.add(Key);
	}
	
	public boolean RemoveTaskStartTempVectorByKey (String Key){
		return TaskStartTempVector.remove(Key);
	}
	
	
	
	public Vector<String> getTaskEndTimeVector() {
		return TaskEndTimeVector;
	}

	public void setTaskEndTimeVector(String Key) {
		TaskEndTimeVector.add(Key);
	}
	
	public boolean RemoveTaskEndTimeVectorByKey (String Key){
		return TaskEndTimeVector.remove(Key);
	}
	
	
	public Vector<String> getTaskInfoTempVector() {
		return TaskInfoTempVector;
	}

	public void setTaskInfoTempVectorByKey(String Key) {
		TaskInfoTempVector.add(Key);
	}
	
	public boolean RemoveTaskInfoTempVectorByKey (String Key){
		return TaskInfoTempVector.remove(Key);
	}
	
	
	public Vector<String> getTaskFinishedCheckErrorVector() {
		return TaskFinishedCheckErrorVector;
	}

	public void setTaskFinishedCheckErrorVectorByKey(String Key) {
		TaskFinishedCheckErrorVector.add(Key);
	}
	
	public void RemoveTaskFinishedCheckErrorVector (){
		TaskFinishedCheckErrorVector.removeAllElements();
	}
	
	
	
	
	public Vector<String> getTaskFinishedVector() {
		return TaskFinishedVector;
	}
//!
	public void setTaskFinishedVectorByKey(String Key) {
		TaskFinishedVector.add(Key);
	}
	
	public void RemoveTaskFinishedVector (){
		TaskFinishedVector.removeAllElements();
	}

	

	public Vector<String> getTaskVector() {
		return TaskVector;
	}

	public void setTaskVectorByKey(String Task) {
		TaskVector.add(Task);
	}
	
	public boolean RemoveTaskVectorByKey (String Key){
		return TaskVector.remove(Key);
	}
	
}
