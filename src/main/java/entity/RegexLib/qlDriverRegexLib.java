package entity.RegexLib;

import java.util.regex.Pattern;

import entity.Session;
import entity.entityset.SessionVector;
import util.metaRows4Row;

public class qlDriverRegexLib {
	private String[] sz1;
	private String[] sz2;
	
	
	private String str1;
	private String str2;
	private String str3;
	private Session session = new Session();
	private metaRows4Row mr = new metaRows4Row();
	
	
	public void FilterDetail4RegexLib (String Key,String row,Long LogTime,String LogType,Object obj,SessionVector sessionVector){
//		System.out.print("LogTime:"+LogTime);
//		System.out.print(" LogType:"+LogType);
		if ("JobTime".equals(Key)){
			sz1 =  row.split("SessionHandle\\=");
			sz2 =  sz1[1].split("\\)\\] \\- \\<\\/PERFLOG");
//				System.out.println(" JobRunTimeSessionID:"+sz2[0]);
//				System.out.println(" JobRunTimeSessionID:"+sz2[1]);
				str1 = sz2[0];
			sz1 = sz2[1].split("start\\=");
			sz2 = sz1[1].split(" end\\=");
//				System.out.print(" JobStartTime:"+sz2[0]);
				str2 = sz2[0];
//				System.out.println(" JobEndTime:"+(sz2[1].split(" duration=")[0]));
				str3 = sz2[1].split(" duration=")[0];
			session.setSessionEndDetail(LogTime, str1, str2, str3);
			sessionVector.setSessionrunningTimeVectorByKey(session.getSessionJobFinished());
			mr.metaRows2Set("srunning", sessionVector, str1, session.getSessionJobFinished());
//			System.out.println("Session-SessionEndDetail:"+session.getSessionJobFinished());
			//记录二次Job完成信息，并根据对应sesion记录JOB发起时间及结束时间，同时判断是否存在Sessionfinished记录进行二次匹配并判断该任务是否为SUCCEEDED状态还是FAILED状态
		}
		if ("SessionEnd".equals(Key)){ 
			sz1 =  row.split("SessionHandle\\=");
			sz2 = sz1[1].split("\\)\\] - ");
			if (Pattern.compile("Restore the configuration ngmr\\.exec").matcher(sz2[1]).find()){
//				System.out.println(" FinishedJobCheckSessionId:"+sz2[0]);
				str1 = sz2[0];
				session.setSessionEndCheck(LogTime, str1, true);
				mr.metaRows2Set("checkEnd", sessionVector, str1,session.getSessionEndCheck());
//				System.out.println("Session-SessionEndCheck:"+session.getSessionEndCheck());
			//记录三次JOB完成信息，对二次完成的信息做一个CHECK并将匹配完成的session信息从sessionSet中抽出保存到FinishedSessionSet中 
			}
	}
	}
	
	
	
	
//	public static void main(String[] args) {
//		  String rows1 = "2017-07-27 08:44:13,547 INFO  ql.Driver: (PerfLogger.java:PerfLogEnd(133)) [HiveServer2-Handler-Pool: Thread-8169627(SessionHandle=31723f4b-2996-47c4-baf8-a5849b594440)] - </PERFLOG method=Driver.run start=1501116253223 end=1501116253547 duration=324>";
//		  String rows2 = "2017-07-27 08:44:13,548 INFO  ql.Driver: (Driver.java:restoreDriverConfiguration(1616)) [HiveServer2-Handler-Pool: Thread-8169627(SessionHandle=31723f4b-2996-47c4-baf8-a5849b594440)] - Restore the configuration ngmr.exec.mode to cluster";
//		  qlDriverRegexLib lr = new qlDriverRegexLib();
//			  String rows = rows2;
//			  String row = "";
//			  lr.FilterDetail4RegexLib("SessionEnd",rows,"","");
//	}	
}
