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
import com.aks.model.UserAudit;
import com.aks.util.DBUtils;
import com.aks.util.MyUtils;

@WebServlet(urlPatterns = { "/DoEditAccountingServlet" })
public class DoEditAccountingServlet extends HttpServlet {
	private static final long serialVersionUID = -8107054904989105060L;


	public DoEditAccountingServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String companyId = (String) request.getParameter("companyId");
		String companyName = (String) request.getParameter("companyName");
		String noOFAccountant = (String) request.getParameter("noOFAccountant");
		String department = (String) request.getParameter("department");
		String qualification = (String) request.getParameter("qualification");
		String workExperience = (String) request.getParameter("workExperience");
		/*float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
		}*/
		UserAccounting detail = new UserAccounting(companyId, companyName,Integer.parseInt(noOFAccountant),department,qualification,workExperience);

		String errorString = null;

		try {
			DBUtils.updateAccounting(conn, detail);
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
					.getRequestDispatcher("/EditAccounting.jsp");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Accounting_details.jsp");
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}