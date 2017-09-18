package File;

import java.io.File;

import entity.properties;
import entity.rows;

public class GetLogFile {
	public static rows row;
	
	public GetLogFile(){
		
	}
	public GetLogFile(rows row){
	this.row=row;
	}
	public static File getFile (){
		properties p = new properties();
		String fileRoute = "/var/log/"+p.getFile();
//		String fileRoute = "C:\\Users\\Alex.hu\\Desktop\\log\\"+p.getFile();
		String Name = "/hive-server2.log";
		String fileName = fileRoute+Name;
		File file = new File(fileName);
		row.setNewnewfilesize((int)file.length()+1);
//		System.out.println("Get:"+row.toString());
		if (row.getOldnewfilesize()>row.getNewnewfilesize()){
			Name +=".1";
			file = new File (fileName);
			row.setCheckNewFile(true);
		}else{
			row.setCheckNewFile(false);
		}
		
		return file;
//		return new File("/var/log/inceptorsql1/hive-server2.log");
	}
}
