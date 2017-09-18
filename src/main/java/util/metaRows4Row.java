package util;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Pattern;

import entity.entityset.ErrorVector;
import entity.entityset.SessionVector;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;
import sun.org.mozilla.javascript.internal.ErrorReporter;


public class metaRows4Row {
	private static String sessionID = "";
	private static String stageID = "";
	private static String taskID = "";
	private static String sessionInfo = "";
	private static String stageInfo = "";
	private static String taskInfo = "";
	private static String  separator = ":this is separator:";
//	public metaRows4Row(){}
//	
//	public metaRows4Row(SessionVector sessionVector,StageVector stageVector,TaskVector taskVector){
//		this.sessionVector=sessionVector;
//		this.stageVector=stageVector;
//		this.taskVector=taskVector;
//	}
	public static Long mathRuntime (String stime,String etime){
		String stemp = "";
		String etemp = "";
		stemp+=stime;
		etemp+=etime;
		if (stemp.equals("")||etemp.equals("")){
			return 0L;
		}else{
			Long st =  Long.parseLong(stemp);
			Long et =  Long.parseLong(etemp);
			return et-st;
		}
		}
	/**
	 * @param sessionv
	 * @param setagev
	 * @param taskv
	 * @param errorv
	 * @param p
	 */
	public void metaErrorInfo4Vector(SessionVector sessionv,StageVector setagev,TaskVector taskv,ErrorVector errorv,Pattern p){
		String[] sessionsz;
		String[] stagesz;
		String[] tasksz;
		String rt = "";
		boolean rmCheck = false;
		/**SessionVector		separator:			:this is separator:
		 * LogTime    			1504521341571
		 * SessionID  			bcd61fe4-3d2b-42f3-ada0-add402383782
		 * JobID      	   	 	229756
		 * SQL              	select itemid,value_type from zabbix_items where hostid ='14748' and key_='system.sw.os[name]' and status='0' and state='0'
		 * FinalStageID    		244875
		 * StageIDs				244875
		 * StartTime			1504521341490
		 * EndTime				1504521342076
		 * StageFinishedCheck	true
		 */
		Iterator<String> session = sessionv.getSessionFinishedCheckErrorVector().iterator();
		
		
		/**StageVector          separator:			:this is separator:			: separator :(换行分隔符)
		 * LogTime				1501116631048
		 * Leviathan			18782935
		 * JobID				3127079
		 * StageID				3080931
		 * StageDetail			Duration:{ 63 ms TaskTime: 0 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }
		 */
		Iterator<String> stage = setagev.getStagecheckErrorVectorVector().iterator();
		
		
		/**TaskVector          separator:			:this is separator:
		 * LogTime					1501116253417
		 * StageID					3080830
		 * TaskID					3190016
		 * TaskRunNodeName			dbclusternode016
		 * TaskRunMode				NODE_LOCAL
		 * TaskRunTime				98 ms
		 * TaskFinishedNodeName		dbclusternode016
		 * StageInsideTaskNum		1
		 */
		Iterator<String> task = taskv.getTaskStartTempVector().iterator();
		/**errorVector			separator:			:this is separator:
		 * SessionID 
		 * StageID						 3081674
		 * TaskID						 3190787
		 * TaskNodeName					 dbclusternode013
		 * errorDetail					 org.apache.spark.SparkException: Job aborted due to stage failure: Task 1 in stage 3081674.0 failed 4 times, most recent failure: Lost task 1.3 in stage 3081674.0 (TID 3190787, dbclusternode013): org.apache.hadoop.hive.ql.metadata.HiveException: Index: 3, Size: 3
		 * 			\: NewLine \:        org.apache.hadoop.hive.ql.exec.FileSinkOperator.processOp(FileSinkOperator.java:1143)
		 * 			\: NewLine \:        io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$processPartition$3.apply(FileSinkOperator.scala:118)
		 * 			\: NewLine \:        io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$processPartition$3.apply(FileSinkOperator.scala:115)
		 * 			\: NewLine \:        scala.collection.Iterator$class.foreach(Iterator.scala:727)
		 * 			\: NewLine \:        org.apache.spark.util.CompletionIterator.foreach(CompletionIterator.scala:25)
		 * 			\: NewLine \:        io.transwarp.inceptor.execution.FileSinkOperator.processPartition(FileSinkOperator.scala:115)
		 * 			\: NewLine \:        io.transwarp.inceptor.execution.FileSinkOperator$.io$transwarp$inceptor$execution$FileSinkOperator$$writeFiles$1(FileSinkOperator.scala:289)
		 * 			\: NewLine \:        io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$executeProcessFileSinkPartition$1.apply(FileSinkOperator.scala:293)
		 * 			\: NewLine \:        io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$executeProcessFileSinkPartition$1.apply(FileSinkOperator.scala:293)
		 * 			\: NewLine \:        org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:73)
		 * 			\: NewLine \:        org.apache.spark.scheduler.Task.run(Task.scala:62)
		 * 			\: NewLine \:        org.apache.spark.executor.Executor$TaskRunner$$anonfun$run$1.apply$mcV$sp(Executor.scala:265)
		 * 			\: NewLine \:        org.apache.spark.deploy.SparkHadoopUtil.runAsUser(SparkHadoopUtil.scala:58)
		 * 			\: NewLine \:        org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:224)
		 * 			\: NewLine \:        java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		 * 			\: NewLine \:        java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		 * 			\: NewLine \:        java.lang.Thread.run(Thread.java:745)
		 * 			\: NewLine \:Driver stacktrace:
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1595)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1584)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1583)
		 * 			\: NewLine \:	at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		 * 			\: NewLine \:	at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1583)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:992)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:992)
		 * 			\: NewLine \:	at scala.Option.foreach(Option.scala:236)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:992)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGSchedulerEventProcessActor$$anonfun$receive$2.applyOrElse(DAGScheduler.scala:1836)
		 * 			\: NewLine \:	at scala.runtime.AbstractPartialFunction$mcVL$sp.apply$mcVL$sp(AbstractPartialFunction.scala:33)
		 * 			\: NewLine \:	at scala.runtime.AbstractPartialFunction$mcVL$sp.apply(AbstractPartialFunction.scala:33)
		 * 			\: NewLine \:	at scala.runtime.AbstractPartialFunction$mcVL$sp.apply(AbstractPartialFunction.scala:25)
		 * 			\: NewLine \:	at org.apache.spark.scheduler.DAGSchedulerEventProcessActor$$anonfun$receiveTiming$1.applyOrElse(DAGScheduler.scala:1792)
		 * 			\: NewLine \:	at akka.actor.ActorCell.receiveMessage(ActorCell.scala:498)
		 * 			\: NewLine \:	at akka.actor.ActorCell.invoke(ActorCell.scala:456)
		 * 			\: NewLine \:	at akka.dispatch.Mailbox.processMailbox(Mailbox.scala:237)
		 * 			\: NewLine \:	at akka.dispatch.Mailbox.run(Mailbox.scala:219)
		 * 			\: NewLine \:	at akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinTask.exec(AbstractDispatcher.scala:386)
		 * 			\: NewLine \:	at scala.concurrent.forkjoin.ForkJoinTask.doExec(ForkJoinTask.java:260)
		 * 			\: NewLine \:	at scala.concurrent.forkjoin.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1339)
		 * 			\: NewLine \:	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
		 *			\: NewLine \:	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)
		 * 			\: NewLine \::this is error separate rows:
		 * 			\: NewLine \:
		 */
		Iterator<String> error = errorv.getEreror4OneErrorTempVector().iterator();
		while(error.hasNext()){
			String errorInfo = error.next();
			//0 EsessionID  1 EStageID  2 ETaskID 3 ENodeName 4 EDetail
			String[] errorsz = errorInfo.split(separator);
//			System.out.println("errorInfo"+errorInfo);
			while(task.hasNext()){
			String taskInfo = task.next();
			//0 LOGTIME 1 TStageID 2 TTaskID 
			tasksz = taskInfo.split(separator);
					//TASKID						//StageID
				if (errorsz[2].equals(tasksz[2])&&errorsz[1].equals(tasksz[1])){
					//taskinfo + taskStatus + errorNodeName + errorDetail
					taskInfo+=separator+" "+separator+errorsz[3]+separator+" "+separator+"Failed"+separator+errorsz[4];
					taskv.setTaskFinishedVectorByKey(taskInfo);
					task.remove();
					taskInfo="";
					taskID = errorsz[2];
				}else if (errorsz[1].equals(tasksz[1])){
					taskInfo+=separator+" "+separator+errorsz[3]+separator+" "+separator+"Failed"+separator+"Task LOST";
					taskv.setTaskFinishedVectorByKey(taskInfo);
					task.remove();
					taskInfo="";
				}
			}
			task = taskv.getTaskStartTempVector().iterator();
			//0 EsessionID  1 EStageID  2 ETaskID 3 ENodeName 4 EDetail
			while(stage.hasNext()){
				String stageInfo = stage.next();
				//0 LOGTIME 1 Leviathan 2 JobID 3 StageID
				stagesz = stageInfo.split(separator);
					if (errorsz[1].equals(stagesz[3])){
						//stageInfo + stageStatus +  FailedTaskID
						stageInfo+=separator+"Failed"+separator+errorsz[2];
						setagev.setStageVectorByKey(stageInfo);
						stage.remove();
						stageInfo="";
						stageID = errorsz[1];
					}
				}
			stage = setagev.getStagecheckErrorVectorVector().iterator();
			if (!stageID.equals("")){
				setagev.setStageCheck2sessionVectorByKey(stageID);
				error.remove();
//				System.out.println(stageID);
			//0 EsessionID  1 EStageID  2 ETaskID 3 ENodeName 4 EDetail
//			while(session.hasNext()){
//				String sessionInfo = session.next();
//				//0 LOGTIME 1 SessionID 2 FinalStageID 3 StageIDs(XXXX XXXX)
//				sessionsz = sessionInfo.split(separator);
//				for (String stid:sessionsz[5].split("\\,")){
//					String[] szs = stid.split("\\(");
//					if (szs.length>1){
//						stid = szs[0];
//					}
//					System.out.println(stid);
//					System.out.println(stageID);
//					System.out.println(stid);
//					System.out.println(stageID.equals(stid));
//					if (stageID.equals(stid)){
//						System.out.println(sessionInfo);
//						//stageInfo + stageStatus +  FailedTaskID
//						sessionInfo+=separator+"Failed"+separator+stageID;
//						String[] szxx = sessionInfo.split(separator);
//						String[] szx = szxx[5].split(";");
//						if (szx.length>1){
//							sessionInfo = szxx[0]+separator+szxx[1]+separator+szxx[2]+separator+szxx[3]+separator+szxx[4]+separator+szx[0]+separator+szx[1]+separator+szxx[6]+separator+szxx[7]+separator+szxx[8]+separator+"Failed"+separator+stageID;
//							System.out.println("错误："+sessionInfo);
//						}else{
//							sessionInfo = szxx[0]+separator+szxx[1]+separator+szxx[2]+separator+szxx[3]+separator+szxx[4]+separator+szx[0]+separator+0+separator+szxx[6]+separator+szxx[7]+separator+szxx[8]+separator+"Failed"+separator+stageID;
//							System.out.println("错误："+sessionInfo);
//						}
//						sessionv.setSessionFinishedVectorByKey(stageInfo);
//						session.remove();
//						stageID = "";
//						sessionInfo="";
//					}
//				}
//			}
//			session = sessionv.getSessionFinishedCheckErrorVector().iterator();
		}
			
	}
		session = sessionv.getSessionFinishedCheckErrorVector().iterator();
		stage = setagev.getStageCheck2sessionVector().iterator();
		while (session.hasNext()){
			String sesstr = session.next();
			sessionsz = sesstr.split(separator);
			while (stage.hasNext()){
			String stageID = stage.next();	
//					System.out.println(sessionsz[4]);
//					System.out.println(stageID);
			if (sessionsz[4].equals(stageID)){
//						System.out.println(true);
//						System.out.println(sesstr);
				String[] szxx = sesstr.split(separator);
				String[] szx = szxx[5].split(";");
				if (szx.length>1){
					rt += ""+mathRuntime(szxx[6],szxx[7]);
					sessionInfo = szxx[0]+separator+szxx[1]+separator+szxx[2]+separator+szxx[3]+separator+szxx[4]+separator+szx[0]+separator+szx[1]+separator+szxx[6]+separator+szxx[7]+separator+rt+separator+szxx[8]+separator+"Failed"+separator+stageID;
					rt = "";
//					System.out.println("szxx[6]			"+szxx[6]);
//					System.out.println("szxx[7]			"+szxx[7]);
//					System.out.println("错误1："+sessionInfo);
				}else{
					rt += ""+mathRuntime(szxx[6],szxx[7]);
					sessionInfo = szxx[0]+separator+szxx[1]+separator+szxx[2]+separator+szxx[3]+separator+szxx[4]+separator+szx[0]+separator+0+separator+szxx[6]+separator+szxx[7]+separator+rt+separator+szxx[8]+separator+"Failed"+separator+stageID;
					rt = "";
//					System.out.println("szxx[6]			"+szxx[6]);
//					System.out.println("szxx[7]			"+szxx[7]);
//					System.out.println("错误2："+sessionInfo);
				}
				sessionv.setSessionFinishedVectorByKey(sessionInfo);
				rmCheck = true;
				stage.remove();
			}
			}
			if (rmCheck){
				session.remove();
				rmCheck=false;
			}
			stage = setagev.getStageCheck2sessionVector().iterator();
		}
		session = sessionv.getSessionrunVector().iterator();
		stage = setagev.getStageCheck2sessionVector().iterator();
		while (session.hasNext()){
			System.out.println(session.next());
		}
		while (stage.hasNext()){
			System.out.println(stage.next());
		}
		session = sessionv.getSessionFinishedCheckErrorVector().iterator();
		stage = setagev.getStagecheckErrorVectorVector().iterator();
		task = taskv.getTaskFinishedCheckErrorVector().iterator();
		while (session.hasNext()){
			String sessionInfo = session.next();
			String[] szxx = sessionInfo.split(separator);
			String[] szx = szxx[5].split(";");
			if (szx.length>1){
				rt += ""+mathRuntime(szxx[6],szxx[7]);
				sessionInfo = szxx[0]+separator+szxx[1]+separator+szxx[2]+separator+szxx[3]+separator+szxx[4]+separator+szx[0]+separator+szx[1]+separator+szxx[6]+separator+szxx[7]+separator+rt+separator+szxx[8]+separator+"Succeeded"+separator+" ";
				rt = "";
//				System.out.println("szxx[6]			"+szxx[6]);
//				System.out.println("szxx[7]			"+szxx[7]);
			}else{
				rt += ""+mathRuntime(szxx[6],szxx[7]);
				sessionInfo = szxx[0]+separator+szxx[1]+separator+szxx[2]+separator+szxx[3]+separator+szxx[4]+separator+szx[0]+separator+0+separator+szxx[6]+separator+szxx[7]+separator+rt+separator+szxx[8]+separator+"Succeeded"+separator+" ";
				rt = "";
//				System.out.println("szxx[6]			"+szxx[6]);
//				System.out.println("szxx[7]			"+szxx[7]);
			}
			sessionv.setSessionFinishedVectorByKey(sessionInfo);
			session.remove();
		}
		while (task.hasNext()){
			String taskInfo = task.next();
			taskInfo +=separator+"Succeeded"+separator+" ";
			taskv.setTaskFinishedVectorByKey(taskInfo);
			task.remove();
		}
//		System.out.println("看错误");
		error = errorv.getEreror4OneErrorTempVector().iterator();
		while (error.hasNext()){
			System.out.println(error.next());
		}
	}
	
