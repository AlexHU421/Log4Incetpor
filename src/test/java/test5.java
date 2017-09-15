
public class test5 {

	public static void main(String[] args) {
		/**str2
		 * 
		 * Leviathan     1560218: RelTask2OneTask :
		 * TaskJobId     230003: RelTask2OneTask :
		 * TaskStageId   245163.0: separator :
		 * DetailFinished stage: org.apache.spark.scheduler.StageInfo@f7dabe6: separator :task runtime:(count: 3, me
		 */
		/**str1
		 * 
		 * LogTime       1504522211959:this is separator:
		 * Leviathan     1561722:this is separator:
		 * TaskJobId     230233:this is separator:
		 * TaskStageId   245406:this is separator:Duration:{ 86 ms TaskTime: 78 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [78.0,78.0,78.0,78.0,78.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms}StageDetailEnd
		 */
		String str1 = "1504522175506:this is separator:1561578:this is separator:230209:this is separator:245381:this is separator:Duration:{ 6102 ms TaskTime: 162 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [162.0,162.0,162.0,162.0,162.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms}StageDetailEnd";
		
		String str2 = "1561574: RelTask2OneTask :230207: RelTask2OneTask :245379.0: separator :Finished stage: org.apache.spark.scheduler.StageInfo@25d69bd5: separator :task runtime:(count: 1, mean: 142.000000, stdev: 0.000000, max: 142.000000, min: 142.000000): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	142.0 ms	142.0 ms	142.0 ms	142.0 ms	142.0 ms	142.0 ms	142.0 ms	142.0 ms	142.0 ms: separator :task result size:(count: 1, mean: 1879.000000, stdev: 0.000000, max: 1879.000000, min: 1879.000000): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B: separator :executor (non-fetch) time pct: (count: 1, mean: 96.478873, stdev: 0.000000, max: 96.478873, min: 96.478873): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	96 %	96 %	96 %	96 %	96 %	96 %	96 %	96 %	96 %: separator :other time pct: (count: 1, mean: 3.521127, stdev: 0.000000, max: 3.521127, min: 3.521127): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	 4 %	 4 %	 4 %	 4 %	 4 %	 4 %	 4 %	 4 %	 4 %";
		
		String[]sz1 =  str1.split("\\:this is separator\\:");
		for (int a = 0;a<sz1.length;a++){
			System.out.println(a+"  :  "+sz1[a]);
		}
		
		String[]sz2 =  str2.split("\\: RelTask2OneTask \\:");
		for (int a = 0;a<sz2.length;a++){
			System.out.println(a+"  :  "+sz2[a]);
		}
		sz2 = sz2[2].split("\\.\\d+\\: s");
		for (int a = 0;a<sz2.length;a++){
			System.out.println(a+"  :  "+sz2[a]);
		}
	}
	
	
	/*str1
	 * 0  :  1504522175506
	   1  :  1561578
	   2  :  230209
	   3  :  245381
	   4  :  Duration:{ 6102 ms TaskTime: 162 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [162.0,162.0,162.0,162.0,162.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms}StageDetailEnd
	   
	   str2
	   
	   0  :  1561574
	   1  :  230207
	   2  :  245379.0: s
	 * 
	 * 
	 * 
	 */

}
