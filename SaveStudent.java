package org.btm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveStudent extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	int id=Integer.parseInt(req.getParameter("id"));
    	String name=req.getParameter("nm");
    	int age=Integer.parseInt(req.getParameter("age"));
    	String password=req.getParameter("ps");
    	
    	Connection con=null;
    	PreparedStatement pst=null;
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/practise","root", "Python#2121");
    		pst=con.prepareStatement("insert into student values(?,?,?,?)");
    		pst.setInt(1,id);
    		pst.setString(2,name);
    		pst.setInt(3, age);
    		pst.setString(4, password);
    		int row=pst.executeUpdate();
    		PrintWriter pw=resp.getWriter();
    		pw.write("<html><body style='color:green;'><h1>"+row+" row inserted successfully</h1></body></html>");
    		
    	}
    	catch(ClassNotFoundException|SQLException e)
    	{
    		e.printStackTrace();
    	}
    	finally
    	{
    		try
    		{
    			if(con!=null)con.close();
    			if(pst!=null)pst.close();
    		}
    		catch(SQLException e)
    		{
    			System.out.println(e.getMessage());
    		}
    	}
    }
}
