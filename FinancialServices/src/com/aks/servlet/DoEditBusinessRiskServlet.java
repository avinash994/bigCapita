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

import com.aks.model.UserBusinessRisk;
import com.aks.util.DBUtils;
import com.aks.util.MyUtils;

@WebServlet(urlPatterns = { "/DoEditBusinessRiskServlet" })
public class DoEditBusinessRiskServlet extends HttpServlet {

	private static final long serialVersionUID = 2855259874013538038L;


	public DoEditBusinessRiskServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String companyId = (String) request.getParameter("companyId");
		String companyName = (String) request.getParameter("companyName");
		String advisoryType = (String) request.getParameter("advisoryType");
		String budget = (String) request.getParameter("budget");
		String timePeriod = (String) request.getParameter("timePeriod");
		String productLine = (String) request.getParameter("productLine");
		/*float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
		}*/
		UserBusinessRisk detail = new UserBusinessRisk(companyId, companyName,advisoryType ,Integer.parseInt(budget),Integer.parseInt(timePeriod),productLine);

		String errorString = null;

		try {
			DBUtils.updateBusinessRisk(conn, detail);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("detail", detail);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/EditBusinessRisk.jsp");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			request.setAttribute("companyId", detail);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Business_risk_details.jsp");
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}