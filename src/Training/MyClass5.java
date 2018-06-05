package Training;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.*;

public class MyClass5 {

	public String path;
	public static FileInputStream fis;
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	public static void main(String args[]) throws Exception {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		fis = new FileInputStream("C://Users//bj053527//Desktop//charge.xlsx");
		ExcelWBook = new XSSFWorkbook(fis);
		ExcelWSheet = ExcelWBook.getSheetAt(0);

		int rowcount = ExcelWSheet.getPhysicalNumberOfRows();

		Element rootElement = doc.createElement("RootElement");
		doc.appendChild(rootElement);

		for (int i = 1; i < rowcount; i++) {
			String strprocedureCode = null;
			String strModifiers = null;
			
			String strrevenuecode1 = String.valueOf(ExcelWSheet.getRow(i).getCell(3).getNumericCellValue());
			System.out.println(strrevenuecode1);
			String strrevenuecode = strrevenuecode1.split("\\.")[0].trim();
			System.out.println(strrevenuecode);

			if (ExcelWSheet.getRow(i).getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
				strprocedureCode = ExcelWSheet.getRow(i).getCell(1).getStringCellValue().trim();
			} else {
				String strprocedureCode1 = String.valueOf(ExcelWSheet.getRow(i).getCell(1).getNumericCellValue());
				System.out.println(strprocedureCode1);
				strprocedureCode = strprocedureCode1.split("\\.")[0].trim();
				System.out.println(strprocedureCode);
			}
			String strserviceFromDate = ExcelWSheet.getRow(i).getCell(4).getStringCellValue().trim();
			String strunitsOfService1 = String.valueOf(ExcelWSheet.getRow(i).getCell(5).getNumericCellValue());
			System.out.println(strunitsOfService1);
			String strunitsOfService = strunitsOfService1.split("\\.")[0].trim();
			System.out.println(strunitsOfService);
			String strTotalCharges = String.valueOf(ExcelWSheet.getRow(i).getCell(6).getNumericCellValue()).trim();
			System.out.println(strTotalCharges);
if(ExcelWSheet.getRow(i).getCell(2)!=null){
			if (ExcelWSheet.getRow(i).getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
				strModifiers = ExcelWSheet.getRow(i).getCell(2).getStringCellValue().trim();
			} else {
				String strModifiers1 = String.valueOf(ExcelWSheet.getRow(i).getCell(2).getNumericCellValue());
				System.out.println(strModifiers1);
				strModifiers = strModifiers1.split("\\.")[0].trim();
				System.out.println(strModifiers);
			}
}
			String strItemNumber1 = String.valueOf(ExcelWSheet.getRow(i).getCell(0).getNumericCellValue());
			System.out.println(strItemNumber1);
			String strItemNumber = strItemNumber1.split("\\.")[0].trim();
			System.out.println(strItemNumber);

			Element FacilityLineItems = doc.createElement("FacilityLineItems");
			rootElement.appendChild(FacilityLineItems);

			// RevenueCode elements
			Element RevenueCode = doc.createElement("RevenueCode");
			RevenueCode.appendChild(doc.createTextNode(strrevenuecode));
			FacilityLineItems.appendChild(RevenueCode);

			// RevenueCode elements
			Element ProcedureCode = doc.createElement("ProcedureCode");
			ProcedureCode.appendChild(doc.createTextNode(strprocedureCode));
			FacilityLineItems.appendChild(ProcedureCode);

			// RevenueCode elements
			Element ServiceFromDate = doc.createElement("ServiceFromDate");
			ServiceFromDate.appendChild(doc.createTextNode(strserviceFromDate));
			FacilityLineItems.appendChild(ServiceFromDate);

			// RevenueCode elements
			Element UnitsOfService = doc.createElement("UnitsOfService");
			UnitsOfService.appendChild(doc.createTextNode(strunitsOfService));
			FacilityLineItems.appendChild(UnitsOfService);

			// RevenueCode elements
			Element TotalCharges = doc.createElement("TotalCharges");
			TotalCharges.appendChild(doc.createTextNode(strTotalCharges));
			FacilityLineItems.appendChild(TotalCharges);

			Element Modifers = doc.createElement("Modifiers");
			Modifers.appendChild(doc.createTextNode(strModifiers));
			FacilityLineItems.appendChild(Modifers);

			// RevenueCode elements
			Element ItemNumber = doc.createElement("ItemNumber");
			ItemNumber.appendChild(doc.createTextNode(strItemNumber));
			FacilityLineItems.appendChild(ItemNumber);

			System.out.println("The row number is ::" + i);

		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("./demo1.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

		// Document elements
		/*
		 * Document doc = docBuilder.parse(new File("./demo.xml"));
		 * 
		 * // Node firstChild = doc.getFirstChild(); //
		 * System.out.println(firstChild.getChildNodes().getLength()); //
		 * System.out.println(firstChild.getNodeType()); //
		 * System.out.println(firstChild.getNodeName());
		 * 
		 * Node root = doc.getDocumentElement();
		 * 
		 * System.out.println(root.getChildNodes().getLength());
		 * 
		 * System.out.println(root.getNodeType());
		 * System.out.println(root.getNodeName());
		 */

	}

}