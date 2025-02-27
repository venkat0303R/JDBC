package com.ihub.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp 
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
		
		//converting input values according to SQL query
		name="'"+name+"'";
		add="'"+add+"'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		Statement st=con.createStatement();
		
		String qry="insert into student values("+no+","+name+","+add+")";
		
		int result=st.executeUpdate(qry);
		
		if(result==0)
			System.out.println("No Record Inserted");
		else
			System.out.println(result+" Record Inserted");
		
		st.close();
		con.close();
	}
}
