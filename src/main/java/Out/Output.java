package Out;

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
	private static String separator = ":this is separator:";
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
				 String filename = "C:\\Users\\Alex.hu\\Desktop\\log\\testSession";
//				 String filename = "/tmp/testLog/session/test";
				FileOutputStream bw = new FileOutputStream(filename+System.currentTimeMillis()+".log");
//				FileOutputStream bw = new FileOutputStream("/tmp/testLog/test.log");
				 	for(String str:v){
				 		str =IP+separator+str+"\r\n";  
//				 		System.out.println(str);
				 		bw.write(str.getBytes());
				 }
				 bw.close();
			} catch (IOException e) {
			}
		}
		if ("task".equals(Key)){
			 try {
				 System.out.println("Task OutPut OK");
				 String filename = "C:\\Users\\Alex.hu\\Desktop\\log\\testTask";
//				 String filename = "/tmp/testLog/task/test";
				FileOutputStream bw = new FileOutputStream(filename+System.currentTimeMillis()+".log");
//				FileOutputStream bw = new FileOutputStream("/tmp/testLog/test.log");
				 	for(String str:v){
				 		str+="\r\n";  
//				 		System.out.println(str);
				 		bw.write(str.getBytes());
				 }
				 bw.close();
			} catch (IOException e) {
			}
		}
		if ("stage".equals(Key)){
			 try {
				 System.out.println("Stage OutPut OK");
				 String filename = "C:\\Users\\Alex.hu\\Desktop\\log\\testStage";
//				 String filename = "/tmp/testLog/task/test";
				FileOutputStream bw = new FileOutputStream(filename+System.currentTimeMillis()+".log");
//				FileOutputStream bw = new FileOutputStream("/tmp/testLog/test.log");
				 	for(String str:v){
				 		str+="\r\n";  
//				 		System.out.println(str);
				 		bw.write(str.getBytes());
				 }
				 bw.close();
			} catch (IOException e) {
			}
		}
	}
}
