package vtiger_GenericUtilities;


import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
		
	}
	public String getSystemDate()
	{
		Date d= new Date();
		return d.toString();
	}
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] dArr=d.toString().split(" ");
		String date =dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":",".");
		String dateValue=date+"-"+month+"-"+year+"-"+time;
		return dateValue;
				
				
	}
	
		
	}


