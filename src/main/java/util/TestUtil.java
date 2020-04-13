package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 30;

	public static ArrayList<Object[]> getDataFromExcel() throws BiffException, IOException {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		File fi = new File("src/main/java/testdata/TestData.xls");

		Workbook wb = Workbook.getWorkbook(fi);
		Sheet ws = wb.getSheet("Registration Data");

		for (int i = 1; i <= ws.getRows() - 1; i++) {
				String CustomerName = ws.getCell(0, i).getContents();
				String CustomerLastName = ws.getCell(1, i).getContents();
				String Password = ws.getCell(2, i).getContents();	
				String SelectDay = ws.getCell(3, i).getContents();	
				String SelectMonth = ws.getCell(4, i).getContents();	
				String SelectYear= ws.getCell(5, i).getContents();	
				String Comp = ws.getCell(6, i).getContents();	
				String Add1 = ws.getCell(7, i).getContents();	
				String Add2 = ws.getCell(8, i).getContents();	
				String City = ws.getCell(9, i).getContents();	
				String State = ws.getCell(10, i).getContents();	
				String PostCode= ws.getCell(11, i).getContents();	
				String Other = ws.getCell(12, i).getContents();	
				String Phone = ws.getCell(13, i).getContents();	
				String MobilePhone= ws.getCell(14, i).getContents();	
				String Alias= ws.getCell(15, i).getContents();	
				
				
			Object ab[] = { 	CustomerName , CustomerLastName, Password,
									SelectDay, SelectMonth, SelectYear, Comp, Add1,
									Add2, City, State, PostCode, Other, Phone,
									MobilePhone, Alias};

			myData.add(ab);

		}
		return myData;

	}
	
}
