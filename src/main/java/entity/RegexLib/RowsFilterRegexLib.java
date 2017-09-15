package entity.RegexLib;

import java.util.HashMap;

public class RowsFilterRegexLib {
	//此处正则过滤出多行结果
	private static String LeviathanRegex = "(leviathan\\.TimedEventTracker\\:)";
	private static String DAGSchedulerRegex = "(scheduler\\.DAGScheduler\\:)";
	private static String qlDriverRegex = "(ql\\.Driver\\:)";
	private static String TaskSetManagerRegex = "((TaskSetManager))";
	//此处正则过滤出单行结果	

	private static String JobFinishRowsRegex = "(inceptor\\.InceptorContext\\:.* Job finished\\: runJob)";
	
	
	
	
	//此处正则将多行结果过滤出单行结果
	private static String SessionSQLRowsRegex = "(SessionHandle.*?RegularId.*?Session.*?SQL)";
	private static String TopoRowsRegex = "(Topo\\:)";
	private static String JobDetailRowsRegex = "(Job \\:.*JobId \\:.*FinalStageId \\:.*All StageId \\:)";
	private static String StageFinishRowsRegex = "((Stage).*?(runJob).*?(finished in))";
	private static String JobRunTimeRowsRegex = "(Driver\\.run start)";
	private static String SessionEndRowsRegex = "(SessionHandle\\=.*?Restore the configuration ngmr\\.exec\\.mode)";
	private static String TaksStartDetailRegex = "(Starting task.*in stage .*TID)";
	private static String TaksEndDetailRegex = "(Finished task.* in stage .* in .* on )";
	
	//多行过滤出多行结果（筛除）
	private static String TaskDetailRowsRegex = "(SparkListenerBus.*?Leviathan)";
	
	public HashMap<String,String> getFisterFilterRegexLib(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Leviathan", LeviathanRegex);
		map.put("DAG", DAGSchedulerRegex);
		map.put("qlDrive", qlDriverRegex);
		map.put("TaskSet", TaskSetManagerRegex);//TaskSetManager
		map.put("JobFinish", JobFinishRowsRegex);//inceptorcontext
		return map;
		
	}
	
	
	public String[] getSecoundFilterRegexLib(String Key){
		if ("Leviathan".equals(Key)){
			return new String[] {TopoRowsRegex,TaskDetailRowsRegex,SessionSQLRowsRegex};
		}else if ("DAG".equals(Key)){
			return new String[] {JobDetailRowsRegex,StageFinishRowsRegex,};
		}else if ("qlDrive".equals(Key)){
			return new String[] {JobRunTimeRowsRegex,SessionEndRowsRegex};
		}else if ("TaskSet".equals(Key)){
			return new String[] {TaksStartDetailRegex,TaksEndDetailRegex};
		}
		return new String[] {""};
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		RowsFilterRegexLib rfr = new RowsFilterRegexLib();
//		HashMap map = rfr.getFisterFilterRegexLib();
//		Iterator it = map.keySet().iterator();
//		for (Object obj : map.keySet()) {
//			String key = (String)obj;
//			System.out.println("key:"+key);
//			String value = (String)map.get(key);
//			System.out.println("value"+value);
//			}
//		
//	}
	
//	public static void main(String[] args) {
//		RowsFilterRegexLib rfr = new RowsFilterRegexLib();
//		String[] regexLib = rfr.getFilterToMultiRowsRegexLib();
//		for (String regex:regexLib){1
//			System.out.println(regex);
//		}
//	}
//	
}
