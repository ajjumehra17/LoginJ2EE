package dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
	private static  Connection conn = null;	
	public static  Connection getConnection() {
		System.out.println("Get Connetion  ......");
		try {
			System.out.println("try getConn........");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Load...........");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("Connection Success.........");		
			
		} 
		catch (Exception e) {
		  e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		Connection conn =  DBConnection.getConnection();
		System.out.println("Main.........."+conn);
	}

}
//LoginServlet