package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\ExcelFilePractice.xlsx");
		Workbook wb=WorkbookFactory .create(fis);
		Sheet sh=wb.getSheet("Organisation");
		Row rw=sh.getRow(1);
		Cell ce=rw.createCell(7);
		ce.setCellValue("Vidya");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\ExcelFilePractice.xlsx");
		wb.write(fos);
		System.out.println("done");
		//wb.close();
	}
	
	

}
