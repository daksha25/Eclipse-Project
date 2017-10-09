import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Main {
public static void main(String args[])
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:1443/Registration","root","daksha25*");
			Statement stmt = con.createStatement();
			String str="insert into form1 "+"values('aa','dd','ffes')";
			stmt.executeUpdate(str);
			
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
}
}
