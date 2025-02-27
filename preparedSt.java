package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectApp5
 {
	 public static void main(String[] args) throws Exception
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.print("Enter number: ");
		 int no=sc.nextInt();
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		 String qry="select name,ad from student where no=?";
		 PreparedStatement ps=con.prepareStatement(qry);
		 ps.setInt(1,no);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			 System.out.print(rs.getString(1)+" "+rs.getString(2));
		 }
		 rs.close();
		 ps.close();
		 con.close();
		 
		
	 }
 }
