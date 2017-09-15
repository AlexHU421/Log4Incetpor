import java.util.ArrayList;
import java.util.regex.Pattern;

public class test8 {
	static Pattern p;
	public static void main(String[] args) {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("2017-07-27 09:25:54,465 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][18787307]Job: 3127901 Stage: 3081674.0 Duration: 250 ms TaskTime: 0 ms TaskCount: 3 ShufRead: 0 ShufWrite: 0 GCTime: 0.0 ms FSTouchTime: 0.0 ms RemoteFetchTime: 0.0 ms FetchWaitTime: 0.0 ms ShufWriteTime: 0.0 ms ShufCompactTime: 0.0 ms"); 
		ar.add("2017-07-27 09:25:54,473 INFO  leviathan.TimedEventTracker: (Logging.scala:logInfo(59)) [SparkListenerBus()] - [Leviathan][-1]None.get");
		ar.add("2017-07-27 09:25:54,473 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - Finished stage: org.apache.spark.scheduler.StageInfo@2fd320d5");
		ar.add("2017-07-27 09:25:54,473 ERROR execution.SparkTask: (Logging.scala:logError(96)) [HiveServer2-Handler-Pool: Thread-8953762(SessionHandle=0b832eb6-5ce7-4164-89e4-609188bb3dd6)] - Spark task execution is failed.");
		ar.add("org.apache.spark.SparkException: Job aborted due to stage failure: Task 1 in stage 3081674.0 failed 4 times, most recent failure: Lost task 1.3 in stage 3081674.0 (TID 3190787, dbclusternode013): org.apache.hadoop.hive.ql.metadata.HiveException: Index: 3, Size: 3");
		ar.add("org.apache.hadoop.hive.ql.exec.FileSinkOperator.processOp(FileSinkOperator.java:1143)");
		ar.add("io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$processPartition$3.apply(FileSinkOperator.scala:118)");
		ar.add("io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$processPartition$3.apply(FileSinkOperator.scala:115)");
		ar.add("scala.collection.Iterator$class.foreach(Iterator.scala:727)");
		ar.add("org.apache.spark.util.CompletionIterator.foreach(CompletionIterator.scala:25)");
		ar.add("ar.add(\"io.transwarp.inceptor.execution.FileSinkOperator.processPartition(FileSinkOperator.scala:115)");
		ar.add("io.transwarp.inceptor.execution.FileSinkOperator$.io$transwarp$inceptor$execution$FileSinkOperator$$writeFiles$1(FileSinkOperator.scala:289)");
		ar.add("io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$executeProcessFileSinkPartition$1.apply(FileSinkOperator.scala:293)");
		ar.add("io.transwarp.inceptor.execution.FileSinkOperator$$anonfun$executeProcessFileSinkPartition$1.apply(FileSinkOperator.scala:293)");
		ar.add("org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:73)");
		ar.add("org.apache.spark.scheduler.Task.run(Task.scala:62)");
		ar.add("org.apache.spark.executor.Executor$TaskRunner$$anonfun$run$1.apply$mcV$sp(Executor.scala:265)");
		ar.add("org.apache.spark.deploy.SparkHadoopUtil.runAsUser(SparkHadoopUtil.scala:58)");
		ar.add("ar.add(\"org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:224)");
		ar.add("java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)");
		ar.add("ar.add(\"java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)");
		ar.add("java.lang.Thread.run(Thread.java:745)");
		ar.add("Driver stacktrace:");
		ar.add("at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1595)");
		ar.add("at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1584)");
		ar.add("at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1583)");
		ar.add("at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)");
		ar.add("at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)");
		ar.add("at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1583)");
		ar.add("at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:992)");
		ar.add("at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:992)");
		ar.add("at scala.Option.foreach(Option.scala:236)");
		ar.add("at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:992)");
		ar.add("at org.apache.spark.scheduler.DAGSchedulerEventProcessActor$$anonfun$receive$2.applyOrElse(DAGScheduler.scala:1836)");
		ar.add("at scala.runtime.AbstractPartialFunction$mcVL$sp.apply$mcVL$sp(AbstractPartialFunction.scala:33)");
		ar.add("at scala.runtime.AbstractPartialFunction$mcVL$sp.apply(AbstractPartialFunction.scala:33)");
		ar.add("at scala.runtime.AbstractPartialFunction$mcVL$sp.apply(AbstractPartialFunction.scala:25)");
		ar.add("at org.apache.spark.scheduler.DAGSchedulerEventProcessActor$$anonfun$receiveTiming$1.applyOrElse(DAGScheduler.scala:1792)");
		ar.add("at akka.actor.ActorCell.receiveMessage(ActorCell.scala:498)");
		ar.add("at akka.actor.ActorCell.invoke(ActorCell.scala:456)");
		ar.add("at akka.dispatch.Mailbox.processMailbox(Mailbox.scala:237)");
		ar.add("at akka.dispatch.Mailbox.run(Mailbox.scala:219)");
		ar.add("at akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinTask.exec(AbstractDispatcher.scala:386)");
		ar.add("at scala.concurrent.forkjoin.ForkJoinTask.doExec(ForkJoinTask.java:260)");
		ar.add("at scala.concurrent.forkjoin.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1339)");
		ar.add("at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)");
		ar.add("at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)");
		ar.add("2017-07-27 09:25:54,473 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - task runtime:(count: 8, mean: 81.375000, stdev: 33.510959, max: 132.000000, min: 42.000000)");
		ar.add("2017-07-27 09:25:54,473 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	0%	5%	10%	25%	50%	75%	90%	95%	100%");
		ar.add("2017-07-27 09:25:54,473 INFO  ql.Driver: (PerfLogger.java:PerfLogEnd(133)) [HiveServer2-Handler-Pool: Thread-8953762(SessionHandle=0b832eb6-5ce7-4164-89e4-609188bb3dd6)] - </PERFLOG method=task.MAPRED-SPARK.Stage-0 start=1501118754174 end=1501118754473 duration=299>");
		ar.add("2017-07-27 09:25:54,473 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	42.0 ms	42.0 ms	42.0 ms	54.0 ms	82.0 ms	123.0 ms	132.0 ms	132.0 ms	132.0 ms");
		ar.add("2017-07-27 09:25:54,474 ERROR ql.Driver: (SessionState.java:printError(1310)) [HiveServer2-Handler-Pool: Thread-8953762(SessionHandle=0b832eb6-5ce7-4164-89e4-609188bb3dd6)] - EXECUTION FAILED: Task MAPRED-SPARK error SparkException: [Error 1] Job aborted due to stage failure: Task 1 in stage 3081674.0 failed 4 times, most recent failure: Lost task 1.3 in stage 3081674.0 (TID 3190787, dbclusternode013): org.apache.hadoop.hive.ql.metadata.HiveException: Index: 3, Size: 3");
		ar.add("2017-07-27 09:25:54,474 INFO  ql.Driver: (PerfLogger.java:PerfLogEnd(133)) [HiveServer2-Handler-Pool: Thread-8953762(SessionHandle=0b832eb6-5ce7-4164-89e4-609188bb3dd6)] - </PERFLOG method=Driver.execute start=1501118754174 end=1501118754474 duration=300>");
		ar.add("2017-07-27 09:25:54,474 INFO  ql.Driver: (Driver.java:restoreDriverConfiguration(1616)) [HiveServer2-Handler-Pool: Thread-8953762(SessionHandle=0b832eb6-5ce7-4164-89e4-609188bb3dd6)] - Restore the configuration ngmr.exec.mode to cluster");
		ar.add("2017-07-27 09:25:54,474 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - task result size:(count: 8, mean: 0.000000, stdev: 0.000000, max: 0.000000, min: 0.000000)");
		ar.add("2017-07-27 09:25:54,474 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	0%	5%	10%	25%	50%	75%	90%	95%	100%");
		ar.add("2017-07-27 09:25:54,474 WARN  thrift.ThriftCLIService: (ThriftCLIService.java:ExecuteStatement(557)) [HiveServer2-Handler-Pool: Thread-8953762()] - Error executing statement:"); 
		ar.add("org.apache.hive.service.cli.HiveSQLException: EXECUTION FAILED: Task MAPRED-SPARK error SparkException: [Error 1] Job aborted due to stage failure: Task 1 in stage 3081674.0 failed 4 times, most recent failure: Lost task 1.3 in stage 3081674.0 (TID 3190787, dbclusternode013): org.apache.hadoop.hive.ql.metadata.HiveException: Index: 3, Size: 3");
		ar.add("at io.transwarp.inceptor.server.InceptorSQLOperation.runInternal(InceptorSQLOperation.scala:84)");
		ar.add("at org.apache.hive.service.cli.operation.Operation.run(Operation.java:279)");
		ar.add("at org.apache.hive.service.cli.session.HiveSessionImpl.executeStatementInternal(HiveSessionImpl.java:427)");
		ar.add("at org.apache.hive.service.cli.session.HiveSessionImpl.executeStatementWithParamsAndPropertiesAsync(HiveSessionImpl.java:394)");
		ar.add("at org.apache.hive.service.cli.CLIService.executeStatementWithParamsAndPropertiesAsync(CLIService.java:320)");
		ar.add("at io.transwarp.inceptor.server.InceptorCLIService.executeStatementWithParamsAndPropertiesAsync(InceptorCLIService.scala:130)");
		ar.add("at org.apache.hive.service.cli.thrift.ThriftCLIService.ExecuteStatement(ThriftCLIService.java:546)");
		ar.add("at org.apache.hive.service.cli.thrift.TCLIService$Processor$ExecuteStatement.getResult(TCLIService.java:1737)");
		ar.add("at org.apache.hive.service.cli.thrift.TCLIService$Processor$ExecuteStatement.getResult(TCLIService.java:1722)");
		ar.add("at org.apache.thrift.ProcessFunction.process(ProcessFunction.java:39)");
		ar.add("at org.apache.thrift.TBaseProcessor.process(TBaseProcessor.java:39)");
		ar.add("at org.apache.hive.service.auth.TSetIpAddressProcessor.process(TSetIpAddressProcessor.java:56)");
		ar.add("at org.apache.thrift.server.TThreadPoolServer$WorkerProcess.run(TThreadPoolServer.java:285)");
		ar.add("at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)");
		ar.add("at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)");
		ar.add("at java.lang.Thread.run(Thread.java:745)");
		ar.add("2017-07-27 09:25:54,474 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B	0.0 B");
		ar.add("2017-07-27 09:25:54,474 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - executor (non-fetch) time pct: (count: 8, mean: 85.811032, stdev: 14.569675, max: 97.560976, min: 54.629630)");
		ar.add("2017-07-27 09:25:54,475 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	0%	5%	10%	25%	50%	75%	90%	95%	100%");
		ar.add("2017-07-27 09:25:54,475 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	55 %	55 %	55 %	89 %	95 %	96 %	98 %	98 %	98 %");
		ar.add("2017-07-27 09:25:54,475 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - other time pct: (count: 8, mean: 14.188968, stdev: 14.569675, max: 45.370370, min: 2.439024)");
		ar.add("2017-07-27 09:25:54,475 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	0%	5%	10%	25%	50%	75%	90%	95%	100%");
		ar.add("2017-07-27 09:25:54,475 INFO  scheduler.StatsReportListener: (Logging.scala:logInfo(59)) [SparkListenerBus()] - 	 2 %	 2 %	 2 %	 5 %	10 %	31 %	45 %	45 %	45 %");
		ar.add("2017-07-27 09:25:54,489 WARN  scheduler.TaskSetManager: (Logging.scala:logWarning(71)) [Result resolver thread-1()] - Lost task 0.2 in stage 3081674.0 (TID 3190788, dbclusternode013): TaskKilled (killed intentionally)");
		ar.add("2017-07-27 09:25:54,490 WARN  jobs.LocalJobProgressListener: (Logging.scala:logWarning(71)) [SparkListenerBus()] - Task start for unknown stage 3081674");
		
		
		
		for(String str:ar){
			if(p.compile("(SparkListenerBus)").matcher(str).find()){
				if (p.compile("Job\\: \\d+ Stage\\: \\d+\\.\\d+ Duration\\: \\d+ ms TaskTime\\: \\d+ ms TaskCount\\: ").matcher(str).find()){
					System.out.println("SBUS END");
				}
				System.out.println(str);
			}
		}
		}
		}
		