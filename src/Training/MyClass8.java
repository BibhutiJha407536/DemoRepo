package Training;

import org.apache.commons.codec.binary.Base64;

public class MyClass8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String password = "India";
		byte[] encordedpassw = Base64.encodeBase64(password.getBytes());
		
		String encordedpassword = new String(encordedpassw);
		
		
		byte[] decodedpassw = Base64.decodeBase64(encordedpassw)	;
		
		String decodedpassword = new String(decodedpassw);
		
		String directory = System.getProperty("user.dir");
		
		System.out.println(directory);
	}

}
