import java.util.ArrayList;

public class test2 {
	public static ArrayList<String> a;
	public static int b;
	public static ArrayList<String> c;
	public  test2(){
		
	}
	public test2(ArrayList<String> a,int b,ArrayList<String> c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public void x (){
		a.add("x");
		b=1;
		test3 t3 =  new test3(a,b,c);
		t3.x();
		
	}
}
