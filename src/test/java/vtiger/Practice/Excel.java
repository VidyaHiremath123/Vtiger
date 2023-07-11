package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vtiger_GenericUtilities.ExcelSheetUtility;



public class Excel {
	public static void main(String[] args) throws Throwable, IOException {
		ExcelSheetUtility eutil=new ExcelSheetUtility();
		Object[][]value=eutil.readDataFromExceltoDataProvider("contacts");
		System.out.println(value);
		
		
		
	}

}
