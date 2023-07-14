package com.flyaway;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

@WebServlet("/passengerdetails")
public class PassengerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();
    	out.println("<html><text>");
    	
    	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");
    	String mobile = request.getParameter("mobileNum");
    	int mobNum = Integer.parseInt(mobile);
    	String gender = request.getParameter("userGender");
    	String flightNumber = request.getParameter("flightNumber");
    	
    	InputStream in = getServletContext().getResourceAsStream("WEB-INF/config.properties");
    	Properties props = new Properties();
		props.load(in);
		String url = props.getProperty("url");
		String userid = props.getProperty("userid");
		String password = props.getProperty("password");
		FlyawayDBcon flyawaydbcon = null;
		
		try {
			flyawaydbcon = new FlyawayDBcon(url, userid, password);
			Connection connection = flyawaydbcon.getConnection();
			Statement stmt = connection.createStatement();
			int updatePassengers = stmt.executeUpdate("INSERT INTO passengers (First_Name, Last_Name, gender, FlightNumber, contact_number) VALUES ('"+firstName+"', '"+lastName+"', '"+mobNum+"', '"+gender+"', '"+flightNumber+"')");
			out.println("<a href=\"passengerdetails.jsp?flight_number=" + flightNumber + "\">Click here to add another passenger</a>");
			out.println("click here to procede to payment page");
			
		}catch(Exception e) {
			out.println(e);
		}
		
    	
	}


}
