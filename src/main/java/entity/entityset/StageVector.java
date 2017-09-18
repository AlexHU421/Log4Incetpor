package entity.entityset;

import java.util.Vector;

public class StageVector {
//	SetStage stage = new SetStage();
	Vector<String> TaskDetailTempVector = new Vector<String>();
	Vector<String> RelTaskAllVector = new Vector<String>();
	Vector<String> RelTask2OneTaskVector = new Vector<String>();
	Vector<String> RelTaskTaskInfoTempVector = new Vector<String>();
	Vector<String> RelTaskStageInfoTempVector = new Vector<String>();
	Vector<String> StagecheckErrorVector = new Vector<String>();
	Vector<String> TotalTaskVector = new Vector<String>();
	Vector<String> StageCheck2sessionVector = new Vector<String>();
	
	public Vector<String> getStageCheck2sessionVector() {
		return StageCheck2sessionVector;
	}

	public void setStageCheck2sessionVectorByKey(String Key) {
		StageCheck2sessionVector.add(Key);
	}
	
	public boolean RemoveStageCheck2sessionVectorByKey (String Key){
		return StageCheck2sessionVector.remove(Key);
	}
	
	

	public Vector<String> getTotalTaskVector() {
		return TotalTaskVector;
	}

	public void setTotalTaskVectorByKey(String key) {
		TotalTaskVector.add(key);
	}
	
	public boolean RemoveTotalTaskVectorByKey (String Key){
		return TotalTaskVector.remove(Key);
	}
	
	public Vector<String> getStagecheckErrorVectorVector() {
		return StagecheckErrorVector;
	}

	public void setStagecheckErrorVectorByKey(String Key) {
		StagecheckErrorVector.add(Key);
	}
	
	public void RemoveStagecheckErrorVector (){
		StagecheckErrorVector.removeAllElements();
	}
	
	
	public Vector<String> getRelTaskStageInfoTempVector() {
		return RelTaskStageInfoTempVector;
	}

	public void setRelTaskStageInfoTempVectorByKey(String Key) {
		RelTaskStageInfoTempVector.add(Key);
	}
	
	public void RemoveRelTaskStageInfoTempVector (){
		RelTaskStageInfoTempVector.removeAllElements();
	}
	
	
	public Vector<String> getRelTaskTaskInfoTempVector() {
		return RelTaskTaskInfoTempVector;
	}

	public void setRelTaskTaskInfoTempVectorByKey(String Key) {
		RelTaskTaskInfoTempVector.add(Key);
	}
	
	public void RemoveRelTaskTaskInfoTempVector (){
		 RelTaskTaskInfoTempVector.removeAllElements();
	}
	
	
	
	public Vector<String> getRelTask2OneTaskVector() {
		return RelTask2OneTaskVector;
	}

	public void setRelTask2OneTaskVectorByKey(String Key) {
		RelTask2OneTaskVector.add(Key);
	}
	
	public boolean RemoveRelTask2OneTaskVectorByKey (String Key){
		return RelTask2OneTaskVector.remove(Key);
	}
	
	
	
	public Vector<String> getRelTaskAllVector() {
		return RelTaskAllVector;
	}

	public void setRelTaskAllVectorByKey(String Key) {
		RelTaskAllVector.add(Key);
	}
	
	public void RemoveRelTaskAllVector (){
		RelTaskAllVector.removeAllElements();
	}
	public boolean RemoveRelTaskAllVectorByIndex (int index){
		return RelTaskAllVector.remove(index) != null;
	}
	
	
	public Vector<String> getTaskDetailTempVector() {
		return TaskDetailTempVector;
	}

	public void setTaskDetailTempVectorByKey(String Key) {
		TaskDetailTempVector.add(Key);
	}
	
	public boolean RemoveTaskDetailTempVectorByKey (String Key){
		return TaskDetailTempVector.remove(Key);
	}
	
	
	
	
	
	
	
	Vector<String> StageVector = new Vector<String>();
	Vector<String> StageCheckErrorVector = new Vector<String>();
//	Vector<SetStage> StageFinishedVector = new Vector<SetStage>();
//	
//	public Vector<SetStage> getStageFinishedVector() {
//		return StageFinishedVector;
//	}

//	public void setStageFinishedVectorByKey(String Key,String Stage) {
//		stage = new SetStage();
//		stage.setStageID(Key);
//		stage.setStage(Stage);
//		StageFinishedVector.add(stage);
//	}
	
//	public boolean RemoveStageFinishedVectorByKey (String Key){
//		return StageFinishedVector.remove(Key);
//	}
	
	public Vector<String> getStageCheckErrorVector() {
		return StageCheckErrorVector;
	}

	public void setStageCheckErrorVectorByKey(String Key) {
		StageCheckErrorVector.add(Key);
	}
	
	public void RemoveStageCheckErrorVector (){
		StageCheckErrorVector.removeAllElements();
	}
	
	
	public Vector<String> getStageVector() {
		return StageVector;
	}
//!
	public void setStageVectorByKey(String Key) {
		StageVector.add(Key);
	}
	
	public void RemoveStageVector (){
		StageVector.removeAllElements();
	}

	
}
