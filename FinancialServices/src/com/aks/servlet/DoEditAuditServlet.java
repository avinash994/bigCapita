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

import com.aks.model.UserAudit;
import com.aks.util.DBUtils;
import com.aks.util.MyUtils;

@WebServlet(urlPatterns = { "/DoEditAuditServlet" })
public class DoEditAuditServlet extends HttpServlet {
	private static final long serialVersionUID = -8107054904989105060L;


	public DoEditAuditServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String companyId = (String) request.getParameter("companyId");
		String companyName = (String) request.getParameter("companyName");
		String address = (String) request.getParameter("address");
		String budget = (String) request.getParameter("budget");
		String auditNature = (String) request.getParameter("auditNature");
		/*float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
		}*/
		UserAudit detail = new UserAudit(companyId, companyName, address,Integer.parseInt(budget),auditNature);

		String errorString = null;

		try {
			DBUtils.updateAudit(conn, detail);
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
					.getRequestDispatcher("/EditAudit.jsp");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			request.setAttribute("companyId", detail);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Auditdetails.jsp");
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}