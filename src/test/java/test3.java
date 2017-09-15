import java.util.ArrayList;

public class test3 {
	public static ArrayList<String> a;
	public static int b;
	public static ArrayList<String> c;
	public  test3(){
		
	}
	public test3(ArrayList<String> a,int b,ArrayList<String> c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public void x (){
		for (String str:a){
			System.out.println(str);
		}
		System.out.println(b);
	}
}
