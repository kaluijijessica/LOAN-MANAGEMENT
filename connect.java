package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class  connect
{
	public static void main(String args[])
	{
		Connection con;
		Statement st;
		ResultSet rs;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_management?useTimezone=true&serverTimezone=UTC","root","");
		st=con.createStatement();
	    //System.out.println("Connection Found");

		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
