package Training;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class date {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Integer i = 1 ;
		
		if(i != null && i>=0){
			System.out.println("done");
		
		}
		Map<String, List<String>> fetchedData = new HashMap<String, List<String>>();
		
		
		
		
		System.setOut(new PrintStream(new FileOutputStream("./output.txt")));
		File currentDirFile = new File(".");
		String helper = currentDirFile.getAbsolutePath();
		String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());
		
		
		
		
		
		
		
		System.out.println(currentDir);
		
		PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));
		System.setOut(ps);
		
		String alphanumeric = "abc1234";
		System.out.println(System.identityHashCode(alphanumeric));
		 alphanumeric = "abc123435725732";
			System.out.println(System.identityHashCode(alphanumeric));
		
	
		
		
		
	String newalpahnumeric	= alphanumeric.replaceAll("[1-9]", "");
	System.out.println(newalpahnumeric);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = new Date();
	String curr = 	dateFormat.format(date).toString();
		
	String 	user = System.getProperty("user.dir").replaceAll("\\\\", "/");
	System.out.println(user);
	String 	user1 = System.getProperty("user.home");
	System.out.println(user1);
		String[] output = curr.split("\\s");
		System.out.println(output[0]);
		System.out.println(output[1]);
		
		
		
		
	}

}
