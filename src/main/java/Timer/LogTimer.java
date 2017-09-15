package Timer;

import java.util.TimerTask;

import Log.FindInceptorLog;
import entity.rows;
import entity.entityset.ErrorVector;
import entity.entityset.SessionVector;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;

public class LogTimer extends TimerTask {
	public static SessionVector sessionVector;
	public static StageVector stageVector;
	public static TaskVector taskVector;
	public static ErrorVector errorVector;
	public static rows row;
	public LogTimer(){
	
	}
	
	public LogTimer(SessionVector sessionVector,StageVector stageVector,TaskVector taskVector,ErrorVector errorVector,rows row){
		this.sessionVector=sessionVector;
		this.stageVector=stageVector;
		this.taskVector=taskVector;
		this.errorVector=errorVector;
		this.row=row;
	}
	@Override
	public void run() {
		System.out.println(row.toString());
		FindInceptorLog findLog  = new FindInceptorLog(sessionVector,stageVector,taskVector,errorVector,row);
		findLog.main();
		
		 System.gc();
	}
	
}
