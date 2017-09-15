package entity.RegexLib;

import java.util.regex.Pattern;

import entity.Session;
import entity.entityset.SessionVector;

public class ContextRegexLib {
	
	private String[] sz1;
	private String[] sz2;
	
	private Session session =  new Session();
	
	
	
	public void FilterDetail4RegexLib (String row,Long LogTime,String LogType,SessionVector sessionVector){
//		System.out.print("LogTime:"+LogTime);
//		System.out.print(" LogType:"+LogType);
			sz1 =  row.split("SessionHandle\\=");
			sz2 = sz1[1].split("\\)\\] - ");
			if (Pattern.compile("Job finished\\:").matcher(sz2[1]).find()){
//				System.out.print(" FinishedJobSessionId:"+sz2[0]);
//				System.out.println(" FinishDetail:"+sz2[1]);
				session.setSessionJobFinished(LogTime, sz2[0], sz2[1]);
//				System.out.println("Session-Jobfinished:"+session.getSessionJobFinished());
				//记录SessionFinished信息，并根据sessionID对SesionSet中对应session进行标记JOB完成的预标记等待二次匹配结果
			}
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		String row ="2017-07-27 08:44:13,515 INFO  inceptor.InceptorContext: (Logging.scala:logInfo(59)) [HiveServer2-Handler-Pool: Thread-8169627(SessionHandle=31723f4b-2996-47c4-baf8-a5849b594440)] - Job finished: runJob at FileSinkOperator.scala:223, took 0.101075596 s";
//		ContextRegexLib lr = new ContextRegexLib();
//		  lr.FilterDetail4RegexLib(row,"","");
//	}
}
