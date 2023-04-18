package vtiger_GenericUtilities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice 
{
	@Test(retryAnalyzer=vtiger_GenericUtilities.RetryAnalyzerImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.err.println("HI");
	}
	

}
