package org.btm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="fas",urlPatterns = "/fas")
public class FetchAllStudent extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	
    	Connection con=null;
    	PreparedStatement pst=null;
    	ResultSet rs=null;
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/practise","root", "Python#2121");
    		pst=con.prepareStatement("select * from student ");

    		rs=pst.executeQuery();
    		PrintWriter pw=resp.getWriter();
    		pw.write("<html><body style='color:green;'>");
    		pw.write("<h1>Welcome !!!  Your details are shown below</h1>");
    		while(rs.next())
    		{	
    		pw.write("<h1>"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+"</h1></body></html>");
    		}
    		pw.write("<h1>End of List</h1>");
    		pw.write("</body></html>");
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
