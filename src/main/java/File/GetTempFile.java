//package File;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import entity.properties;
//import entity.rows;
//
//public class GetTempFile {
//	public static rows row;
//	
//	public GetTempFile(){
//		
//	}
//	public GetTempFile(rows row){
//	this.row=row;
//	}
//	public static void getTemp (){
////		String fileRoute = "/var/log/inceptorsql1/";
//		String filePath = System.getProperty("user.dir")
//			    + "/temp/runningTemp.tmp";
//		File file = new File(filePath);
//		BufferedReader br;
//		try {
//			br = new BufferedReader(
//					new InputStreamReader(
//							new FileInputStream(file)));
//		String rows = br.readLine();
//		
//		while (rows!=null){
//			String[] sz1 =  rows.split("=");
//			if (sz1[0].equals("oldfildsize")){
//				row.setOldnewfilesize(Integer.parseInt(sz1[1]));
//			}else if (sz1[0].equals("newfilesize")){
//				row.setNewnewfilesize(Integer.parseInt(sz1[1]));
//			}else{
//				row.setTemp(rows);
//			}
//		}
//		} catch (IOException e) {
//			row.setOldnewfilesize(0);
//			row.setNewnewfilesize(0);
//			row.setTemp("");
//		}
//	}
//}
