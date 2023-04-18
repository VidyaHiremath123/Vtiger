package vtiger.Practice;

import java.io.IOException;

import vtiger_GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String data=pUtil.readDataFromPropertyFile("url");
		String data1=pUtil.readDataFromPropertyFile("browser");
		System.out.println(data);
		System.out.println(data1);
		
		

	}

}
