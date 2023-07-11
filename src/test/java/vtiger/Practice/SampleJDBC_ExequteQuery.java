package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC_ExequteQuery 
{
	@Test
	public void sample() throws SQLException 
	{
		//step1:register the driver to DB
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		//step2:get connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm27","root","Client");
		//step3:Issue create statement
		Statement state=con.createStatement();
		//step4:execute query
		ResultSet result=state.executeQuery("select * from wcsm27_info;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"-"+result.getString(2)+"-"+result.getString(3));
		}
		con.close();
		System.out.println("dataBase Closed");
		
		//step5:close the database
	}

}
