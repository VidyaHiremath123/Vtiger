package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromcmdLine {
	@Test
	public void test()
	{
		String BROWSER =System.getProperty("browser");
		System.out.println(BROWSER);
	}

}
