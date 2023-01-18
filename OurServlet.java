package org.btm;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OurServlet extends GenericServlet
{
	public OurServlet()
	{
		System.out.println("OurServlet object has been created");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("resources are initialised...");
	}
	
	@Override
	public void destroy() {
		System.out.println("OurServlet object has been destroyed");
	}
	
     @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("Hello from generic servlet");
    }
}
