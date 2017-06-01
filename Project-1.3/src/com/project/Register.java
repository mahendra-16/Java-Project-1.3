package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/world";
	   

	public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter pw = response.getWriter();
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String department = request.getParameter("department");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
				
		Statement DataRequest;
		Connection Db;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Db = DriverManager.getConnection(url, "root", "mahendra@2017");
			
			PreparedStatement ps = Db.prepareStatement("insert into newjoinee values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, department);
			ps.setString(2, firstname);
			ps.setString(3, lastname);			
			ps.setString(4, gender);
			ps.setString(5, city);
			ps.setString(6, qualification);
			ps.setString(7, email);
			ps.setString(8, password);
			
			int i = ps.executeUpdate();
			if(i > 0)
				pw.println("Registered Successfully");

		}catch (Exception e){
			
			System.out.println(e);
		}
		
		pw.close();
		
	}

}
