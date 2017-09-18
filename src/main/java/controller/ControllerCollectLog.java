package controller;

import java.util.Timer;
import java.util.TimerTask;

import Log.FindInceptorLog;
import Timer.LogTimer;
import entity.properties;
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
	public static properties p = new properties();
	public static int interval;
	public static void main(String[] args) {
		
		if (p.getInterval()<3){
			interval = 3;
		}else{
			interval = p.getInterval();
		}
		row.setOldStartTime(0L);
//		properties p = new properties();
		Timer mainTimer = new Timer();
		 TimerTask task = new LogTimer(sessionVector,stageVector,taskVector,errorVector,row); 
		mainTimer.schedule(task,200,(interval*60000));
	}
	
	
	
	
	
	
	
	
}