	public void metaRows2Set(String metaKy,String JobID,String StageID,String TotalTasks,SessionVector setv,StageVector stagev){
		boolean check =  false;
		int num = 0;
		String temp = TotalTasks;
		String tottemp  = "";
		String sttemp  = "";
		String rmtemp = "";
		Iterator<String> session = setv.getSessionrunVector().iterator();
//		System.out.println("JobI:"+JobID+" StageID:"+StageID+" TotalTasks:"+TotalTasks);
		while (session.hasNext()){
//			se[0] LogTime  		1501116253329
//			se[1] SessionID 	31723f4b-2996-47c4-baf8-a5849b594440
//			se[2] JobID			3126977
//			se[3] SQL       	select id from esm_sys_role limit 1
//			se[4] FinalStageID	3080830
//			se[5] StageIDS		3080830
			String se = session.next();
//			System.out.println("se			"+se);
			String[] sex = se.split(separator);
			String[] xg = sex[5].split(";");
			if (sex[2].equals(JobID)){
//				System.out.println(sex[5]);
				if (xg.length>1){
					int oldTotal =  Integer.parseInt(xg[1]);
					int newTotal = oldTotal+(Integer.parseInt(TotalTasks));
					TotalTasks = ""+newTotal;
//					System.out.println(TotalTasks);
					sex[5] = xg[0];
					xg = sex[5].split(";");
				}
				String[] xx = xg[0].split(",");
				for(int a=0;a<xx.length;a++){
					String xax = xx[a];
					if(xax.equals(StageID)){
						check =  true;
						sttemp+=xax+"("+temp+"),";
					}else{
						sttemp+=xax+",";
					}
				}
				
			
				if (check){
					if (xg.length==1){
						sttemp = sttemp.substring(0,sttemp.length()-1)+";"+TotalTasks;
//						System.out.println(sex[5]);
//						System.out.println(sttemp);
					}
					rmtemp = se;
					tottemp+=sex[0]+separator
							+sex[1]+separator
							+sex[2]+separator
							+sex[3]+separator
							+sex[4]+separator
							+sttemp;
					setv.setSessionrunVectorByKey(tottemp);
//					stagev.RemoveTotalTaskVectorByKey(JobID+","+StageID+","+TotalTasks);
					break;
				}else{
					System.out.println(se);
				}
		}
		}
		setv.RemoveSessionrunVectorByKey(rmtemp);
	}
	
