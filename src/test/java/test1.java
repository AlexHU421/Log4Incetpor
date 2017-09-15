import java.util.ArrayList;

public class test1 {
	public static ArrayList<String> a =  new ArrayList<String>();
	public static int b;
	public static ArrayList<String> c =  new ArrayList<String>();
	public static void main(String[] args) {
		test2 t2 =  new test2(a,b,c);
		t2.x();
		System.out.println(b);
	}
}
