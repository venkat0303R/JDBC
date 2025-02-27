package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PSInsertApp 
{
	public static void main(String[] args)throws Exception  
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student no :");
		int no=sc.nextInt();
		
		System.out.println("Enter the student name :");
		String name=sc.next();
		
		System.out.println("Enter the student address :");
		String add=sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		
		String qry="insert into student values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(qry);
		
		//set the values
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setString(3, add);
		
		//execute 
		int result=ps.executeUpdate();
		
		if(result==0)
			System.out.println("No Record Inserted");
		else
			System.out.println("Record Inserted");
		
		ps.close();
		con.close();
		
	}
}
