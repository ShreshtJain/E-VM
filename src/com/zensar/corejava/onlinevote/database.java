package com.zensar.corejava.onlinevote;

import java.sql.*;
import java.util.Random;

import javax.swing.JOptionPane;  
class database
{  
	String to;
	int num1,numt;
public  void connect (String to,int num1){  
	this.to=to;
	this.num1=num1;
try{  
	Connection con;
	 Statement st1,st2 ;
	 ResultSet rs1;   
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userName = "hr"; 
	String password = "hr";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection(url,userName,password);  
	st1=con.createStatement();

rs1=st1.executeQuery("select voter_count from voters_result where party_name like'"+to+"'");
	rs1.next();
	numt=(rs1.getInt(1));
	num1=num1+numt;
	st2=con.createStatement();
	st2.executeUpdate("update voters_result set voter_count="+num1+" where party_name like'"+to+"'");
	st1.close();
st2.close();
//step5 close the connection object  

  
}catch(Exception e){ System.out.println(e);} 

}
}
class login_page
{
	String str;
	public  void connect (String str){  
		try{  
			this.str=str;
			Connection con;
			 Statement st1;
			 ResultSet rs1;   
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "hr"; 
			String password = "hr";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,userName,password);                
		     st1=con.createStatement();
			if(st1.executeUpdate("select temp from voter where temp like '"+str+"'")==1)
			 {
				 Otp_verification_page ovg =new Otp_verification_page();
				
			 }	 else
			 {
				 JOptionPane.showMessageDialog(null,"Id not found");
				 Login_pages lk=new Login_pages(); 
			 }
		  
					st1.close();
		 
		}
		  
		catch(Exception e){ System.out.println(e);} 
	
}
}
class Otp_verification1
{
	public  void connect (String no){  
		try{  
			Connection con;
			 Statement st1;
			 ResultSet rs1; 
			 String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String userName = "hr"; 
				String password = "hr";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url,userName,password);  
				st1=con.createStatement();
				 if(st1.executeUpdate("select mobile_no from Voter where  mobile_no like'"+no+"'")==1)
				 {
					 Otp_generator og =new Otp_generator();
						og.sendSms(no);
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,"this Mobile no is not registered");
				 }
				}
			   
		
		//step5 close the connection object  

		  
		catch(Exception e){ System.out.println(e);} 

	}
}
class Registration_page1
{
	String name ;
	String aadhar_no1 = null;
	int temp = 0;
	String mobile_no = null;
	public void connect(String name,String aadhar_no1,String mobile_no,int temp)
	{
		try
		{
			this.name=name; 
			this.aadhar_no1 = aadhar_no1;
			this.temp= temp;
			this.mobile_no = mobile_no;
			Random rando=new Random();
			int temp1=rando.nextInt(999999999);
		Connection con;
		Statement t1,t2;  
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "hr";
		String password = "hr";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url,userName,password);  
		t1=con.createStatement();
		t2=con.createStatement();
		if(t2.executeUpdate("select aadhar_no from Voter where  aadhar_no like'"+aadhar_no1+"'")==1)
		{
			JOptionPane.showMessageDialog(null,"you are already registered");
		}
		else
		{
		t1.executeUpdate("insert into voter values('"+name+"','"+aadhar_no1+"','"+mobile_no+"',"+temp1+")");
		JOptionPane.showMessageDialog(null,"your voter_id is"+temp1+"\n\nRemember It and Do not Share");

		}
	}
		catch(Exception e){ System.out.println(e);} 
	
}
}
class admin_login1
{
	public void connect() 
	{
		try
		{
		Connection con;
		Statement st1;
	    ResultSet rs1;    
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "hr";
		String password = "hr";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url,userName,password);  
		st1=con.createStatement();
		 rs1=st1.executeQuery("select party_name,voter_count  from Voters_result order by voter_count Desc "); 
		 rs1.next();
		 JOptionPane.showMessageDialog(null,rs1.getString(1)+"\n"+rs1.getInt(2));
	    }
		catch(Exception e){ System.out.println(e);} 
}
}
