
import java.sql.*;


public class DBConnect 

{

	   private Connection conn;
	   private Statement stmt;
	   private ResultSet res;


public DBConnect(){
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:1443/test","root","daksha25*");
		   stmt = conn.createStatement();
	   }
	   catch(Exception e){
		   
		   System.out.println(e);
	   }
	   
}
public void getdata()
{
try
{
	
	String query = "select * from sneha";
	res= stmt.executeQuery(query);
	System.out.println("Records from database");
	{
	while (res.next())
	{
		String name=res.getString("name");
		System.out.println("Name :"+name);
	}
	}
}
catch(Exception ex)
{
	System.out.println(ex);
}

}
}