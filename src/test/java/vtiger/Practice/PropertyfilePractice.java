package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfilePractice {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		System.out.println(BROWSER);
		

	}

}
