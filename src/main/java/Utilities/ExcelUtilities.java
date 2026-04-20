package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	
	public static String testDataPath = System.getProperty("user.dir")+ "/src/test/resources/TestData.xlsx";
	
	
	
	
	
	public static Object[][] getData(String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(testDataPath);
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		int rowCount  = sheet.getPhysicalNumberOfRows();
		
		
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		
		for (int r = 1; r < rowCount; r++) {

            Row row = sheet.getRow(r);

            for (int c = 0; c < colCount; c++) {

                Cell cell = row.getCell(c);

                if (cell == null) {
                    data[r - 1][c] = "";
                } else {
                    data[r - 1][c] = cell.toString();
                }
            }
        }
		
		workbook.close();
		return data;
		
	}
	

}
