package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReportGenerationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String url = "jdbc:mysql://localhost:3306/world";
    private String userID = "root";
    private String password = "mahendra@2017";
	
	public ReportGenerationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
				
		PrintWriter pw = response.getWriter();
		
		String reportgeneration = request.getParameter("report"); 
		
		Statement DataRequest;
		Connection Db;
		
		pw.println("<html><table border='1' cellspacing='1'><tr><th>" + "Department" + "</th><th>" + "First Name" + "</th><th>" +
		 "Last Name" + "</th><th>" + "Sex" + "</th><th>" + "City" + "</th><th>" + "Qualification" + "</th><th>" + 
		 "Email" + "</th><th>" + "Password" + "</th></tr>");
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Db = DriverManager.getConnection(url, userID, password);
			
			DataRequest = Db.createStatement();
			ResultSet rs = null;
			
			if(reportgeneration.equals("Registration"))
				rs = DataRequest.executeQuery("select * from newjoinee");
			
				
			
			while(rs.next()){
				String department = rs.getString(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String sex = rs.getString(4);
				String city = rs.getString(5);
				String qualification = rs.getString(6);
				String email = rs.getString(7);
				String password = rs.getString(8);
				

				pw.println("<tr><td>" + department + "</td><td>" + firstname + "</td><td>" + lastname + "</td><td>" 
				+ sex + "</td><td>" + city + "</td><td>" + qualification + "</td><td>" + email + "</td><td>" + password + "</td></tr>");
			
			}
			
			pw.println("<table><html>");
			Db.close();
			rs.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}
	
}
