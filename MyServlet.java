package org.btm;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet
{
	
	public MyServlet()
	{
		System.out.println("MyServlet object created");
	}
    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("MyServlet resources are initialized");
    	
    }
    
    @Override
    public void destroy() {
    	System.out.println("MyServlet object destroyed");
    	
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	System.out.println("Hello from Servlet interface...");
    	
    }
    @Override
    public String getServletInfo() {
    	// TODO Auto-generated method stub
    	return null;
    }
    
    @Override
    public ServletConfig getServletConfig() {
    	// TODO Auto-generated method stub
    	return null;
    }
}
