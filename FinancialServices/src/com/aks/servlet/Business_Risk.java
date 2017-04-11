package com.aks.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aks.model.UserAccounting;
import com.aks.model.UserBusinessRisk;
import com.aks.util.DBUtils;
import com.aks.util.MyUtils;

@WebServlet("/BusinessServlet")
public class Business_Risk extends HttpServlet{

	private static final long serialVersionUID = -2434448986770276577L;

	public Business_Risk() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		String companyId = (String) request.getParameter("userId");
		String companyName = (String) request.getParameter("companyName");
		String advisoryType = (String) request.getParameter("advisoryType");
		String budget = (String)request.getParameter("budget");
		String timePeriod = (String)request.getParameter("timePeriod");
		String productLine = (String)request.getParameter("productLine");
		UserBusinessRisk details = new UserBusinessRisk(companyId,companyName,advisoryType,Integer.parseInt(budget),Integer.parseInt(timePeriod),productLine);

		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character

		/*if (userName == null) {
			errorString = "Invalid UserId";
			System.out.println("No user input");
		}*/

		if (errorString == null) {
			try {
				System.out.println(details.getCompanyId()+" "+details.getCompanyName()+" "+details.getAdvisoryType()+" "+details.getBudget()+" "+details.getTimePeriod()+" "+details.getProductLine());
				DBUtils.insertBusinessRiskDetails(conn, details);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
	

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Business_risk.jsp");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			request.setAttribute("companyId", details);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Business_risk_details.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
