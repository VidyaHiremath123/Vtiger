package vtiger_GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetUtility 
{
	public String readDataFromExcelSheetFile(String sheetName,int  rowNo,int cellNo ) throws IOException
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\ExcelFilePractice.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
		
		
	}
	public void writeIntoExcelSheet(String sheetName,int  rowNo,int cellNo,String value ) throws EncryptedDocumentException, IOException  
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\ExcelFilePractice.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet(sheetName);
		Row rw=sh.createRow(rowNo);
		Cell cel=rw.createCell(cellNo);
		cel.setCellValue(value);
		FileOutputStream fos =new FileOutputStream(".\\src\\test\\resources\\ExcelFilePractice.xlsx");
		wb.write(fos);
		wb.close();
		
		
		
	}
	public Object[][] readDataFromExceltoDataProvider(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\ExcelFilePractice.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for (int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		return data;
	}
	/**
	 * read the date based on testId and Required Column name 
	 * @param filePath
	 * @param sheetName
	 * @param testId
	 * @param columnHeader
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getDataFromExcelBasedTestId(String filePath, String sheetName , String testId, String columnHeader ) throws Throwable, IOException {
		FileInputStream fis1 = new FileInputStream(filePath);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int testRowNum = 0;
		String actTestID="";
		String actColHeaderName="";
		String data="";
		
		for(int i=0; i<=rowCount; i++) {
			try { actTestID = sheet.getRow(i).getCell(0).toString();} catch (Exception e) {}

			if(actTestID.equalsIgnoreCase(testId)) {
				break;				
			}
			testRowNum++;
		}
		int testColNum =0;
		int celCountforTest = sheet.getRow(testRowNum-1).getLastCellNum();
		for(int j=0; j<celCountforTest; j++) {
			try {actColHeaderName =  sheet.getRow(testRowNum-1).getCell(j).toString(); } catch (Exception e) {}
			if(actColHeaderName.equalsIgnoreCase(columnHeader)) {
				break;
			}
			testColNum++;
		}
		try {data =  sheet.getRow(testRowNum).getCell(testColNum).toString();}catch (Exception e) {}
		return data;
	}
}
			
		
		
		
	
		
		


