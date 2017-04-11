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

import com.aks.model.UserAccount;
import com.aks.util.DBUtils;
import com.aks.util.MyUtils;

/**
 * Servlet implementation class DoSignupServlet
 */
@WebServlet("/DoSignupServlet")
public class DoSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 174641052322309666L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DoSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		String userName = (String) request.getParameter("userName");
		String companyName = (String) request.getParameter("companyName");
		String password = (String) request.getParameter("password");
		String phone = (String)request.getParameter("phone");
		UserAccount account = new UserAccount(userName,password,companyName,Long.parseLong(phone));

		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character

		if (userName == null) {
			errorString = "Invalid UserId";
			System.out.println("No user input");
		}

		if (errorString == null) {
			try {
				System.out.println(account.getCompanyName()+" "+account.getPassword()+" "+account.getPhone()+" "+account.getUserName());
				DBUtils.insertUser(conn, account);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
	

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}

		// If everything nice.
		// Redirect to the product listing page.
		else {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/index.jsp");
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
