package Training;

import java.util.ArrayList;

public class prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		String Number = "101110111";
		String ReqNumber = Number.replaceAll("0", "");
		int Count = 0;
		for (int i=0;i<Number.length();i++){
			char a = Number.charAt(i);
			
	if (Character.toString(a).equals("0")){
		Count = Count+1 ;
	}
		
		}
		
		for (int j = 0; j < Count ;j++) {
			ReqNumber = "0" +	ReqNumber;
		}
		System.out.println(ReqNumber);
	}
}
		
		
		
	/*	String name = "joyce2" ;
		String mname = "";
		
		for (int i = 0; i < name.length(); i++) {
			
			char a = name.charAt(i);
			boolean status = Character.isDigit(a);
			
		if (status == false	){
			
			
			
			mname = mname + a;
			
		}
		
		
			
		}
		
		System.out.println(mname);	*/
		
		