	public void metaRows2Set(String metaKey,SessionVector sett,String obj2,String row){
		if("jobCreate".equals(metaKey)){
			String str1="";
			String str2="";
			Vector<String> set = sett.getSessionJobCreateTempVector();
			
//			System.out.println("开始比对的job信息："+row);
//			System.out.println("开始比对");
			String[] sz = row.split(separator);
			int i=0;
			for (String setsession:set){
				String[] szk =  setsession.split(separator);
				String RIDk = szk[1];
				String JK = szk[2];
				//比对JOB  比对Stage确定匹配
				if (JK.equals(obj2)&&sz[3].equals(szk[3])){
					str1 = setsession;
//					System.out.println("OK");
//					String row2 = RIDk+separator+row;
//					System.out.println("row2:"+row2);
					set = sett.getSessionCreateTempVector();
					for (String ssession:set){
						szk = ssession.split(separator);//Log Time szk [0]  SID szk[1] RID szk[2] SQL szk[3]
						if (szk[2].equals(RIDk)&&szk[3].length()==sz[1].length()){
							//将JOB与SESSIONID合并的内容合并为日志日期、SessionID、JobID、SQL、FinalyStageID、所有StageID
							String session  = szk[0]+separator+szk[1]+separator+sz[2]+separator+sz[1]+separator+sz[3]+separator+sz[4];
//							System.out.println("根据结果保存的session信息："+session);
							sett.setSessionrunVectorByKey(session);
							str2=ssession;
							i=1;
							break;
						}
						}
					}
				}
			if (i==1){
				boolean x = sett.RemoveSessionJobCreateTempVectorByKey(str1);
				x = sett.RemoveSessionCreateTempVectorByKey(str2);
			}
			}
		
		if("srunning".equals(metaKey)){
			String str1="";
			Vector<String> set = sett.getSessionrunVector();
			String[] run = row.split(separator);
			int i=0;
			for (String setsession:set){
				String[] ses =  setsession.split(separator);
				if (run[1].equals(ses[1])){
					str1=setsession;
					setsession+=separator+run[2]+separator+run[3];
					i=1;
					sett.setSessionVectorByKey(setsession);
					break;
				}
			}
			if (i==1){
				sett.RemoveSessionrunVectorByKey(str1);
			}
			}
		
	
		if("checkEnd".equals(metaKey)){
		String str1="";
		Vector<String> set = sett.getSessionVector();
		String[] ses = row.split(separator);
		int i=0;
		for (String setsession:set){
			if (ses[1].equals(obj2)){
				str1=setsession;
				setsession+=separator+true;
				i=1;
				sett.setSessionFinishedCheckErrorVectorByKey(setsession);
				break;
			}
		}
		if (i==1){
			sett.RemoveSessionVectorByKey(str1);
		}
		}
	}
	public void metaRows2Set(String metaKey,TaskVector taskv,String row,String Line){
		if("startEnd".equals(metaKey)){
//			System.out.println("被调用");
			String rmStr="";
			Vector<String> set = taskv.getTaskStartTempVector();
			//str[0] LogTime, str[1] stageID, str[2] taskID, str[3] taskAllotNodeName,str[4] taskRunPriority,str[5] taskRunSize;
			String[] sz = row.split(separator);
			//str[0] LogTime, str[1] stageID, str[2] taskID, str[3] taskRunningTime, str[4] TaskRunningNodeName , str[5] StageInsideTaskNum;
			for (String str:set){
			String[] sz2 = str.split(separator);
//			System.out.println(str);
//			System.out.println(row);
//				sz2[0]1501116253417  sz2[1]  3080830  sz2[2]  3190016  sz2[3]  dbclusternode016  sz2[4]  NODE_LOCAL
//str			sz2[0]1501116253417  sz2[1]  3080830  sz2[2]  3190016  sz2[3]  dbclusternode016  sz2[4]  NODE_LOCAL
//row			sz[0] 1501116253515  sz[1]  3080830  sz[2]  3190016  sz[3]  98 ms  sz[4]  dbclusternode016 sz[5] 1
				if (str!=null&&sz[1].equals(sz2[1])&&sz[2].equals(sz2[2])){
					rmStr=str;
					str+=separator+sz[3]+separator+sz[4]+separator+sz[5];
//				str[0] LogTime str[1] StageId  str[2]TaskId   str[3]allotNodeName   str[4]runMode  str[5]runTime  str[6]runNodeName
//new str		1501116253417   3080830        3190016      dbclusternode016      NODE_LOCAL      98 ms         dbclusternode016
					taskv.setTaskFinishedCheckErrorVectorByKey(str);
				}
			}
			if (rmStr!=""){
				taskv.RemoveTaskStartTempVectorByKey(rmStr);
			}
		}
		
		if("detail".equals(metaKey)){
			String rmStr="";
			String setStr = "";
			Vector<String> set = taskv.getTaskInfoTempVector();
			String[] sz  = row.split(separator);
			for (String str:set){
				String[] sz2 = str.split(separator);
//				System.out.println("row:      "+row);
//				sz[0]LogTime 1501116253516   sz[1]   18782319   sz[2]   Statistics:{ TaskTime: [70.0,70.0,70.0,70.0,70.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }
//				System.out.println("str:      "+str);
//				sz2[0] LogTime 1501116253515   sz2[1] leviathan  18782319   sz2[2] TaskJobId  3126977   sz2[3] TaskStageId  3080830   sz2[4]   Duration:{ 98 ms TaskTime: 70 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }
				if (sz[1].equals(sz2[1])){
					if(Line.equals("3")){
						rmStr = str;
						str +=sz[2]+"StageDetailEnd";
						setStr = str;
					}else{
						rmStr = str;
						str +=sz[2];
						setStr = str;
					}
				}
			}
			if (rmStr!=""){
				taskv.RemoveTaskInfoTempVectorByKey(rmStr);
				taskv.setTaskInfoTempVectorByKey(setStr);
				
			}
		}
	}
	public void metaRows2Set(String metaKey,StageVector stagev,TaskVector taskv,String row,String Line){
		if("end".equals(metaKey)){
			boolean ck = false;
			String rmStr = "";
			//相对数据量多
			Vector<String> infoSet = taskv.getTaskInfoTempVector();
			//相对数据量少
			Vector<String> chkSet = taskv.getTaskfinishedCheckTempSet();
//					System.out.println("row:        "+row);
//					System.out.println("info:        "+infoStr);
//					check:        c[0]1503984688417   c[1]   82633   c[2]   true
//					detail:		d[0]1501116265288   d[1]leviathan   18782349   d[2] TaskJobId  3126982   d[3] TaskStageId  3080835   d[4] TaskDetail1：  Duration:{ 134 ms TaskTime: 121 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [121.0,121.0,121.0,121.0,121.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms}
			for(String infoStr:infoSet){
//				c[0] 1501116253515  c[1] 18782319  c[2] 3126977  c[3] 3080830  c[4] 1  c[5] { 98 ms TaskTime: 70 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [70.0,70.0,70.0,70.0,70.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms}StageDetailEnd
				String[] d = infoStr.split(separator);
				for (String checkStr:chkSet){
					String[] c = infoStr.split(separator);
					String x =  infoStr.substring(infoStr.length()-3, infoStr.length());
					if (x.equals("End")){
						if (d[1].equals(c[1])){
							ck =true;
							rmStr = checkStr;
						}
					}					
				}
				if (ck){
					taskv.RemoveTaskfinishedCheckTempSetByKey(rmStr);
					chkSet = taskv.getTaskfinishedCheckTempSet();
					ck = false;
					rmStr = infoStr;
					stagev.setTaskDetailTempVectorByKey(infoStr);
					break;
				}
				
			}
			if (rmStr!=""){
				taskv.RemoveTaskInfoTempVectorByKey(rmStr);
				this.metaRows2Set("end",stagev, taskv, "","");
			}
//			if (!rmInfoStr.equals("")){
//				taskv.RemoveTaskInfoTempVectorByKey(rmInfoStr);
//			}
//			if (!rmCheckStr.equals("")){
//				taskv.RemoveTaskfinishedCheckTempSetByKey(rmCheckStr);
//			}
		}
	}
	public void metaRows2Set(String metaKey,StageVector stagev,TaskVector taskv,String row){
		 String TaskDetail = "";
		 String OneTask = "";
		 String LID = "";
		 String JID = "";
		 String SID = "";
		 String temp = "";
		 boolean check = false;
		 String[] sz1;
		 String[] sz2;
		if("relTask".equals(metaKey)){
			System.out.println(stagev.getRelTask2OneTaskVector().size());
			System.out.println(stagev.getTaskDetailTempVector().size());
			Iterator<String> RelTask2OneTask = stagev.getRelTask2OneTaskVector().iterator();
			Iterator<String> TaskDetailTemp = stagev.getTaskDetailTempVector().iterator();
			Iterator<String> taskStart = taskv.getTaskInfoTempVector().iterator();
/**RelTask2OneTask
 * 
 * Leviathan     1560218: RelTask2OneTask :
 * TaskJobId     230003: RelTask2OneTask :
 * TaskStageId   245163.0: separator :
 * DetailFinished stage: org.apache.spark.scheduler.StageInfo@f7dabe6: separator :task runtime:(count: 3, me
 */
/**TaskDetailTemp
 * 
 * LogTime       1504522211959:this is separator:
 * Leviathan     1561722:this is separator:
 * TaskJobId     230233:this is separator:
 * TaskStageId   245406:this is separator:Duration:{ 86 ms TaskTime: 78 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [78.0,78.0,78.0,78.0,78.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 1 ms}StageDetailEnd
 */
			while(TaskDetailTemp.hasNext()){
				TaskDetail = TaskDetailTemp.next();
				sz1 = TaskDetail.split("\\:this is separator\\:");
				LID = sz1[1];
				JID = sz1[2];
				SID = sz1[3];
				 while (RelTask2OneTask.hasNext()){
					 OneTask = RelTask2OneTask.next();
					 sz2 = OneTask.split("\\: RelTask2OneTask \\:");
					 sz1 = sz2[2].split("\\.\\d+\\: s");
					 if(sz2[0].equals(LID)&&sz2[1].equals(JID)&&sz1[0].equals(SID)){
						 temp+=TaskDetail+separator+sz1[1]+separator+"Succeeded"+separator+" ";
						 RelTask2OneTask.remove();
						 check = true;
//  1501121201788
//	18795066
//	3129302
//	3082985
//	Duration:{ 104 ms TaskTime: 92 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [92.0,92.0,92.0,92.0,92.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 0 ms}StageDetailEnd
//	eparator :Finished stage: org.apache.spark.scheduler.StageInfo@2abd481b: separator :task runtime:(count: 1, mean: 103.000000, stdev: 0.000000, max: 103.000000, min: 103.000000): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms: separator :task result size:(count: 1, mean: 1879.000000, stdev: 0.000000, max: 1879.000000, min: 1879.000000): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B: separator :executor (non-fetch) time pct: (count: 1, mean: 89.320388, stdev: 0.000000, max: 89.320388, min: 89.320388): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	89 %	89 %	89 %	89 %	89 %	89 %	89 %	89 %	89 %: separator :other time pct: (count: 1, mean: 10.679612, stdev: 0.000000, max: 10.679612, min: 10.679612): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	11 %	11 %	11 %	11 %	11 %	11 %	11 %	11 %	11 %
						 
						 stagev.setStageVectorByKey(temp);
						 temp = "";
					 }
				 }
				 if(check){
				 TaskDetailTemp.remove();
				 check = false;
				 }
				 RelTask2OneTask = stagev.getRelTask2OneTaskVector().iterator();
			}
			RelTask2OneTask = stagev.getRelTask2OneTaskVector().iterator();
			while(taskStart.hasNext()){
				TaskDetail = taskStart.next();
				sz1 = TaskDetail.split("\\:this is separator\\:");
				LID = sz1[1];
				JID = sz1[2];
				SID = sz1[3];
				 while (RelTask2OneTask.hasNext()){
					 OneTask = RelTask2OneTask.next();
					 sz2 = OneTask.split("\\: RelTask2OneTask \\:");
					 sz1 = sz2[2].split("\\.\\d+\\: s");
					 if(sz2[0].equals(LID)&&sz2[1].equals(JID)&&sz1[0].equals(SID)){
						 temp+=TaskDetail+separator+sz1[1];
						 RelTask2OneTask.remove();
						 check = true;
//  1501121201788
//	18795066
//	3129302
//	3082985
//	Duration:{ 104 ms TaskTime: 92 ms TaskCount: 1 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms }Statistics:{ TaskTime: [92.0,92.0,92.0,92.0,92.0] ShuffleRead: [0.0,0.0,0.0,0.0,0.0] ShuffleWrite: [0.0,0.0,0.0,0.0,0.0] GC: [0.0,0.0,0.0,0.0,0.0] RemoteFetchTime [0.0,0.0,0.0,0.0,0.0] FetchWaitTime [0.0,0.0,0.0,0.0,0.0] }Executors:{num: 1 Task stat: [1.0,1.0,1.0,1.0,1.0] This event approx. costs 0 ms}StageDetailEnd
//	eparator :Finished stage: org.apache.spark.scheduler.StageInfo@2abd481b: separator :task runtime:(count: 1, mean: 103.000000, stdev: 0.000000, max: 103.000000, min: 103.000000): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms	103.0 ms: separator :task result size:(count: 1, mean: 1879.000000, stdev: 0.000000, max: 1879.000000, min: 1879.000000): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B	1879.0 B: separator :executor (non-fetch) time pct: (count: 1, mean: 89.320388, stdev: 0.000000, max: 89.320388, min: 89.320388): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	89 %	89 %	89 %	89 %	89 %	89 %	89 %	89 %	89 %: separator :other time pct: (count: 1, mean: 10.679612, stdev: 0.000000, max: 10.679612, min: 10.679612): separator :	0%	5%	10%	25%	50%	75%	90%	95%	100%: separator :	11 %	11 %	11 %	11 %	11 %	11 %	11 %	11 %	11 %
						 
						 stagev.setStagecheckErrorVectorByKey(temp);
						 temp = "";
					 }
				 }
				 if(check){
				 taskStart.remove();
				 check = false;
				 }
				 RelTask2OneTask = stagev.getRelTask2OneTaskVector().iterator();
			}
			
			System.out.println("校验内容");
			while(RelTask2OneTask.hasNext()){
				System.out.println(RelTask2OneTask.next());
			}
			System.out.println("校验完毕");			
		}
	}
	
	
	
//	public static void main(String[] args) {
//		String rows1 ="1501116253547:this is separator:31723f4b-2996-47c4-baf8-a5849b594440:this is separator:1501116253223:this is separator:1501116253547";
//		String rows2 ="1501116253548:this is separator:2a05bfc6-1971-4ce4-85e0-dfecd7bf511c:this is separator:1501116253223:this is separator:1501116253547";
//		String rows3 ="1501116253329:this is separator:31723f4b-2996-47c4-baf8-a5849b594440:this is separator:3126977:this is separator:select id from esm_sys_role limit 1:this is separator:3080830:this is separator:3080830";
//		SessionVector sett = new SessionVector();
//	}
	
//	public static void main(String[] args) {
//		String rows1 = "1501116253415:this is separator:19d5ab1a78ffbfba:this is separator:3126977:this is separator:3080830";
//		String rows2 = "1501116254599:this is separator:19d5ab1a78ffbfba:this is separator:3126978:this is separator:3080831";
//		String rows3 = "1501116253415:this is separator:select id from esm_sys_role limit 1:this is separator:3126977:this is separator:3080830:this is separator:3080830";
//		String rows4 = "1501116253329:this is separator:31723f4b-2996-47c4-baf8-a5849b594440:this is separator:19d5ab1a78ffbfba:this is separator:select id from esm_sys_role limit 1";
//		String rows5 = "1501116254515:this is separator:2a05bfc6-1971-4ce4-85e0-dfecd7bf511c:this is separator:19d5ab1a78ffbfba:this is separator:select 1 from aces.hfbk_e_business_industry_second_classify_statistics limit 1"; 
//		SessionVector sett = new SessionVector();
//		sett.setSessionJobCreateTempVectorByKey(rows1);
//		sett.setSessionJobCreateTempVectorByKey(rows2);
//		sett.setSessionCreateTempVectorByKey(rows4);
//		sett.setSessionCreateTempVectorByKey(rows5);
//		System.out.println("校验集合");
//		Vector<String> jyset = sett.getSessionJobCreateTempVector();
//		for (String ss:jyset){
//			System.out.println(ss);
//		}
//		
//		Vector<String> jyset2 =sett.getSessionCreateTempVector();
//		for (String ss:jyset2){
//			System.out.println(ss);
//		}
//		System.out.println("校验完毕");
//		metaRows4Row mre =  new metaRows4Row();
//		mre.metaRows2Set("jobCreate", sett, "3126977", rows3);
//		System.out.println("校验集合");
//		Vector<String> jyseat = sett.getSessionJobCreateTempVector();
//		for (String ss:jyseat){
//			System.out.println(ss);
//		}
//		
//		Vector<String> jyseat2 =sett.getSessionCreateTempVector();
//		for (String ss:jyseat2){
//			System.out.println(ss);
//		}
//		System.out.println("校验完毕");
//	}
}
