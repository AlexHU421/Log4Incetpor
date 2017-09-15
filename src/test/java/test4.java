import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.entityset.StageVector;
import entity.entityset.TaskVector;

public class test4 {
	private static String LID = "";
	private static String JID = "";
	private static String SID = "";
	private static String[] sz1;
	private static String tempInfo = "";
	private static boolean checkInfo = false;
	public static void main(String[] args) {
		StageVector tv = new StageVector();
		Vector<String>  v1 = tv.getRelTaskAllVector();
//		v1.add("a");
//		v1.add("a");
//		v1.add("b");
//		v1.add("b");
//		v1.add("c");
//		v1.add("a");
//		v1.add("b");
//		v1.add("b");
//		v1.add("c");
		v1.add("2017-07-27 08:44:13,516 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	98.0 ms	98.0 ms	98.0 ms	98.0 ms	98.0 ms	98.0 ms	98.0 ms	98.0 ms	98.0 ms");
		v1.add("2017-07-27 08:44:13,517 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	0%	5%	10%	25%	50%	75%	90%	95%	100%");
		v1.add("SBUS END");
		v1.add("2017-07-27 08:44:14,715 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782329]Job: 3126978 Stage: 3080831.0 Duration: 114 ms TaskTime: 109 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms");
		v1.add("2017-07-27 08:44:14,715 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782329]Statistics TaskTime: [109.0,109.0,109.0,109.0,109.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0]");
		v1.add("2017-07-27 08:44:14,715 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782329]Executors num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 0 ms");
		v1.add("2017-07-27 08:44:14,716 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	0%	5%	10%	25%	50%	75%	90%	95%	100%");
		v1.add("2017-07-27 08:44:14,716 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	96 %	96 %	96 %	96 %	96 %	96 %	96 %	96 %	96 %");
		v1.add("SBUS END");
		v1.add("2017-07-27 08:44:14,831 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782331]Job: 3126979 Stage: 3080832.0 Duration: 199 ms TaskTime: 188 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms");
		v1.add("2017-07-27 08:44:14,832 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782331]Statistics TaskTime: [188.0,188.0,188.0,188.0,188.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0]");
		v1.add("2017-07-27 08:44:14,832 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782331]Executors num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms");
		v1.add("2017-07-27 08:44:14,832 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - Finished stage: org.apache.spark.scheduler.StageInfo@44522e7f");
		v1.add("2017-07-27 08:44:14,832 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - task runtime:(count: 1, mean: 199.000000, stdev: 0.000000, max: 199.000000, min: 199.000000)");
		v1.add("SBUS END");
		v1.add("2017-07-27 08:44:17,156 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782337]Job: 3126980 Stage: 3080833.0 Duration: 108 ms TaskTime: 102 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms");
		v1.add("2017-07-27 08:44:17,157 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782337]Statistics TaskTime: [102.0,102.0,102.0,102.0,102.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0]");
		v1.add("2017-07-27 08:44:17,157 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18782337]Executors num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms");
		v1.add("2017-07-27 08:44:17,157 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - Finished stage: org.apache.spark.scheduler.StageInfo@5aa66de5");
		v1.add("2017-07-27 08:44:17,157 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - task runtime:(count: 1, mean: 108.000000, stdev: 0.000000, max: 108.000000, min: 108.000000)");
		v1.add("SBUS END");
		Iterator<String> it = tv.getRelTaskAllVector().iterator();
		Vector<String>  v2 = tv.getRelTask2OneTaskVector();//tv.getRelTask2OneTaskVector
		Vector<String>  v3 = tv.getRelTaskTaskInfoTempVector();//tv.getRelTaskTaskInfoTempVector
		Vector<String>  v4 = tv.getRelTaskStageInfoTempVector();//tv,getRelTaskStageInfoTempVector
		Pattern p = null;
		while(it.hasNext()){
		    String x = it.next();
//		    if(x.equals("b")){
		    if(p.compile("Leviathan").matcher(x).find()){
		    	//临时保存stage的集合
		    	v4.add(x);
		    	it.remove();
		    }else if (x.equals("SBUS END")){
		    	if (v4.size()!=0){
		    		for(String str:v4){
		    			sz1 =  str.split("(\\[Leviathan\\]\\[)")[1].split("(\\])");
		    			if(!sz1[0].equals("-1")){
		    				LID = sz1[0];
		    			}
		    			if (p.compile("Duration").matcher(sz1[1]).find()){
		    			sz1 = sz1[1].split("Job\\: ")[1].split(" Stage\\: ");
		    				JID = sz1[0];
		    			sz1 = sz1[1].split(" Duration\\: ");
		    				SID = sz1[0];
		    			}
		    			}
		    			//保存ID信息用于匹配及保存	
		    			tempInfo+=LID+": RelTask2OneTask :"+JID+": RelTask2OneTask :"+SID;
		    			if(v3.size()!=0){
		    			for (String te:v3){
				    		sz1 = te.split("\\[SparkListenerBus\\(\\)\\] \\- ");
				    		tempInfo+=": separator :"+sz1[1];
				    	}
		    			checkInfo = true;
		    			v3.removeAllElements();
		    			}
		    			if(checkInfo){
		    				v2.add(tempInfo);
		    				tempInfo = "";
		    				checkInfo =  false;
		    			}
		    			v4.removeAllElements();
		    		}
		    		it.remove();
		    }else{
		    	//临时保存单个task信息的集合
		    	v3.add(x);
		    	it.remove();
		    }
		}
		for(String ax:v2){
			System.out.println(ax);
		}
//		
//		Pattern p = null;
//		boolean find = false;
//		ArrayList<String> a = new ArrayList<String>();
//		for (String str :v1){
//			if(p.compile("Leviathan").matcher(str).find()){
//				a.add(str);
//				find =  true;
//			}
//		}
//		if (find){
//			for(String ax:a){
//				
//				tv.RemoveRelTaskAllVectorByKey(ax);
//			}
//			find =  false;
//		}
		System.out.println("原始队列残留");
		for (String str :tv.getRelTaskAllVector()){
			System.out.println(str);
		}
		System.out.println("v3残留");
		for (String str :v3){
			System.out.println(str);
		}
		System.out.println("v4残留");
		for (String str :v4){
			System.out.println(str);
		}
		
	}	
}
