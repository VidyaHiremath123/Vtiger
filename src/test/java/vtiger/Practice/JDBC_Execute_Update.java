package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Execute_Update 
{
	@Test
	public void sample() throws SQLException
	{
	
	
		    Driver driverRef = new Driver();
	
		    DriverManager.registerDriver(driverRef);
		    
		
	
		    // Step 2: get the connection with database // give db name
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm27", "root", "Client");
		
		    Statement state = con.createStatement();
		
		    // Step 4: Execute a query // give table name
		
		    String query = "insert into wcsm27_info values('BatMan',13,'California');";
		
		    int result = state.executeUpdate(query);
		
		    System.out.println(result);
		
		    if(result==1)
		
		    {
	    System.out.println("data is added");
		
		    }
		
		    else
		
		    {
		
		      System.out.println("data not added");
		
		    }
		
		    
		    // Step 5: Close the database
		
		    con.close();
		
		    System.out.println("db closed");


		


		

	}

}
