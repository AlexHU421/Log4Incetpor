package entity;

import java.util.Vector;

public class Stage {
	private final static String separator = ":this is separator:";
	private String StageID;
	private boolean finishStageStatus;
	private String FinishedStageID;
	
	public void SetFinishedStageID(
										Long LogTime,
										String finishStageId,
										boolean finishStageStatus){
		if (finishStageStatus){
			FinishedStageID = LogTime+separator+finishStageId+separator+true;
		}else{
			FinishedStageID = LogTime+separator+finishStageId+separator+false;	
		}
	}
	
	public String getFinishedStageID(){
		return FinishedStageID;
	}
	
	
//	public Vector<Object> SaveFinishedStage(Long LogTime,
//											){
//		return null;
//		
//	}
	public static void main(String[] args) {
		
	}
	
}



