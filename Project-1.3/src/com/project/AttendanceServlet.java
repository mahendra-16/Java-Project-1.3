package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://localhost:3306/world";
	
	
    public AttendanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String department = request.getParameter("department");
		String fullname = request.getParameter("fullname");
		
		Statement DataRequest;
		Connection Db;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Db = DriverManager.getConnection(url, "root", "mahendra@2016");
			
			PreparedStatement pst = Db.prepareStatement("insert into Attendance values(?,?)");
			
			pst.setString(1, department);
			pst.setString(2, fullname);
			
			int i = pst.executeUpdate();
			if(i > 0)
				pw.println("Attendance Updated Successfully");

		}catch (Exception e){
			
			System.out.println(e);
		}
		
		pw.close();
		    	
	}

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
