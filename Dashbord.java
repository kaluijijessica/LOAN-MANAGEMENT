package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Dashbord {
	public static int rate,time;
	Statement st;
	ResultSet rs;
	Connection con;
	Scanner a=new Scanner(System.in);
	
	

public void start() {
	
	System.out.println("\n 1.customer related details");
	System.out.println("\n 2.Loan type");
	//System.out.println("\n 3.Monthly payment plan");

	System.out.println("\n 3.Logout");
	System.out.println("\n Enter your choice: ");
	int choice=a.nextInt();
	if(choice==1) {
		Dashbord n=new Dashbord();
		n.customer_menu();
	}
	else if(choice==2) {
		Dashbord n=new Dashbord();
		n.loan();
	}
	else if(choice==3) {
		Admin n=new Admin();
		n.login();
	}
	else  {
		System.out.println("\n MAKE CORRECT CHOOICE ");
		start();
	}
	
}

public void customer_menu() {
	
	System.out.println("\n 1.new customer");
	System.out.println("\n 2.current customers details");
	System.out.println("\n 3.back");
	System.out.println("\n Enter your choice: ");
	int choice=a.nextInt();
	if(choice==1) {
		Dashbord n=new Dashbord();
		n.customer();
	}
	else if(choice==2) {
		Dashbord n=new Dashbord();
		n.customer_details();
	}
	
	else if(choice==3) {
		Dashbord n=new Dashbord();
		n.start();
	}
	else {
		System.out.println(" `````incorrect choice````````");
		customer_menu();
	}
}

	
	public String  loan_type() {
		int choice;
		String name="";
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_management?useTimezone=true&serverTimezone=UTC","root","");
		st=con.createStatement();
	
		 rs=st.executeQuery("select * from loan_type");

			while(rs.next())
			{
				
				 String id=rs.getString("no");
				 String Lname=rs.getString("loan_type_name");
				 String range=rs.getString("amount_interval");
				 String interest=rs.getString("interest_rate");
				 String period=rs.getString("period");
				 
				 System.out.println("\n"+id+".\t"+Lname+"\t"+range+"\t"+interest+"%"+"\t"+period);
			   }
			choice=a.nextInt();
			
				 rs=st.executeQuery("select * from loan_type where no="+choice);

					while(rs.next()) {
					
						 name=rs.getString("loan_type_name");
						 Dashbord.rate=Integer.parseInt(rs.getString("interest_rate"));
						 Dashbord.time=Integer.parseInt(rs.getString("period"));
					}
					
		}		
		catch(Exception e)
		{
		//System.out.println("Connection Error, Please Check");

		e.printStackTrace();
		}
		//new customer
		return name;
	}
	
	public void  loan() {
	
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_management?useTimezone=true&serverTimezone=UTC","root","");
		st=con.createStatement();
	
		 rs=st.executeQuery("select * from loan_type");

			while(rs.next())
			{
				
				 String id=rs.getString("no");
				 String Lname=rs.getString("loan_type_name");
				 String range=rs.getString("amount_interval");
				 String interest=rs.getString("interest_rate");
				 String period=rs.getString("period");
				 
				 System.out.println("\n"+id+".\t"+Lname+"\t"+range+"\t"+interest+"%"+"\t"+period);
			   }
			Dashbord n=new Dashbord();
			n.start();
		}		
		catch(Exception e)
		{
		//System.out.println("Connection Error, Please Check");

		e.printStackTrace();
		}
		//new customer
		
	}
		
	
	public void  customer_details() {
		try
		{
			
			
			
			
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_management?useTimezone=true&serverTimezone=UTC","root","");
		st=con.createStatement();
	
		 rs=st.executeQuery("select * from customers");
		 System.out.println("\n ID \t  NAME   \t LOAN_TYPE   \t PRINCIPAL  \t  EMI");
			while(rs.next())
			{
				
				 String id=rs.getString("cid");
				 String name=rs.getString("name");
				 String type=rs.getString("loan_type");
				 String amount=rs.getString("amount");
				 String bank=rs.getString("bank_account");
				 String emi=rs.getString("EMI");
				 
				 System.out.println("\n"+id+".\t"+name+"\t"+type+"\t"+amount+"\t"+"\t"+emi);
				
			   }
			
			Dashbord n=new Dashbord();
			n.customer_menu();
		}		
		catch(Exception e)
		{
		//System.out.println("Connection Error, Please Check");

		e.printStackTrace();
		}
		
	}
	
	
		public void  customer() {
			
			
			String name,loan_type;
			int amount,bank;
			double EMI;
			 float sinterest;
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_management?useTimezone=true&serverTimezone=UTC","root","");
			st=con.createStatement();
		System.out.println("what's your name:");
		name=a.nextLine();
		System.out.println("choose loan type: ");
		
		Dashbord abc=new Dashbord();
		
		loan_type=abc.loan_type();
		
		System.out.println("enter amount ");
		amount=a.nextInt();
		
		// method to check amount entered
		
		sinterest=(rate*time*amount)/100;
		
		amount=amount+(int)sinterest;
		EMI=emi(rate,time,amount);
		
		 System.out.print("Simple Interest is: " +sinterest+"\n");
		 System.out.print("EMI is: " +EMI+"\n");
		System.out.println("enter your bank account No: ");
		bank=a.nextInt();
		
		// customer table
		String query="insert into customers(name,loan_type,amount,bank_account,EMI) values('"+name+"','"+loan_type+"','"+amount+"','"+bank+"','"+EMI+"')";
		
		st=con.createStatement();
		st.execute(query);
		System.out.println("A customer has been granted a loan");
		
    String query1="insert into loan(customer_name,loan_type_name,amount) values('"+name+"','"+loan_type+"','"+amount+"')";
		
		st=con.createStatement();
		st.execute(query1);
	//we're displaying loan types
		Dashbord n=new Dashbord();
		n.customer_menu();
		
			}		
		catch(Exception e)
		{
		//System.out.println("Connection Error, Please Check");

		e.printStackTrace();
		}
		
	}
	
		public double emi(int r1,int t1,int p1) {
			               
		      
			Double r= new Double(r1);
		        r=r/(12*100); 
		        Double t= new Double(t1);
		        t=t*12; 
		        Double p= new Double(p1);
		        double emi= (Double)(p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
		      
		        return emi;
		                 
		    }
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Dashbord display=new Dashbord();
display.customer();
	}

}
