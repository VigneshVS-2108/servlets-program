package org.btm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ds",urlPatterns = "/ds")
public class DeleteServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	int id=Integer.parseInt(req.getParameter("id"));
    	
    	Connection con=null;
    	PreparedStatement pst=null;
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/practise","root", "Python#2121");
    		pst=con.prepareStatement("delete from student where id=?");
    		pst.setInt(1,id);

    		int row=pst.executeUpdate();
    		PrintWriter pw=resp.getWriter();
    		pw.write("<html><body style='color:green;'><h1>"+row+" row deleted successfully</h1></body></html>");
    		
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
