package util;

import java.net.InetAddress;

public class findIP {
	public String findIP(){
		InetAddress ia=null;
        try {
            String localip=InetAddress.getLocalHost().getHostAddress();
            return localip;
        } catch (Exception e) {
        	return "";
        }
	}
}
