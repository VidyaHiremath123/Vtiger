package vtiger.Practice;

import java.io.IOException;

import vtiger_GenericUtilities.ExcelSheetUtility;

public class ExcelSheetFilePractice {

	public static void main(String[] args) throws IOException {
		//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\ExcelFilePractice.xlsx");
		ExcelSheetUtility ex=new ExcelSheetUtility();
		String value=ex.readDataFromExcelSheetFile( "Organisation",1,2 );
		System.out.println(value);

	}

}
