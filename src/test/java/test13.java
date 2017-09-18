
public class test13 {
public static void main(String[] args) {
	String stime ="1501118458497";
	String etime ="1501118458809";
//	test13 ts = new test13();
	Long runtime = mathRuntime(stime,etime);
	System.out.println(runtime);
}

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
}
