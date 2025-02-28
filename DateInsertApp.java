package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertApp
 {
	 public static void main(String[] args) throws Exception
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.print("Enter number: ");
		 int no=sc.nextInt();
		 System.out.print("Enter name: ");
		 String name=sc.next();
		 System.out.print("Enter Date of joining(dd-mm-yyyy) : ");
		 String time=sc.next();
		 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy");
		 java.util.Date ud=sdf.parse(time);
		 long ms=ud.getTime();
		 java.sql.Date sd=new java.sql.Date(ms);
		 
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		 String qry="insert into employee_info values(?,?,?)";
		 PreparedStatement ps=con.prepareStatement(qry);
		 ps.setInt(1,no);
		 ps.setString(2, name);
		 ps.setDate(3, sd);
		 int result=ps.executeUpdate();
		 if(result==0) {
			 System.out.print("No inserted");
		 }
		 else {
			 System.out.print("Inserted");
		 }
		 ps.close();
		 con.close();
		 
		
	 }
 }
