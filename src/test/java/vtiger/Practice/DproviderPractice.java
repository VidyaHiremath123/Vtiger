package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DproviderPractice 
{
	@Test(dataProvider="getdata")
	public void getdatafromdprovider(String name,int id,String subject,int marks)
	{
		System.out.println("..."+name+"...."+id+"..."+subject+"...."+marks+"....");
		
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj=new Object[3][4];
		obj[0][0]="praveen";
		obj[0][1]=231;
	    obj[0][2]="maths";
	    obj[0][3]=100;
	    
	    obj[1][0]="naveen";
	    obj[1][1]="123";
	    obj[1][2]="hindi";
	    obj[1][3]=50;
	    
	    obj[2][0]="naveen";
	    obj[2][1]="123";
	    obj[2][2]="hindi";
	    obj[2][3]=50;
		return obj;
	  }
	}


