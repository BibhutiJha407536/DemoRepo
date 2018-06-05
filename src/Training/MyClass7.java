package Training;



import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class MyClass7 {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo = new Fillo();
		
		
		Connection connection = fillo.getConnection("C://Users//bj053527//Desktop//data.xlsx");
		Recordset recordset = connection.executeQuery("Select * from Sheet1 where TC_Name='TestOne'");

		while (recordset.next()) {
			System.out.println(recordset.getField("Task"));
			
		}
		
	
		
		int count = recordset.getCount();
		recordset.moveFirst();
		String Value = recordset.getField("Task");
		System.out.println(Value);

		System.out.println(count);
	}
}


