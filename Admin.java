package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Admin {
	
 public void login() {
	 
	 String id,password,login_status="";
	 Connection con;
	 Statement st;
	 ResultSet rs;
	 Scanner a=new Scanner(System.in);
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_management?useTimezone=true&serverTimezone=UTC","root","");
		st=con.createStatement();
	   // System.out.println("Connection Found");
		System.out.println("enter Admin ID:");
		id=a.nextLine();
		System.out.println("enter password:");
        password=a.nextLine();
        
        // we're verifying if admin exists 
        rs=st.executeQuery("select * from admin");

		while(rs.next())
		{
			
			 String id1=rs.getString("admin_id");
			 String password1=rs.getString("password");
		if(id.equals(id1) && password.equals(password1)) {
			
		
			login_status="true";
			break;
		   }
		}
		if(login_status.equals("true")) {
			System.out.println("\n*********Login Successfull**********\n");
			Dashbord n=new Dashbord();
			n.start();
		}
		else {
			System.out.println("\n*********Incorrect password/Admin ID**********\n");
			login();
		}
       
        
    }
		catch(Exception e)
		{
		//System.out.println("Connection Error, Please Check");

		e.printStackTrace();
		}
 }
	
	public static void main(String[] args) {
		
		Admin show=new Admin();
		show.login();
		
	}

}
