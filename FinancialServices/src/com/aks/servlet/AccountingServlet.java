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
import com.aks.util.DBUtils;
import com.aks.util.MyUtils;

@WebServlet("/AccountingServlet")
public class AccountingServlet extends HttpServlet{
	
	private static final long serialVersionUID = -4687882091296197576L;

	public AccountingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		String companyId = (String) request.getParameter("userId");
		String companyName = (String) request.getParameter("companyName");
		String noOfAccountant = (String) request.getParameter("noOfAccountant");
		String department = (String)request.getParameter("department");
		String qualification = (String)request.getParameter("qualification");
		String workExperience = (String)request.getParameter("workExperience");
		UserAccounting Accountingdetails = new UserAccounting(companyId,companyName,Integer.parseInt(noOfAccountant),department,qualification,workExperience);

		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character

		/*if (userName == null) {
			errorString = "Invalid UserId";
			System.out.println("No user input");
		}*/

		if (errorString == null) {
			try {
				System.out.println(Accountingdetails.getCompanyId()+" "+Accountingdetails.getCompanyName()+" "+Accountingdetails.getNoOfAccountant()+" "+Accountingdetails.getDepartment()+" "+Accountingdetails.getQualification()+" "+Accountingdetails.getWorkExperience());
				DBUtils.insertAccountingDetails(conn, Accountingdetails);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
	

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Accounting_Apply.jsp");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			request.setAttribute("companyId", Accountingdetails);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Accounting_details.jsp");
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
