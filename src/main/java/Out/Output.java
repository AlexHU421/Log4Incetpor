package Out;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Vector;

import entity.rows;
import entity.entityset.SessionVector;
import entity.entityset.StageVector;
import entity.entityset.TaskVector;
import util.findIP;

public class Output {
	public static SessionVector sessionVector;
	public static StageVector stageVector;
	public static TaskVector taskVector;
	public static findIP findIP;
	public static rows rowentity;
	private static String separator = ":this is separator:";
	private static String temp;
	public Output(){
		
	}
	
	public Output(SessionVector sessionVector,StageVector stageVector,TaskVector taskVector){
		this.sessionVector=sessionVector;
		this.stageVector=stageVector;
		this.taskVector=taskVector;
	}
	
	
	public void outByVector (String Key,Vector<String> v){
		if ("session".equals(Key)){
			 try {
				 String IP = "";
				 try{
				 IP = InetAddress.getLocalHost().getHostAddress();
				 }catch (Exception e) {
					 
				 }
				 System.out.println("IP:  "+IP);
				 System.out.println("Session OutPut OK");
				 //开发目录
//				 String filename = "C:\\Users\\Alex.hu\\Desktop\\log\\testSession";
				 //部署目录
				 String filename = System.getProperty("user.dir")
						    + "/session/testSession";
				 BufferedWriter  bw = new BufferedWriter (new FileWriter(filename+System.currentTimeMillis()+".log"));
//				FileOutputStream bw = new FileOutputStream("/tmp/testLog/test.log");
				 	for(String str:v){
				 		str =IP+separator+str+"\r\n";  
//				 		System.out.println(str);
				 		bw.write(str);
				 }
				 bw.close();
			} catch (IOException e) {
			}
		}
//		if ("temp".equals(Key)){
//			 try {
//				 System.out.println("Temp OutPut OK");
//				 String filename = "C:\\Users\\Alex.hu\\Desktop\\log\\temp\\runningTemp.tmp";
////				 String filename = "/tmp/testLog/temp/runningTemp.tmp";
//				 BufferedWriter  bw = new BufferedWriter (new FileWriter(filename));
////				FileOutputStream bw = new FileOutputStream("/tmp/testLog/test.log");
//				temp = "newfilesize="+rowentity.getNewnewfilesize();
//			 		bw.write(temp);
//			 	temp = "oldfildsize="+rowentity.getOldnewfilesize();
//			 		bw.write(temp);
//			 	temp =  ""+rowentity.getTemp();
//			 		bw.write(temp);
//				 bw.close();
//			} catch (IOException e) {
//			}
//		}
		
		
//		if ("task".equals(Key)){
//			 try {
//				 System.out.println("Task OutPut OK");
//				 String filename = "C:\\Users\\Alex.hu\\Desktop\\log\\testTask";
////				 String filename = "/tmp/testLog/task/test";
//				FileOutputStream bw = new FileOutputStream(filename+System.currentTimeMillis()+".log");
////				FileOutputStream bw = new FileOutputStream("/tmp/testLog/test.log");
//				 	for(String str:v){
//				 		str+="\r\n";  
////				 		System.out.println(str);
//				 		bw.write(str.getBytes());
//				 }
//				 bw.close();
//			} catch (IOException e) {
//			}
//		}
//		if ("stage".equals(Key)){
//			 try {
//				 System.out.println("Stage OutPut OK");
//				 String filename = "C:\\Users\\Alex.hu\\Desktop\\log\\testStage";
////				 String filename = "/tmp/testLog/task/test";
//				FileOutputStream bw = new FileOutputStream(filename+System.currentTimeMillis()+".log");
////				FileOutputStream bw = new FileOutputStream("/tmp/testLog/test.log");
//				 	for(String str:v){
//				 		str+="\r\n";  
////				 		System.out.println(str);
//				 		bw.write(str.getBytes());
//				 }
//				 bw.close();
//			} catch (IOException e) {
//			}
//		}
	}
}
