package controller;

import java.util.Timer;
import java.util.TimerTask;

import Log.FindInceptorLog;
import Timer.LogTimer;
import entity.rows;
import entity.entityset.ErrorVector;
import entity.entityset.SessionVector;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;

public class ControllerCollectLog {
	public static SessionVector sessionVector = new SessionVector();
	public static StageVector stageVector =  new StageVector();
	public static TaskVector taskVector =  new TaskVector();
	public static ErrorVector errorVector =  new ErrorVector();
	public static rows row = new rows();
	public static void main(String[] args) {
//		properties p = new properties();
		Timer mainTimer = new Timer();
		 TimerTask task = new LogTimer(sessionVector,stageVector,taskVector,errorVector,row); 
		mainTimer.schedule(task,200,480000);
	}
	
	
	
	
	
	
	
	
}
