package Training;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Write a Java program that prints out a triangle
 *
 * *
 * **
 * ***
 * etc
 *
 * @author http://learn-java-by-example.com
 *
 */
 
public class MyClass10 {
 
   public static void main(String[] args) {
 
      // Our triangle will have 10 lines
      // One loop iteration each line
 int num =12345;
  int revNum = 0;
  
  while (num!=0){
	  
	  revNum = revNum * 10;
	  
	  revNum = revNum + num%10;
	  
	  num = num /10;
	  
  }

	   
	 System.out.println(revNum);  
	 
	 String str = "Bibhuti";
	 String strReverse ="";
	 for(int i=str.length()-1;i>=0;i--){
		strReverse = strReverse + str.charAt(i);
	 }
	 
	 System.out.println(strReverse);  
	   
	   /*  for (int i=1; i<10; i+=2) {
 
         // For each loop iteration 
                        // we want to print a number of stars
         // 1st line -> 1 star
         // 2nd line -> 2 star
         // ...
    	  
    	  for (int k=0; k < (4 - i / 2); k++)
    	    {
    	        System.out.print(" ");
    	    }
 
         for (int j=0;j<i; j++) {
            System.out.print("*");
         }
        System.out.println();*/
             
        String s = "Google";
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i1 = 0; i1 < s.length(); i1++) {
        char c = s.charAt(i1);
        if (map.containsKey(c)) {
        int cnt = map.get(c);
        map.put(c, ++cnt);
        } else {
        map.put(c, 1);
        }
        }
        
        for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }
        
        
        
   }
}

        
        
        
        
    
  