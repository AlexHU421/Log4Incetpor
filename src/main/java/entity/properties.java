package entity;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 该类引入了连接池来管理连接，
 * 连接池代替了DriverManager。
 * 它是DBTool的升级版。
 */
public class properties {
	static String file;
	static int interval;
	static {		
		//1.只读取一次连接参数
		Properties p = new Properties();
		try {
			//开发读取
//			p.load(Properties.class.getClassLoader()
//					.getResourceAsStream("db.properties"));
			//打包读取
			 String filePath = System.getProperty("user.dir")
					    + "/config.properties";
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
//			FileInputStream in = new FileInputStream("/tmp/ttt/db.properties");
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败",e);
		}
		file = p.getProperty("file");
		interval = Integer.parseInt(p.getProperty("interval"));
		
	}
	
	


	public static int getInterval() {
		return interval;
	}




	public static String getFile() {
		return file;
	}




	/**
	 * 由连接池创建的连接，其close()被连接池改为
	 * 归还的作用，而不是真正关闭连接。并且归还时，
	 * 该连接内的数据被清空，状态重置为空闲态。
	 */
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("归还连接失败",e);
			}
		}
	}
	
	
}










