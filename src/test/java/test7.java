
public class test7 {

	public static void main(String[] args) {

		
		String error = "1501116253329:this is separator:31723f4b-2996-47c4-baf8-a5849b594440:this is separator:3126977:this is separator:select id from esm_sys_role limit 1:this is separator:3080830:this is separator:3080830:this is separator:1501116253223:this is separator:1501116253547:this is separator:true:mustBeCheckError:";
		String [] sz1= error.split(":this is separator:");
		int x = 0;
		for (String info:sz1){
			System.out.println(x);
			x++;
			System.out.println(info);
		}
	
	}

}
