package lchen.action.datafile;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApachePOI {
	
	public  String path;
	public static  FileInputStream fis = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		fis = new FileInputStream("C://Users//bj053527//Desktop//2nd half//ClassificationCode_all env//Historical//ICD10_HistoricalBase_Oct2017.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		fis.close();

	}

}