package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderPractice 
{
	
	@Test (dataProvider="getData")
	public void addToCart(String name,int price,int qty,String colour,boolean isAvailable)
	{
		System.out.println("..."+name+"...."+price+"..."+qty+"...."+colour+"...."+isAvailable+"....");
	}
	@DataProvider
	public Object[][] getData()
	{                              //row//cell
		Object[][] data =new Object[2][5];
		
		data[0][0]="samsung";
		data[0][1]="1000";
		data[0][2]="12";
		data[0][3]="black";
		data[0][4]="true";
		
		data[1][0]="samsung1";
		data[1][1]="10004";
		data[1][2]="13";
		data[1][3]="blue";
		data[1][4]="false";
		return data;
		
		
	}

}
