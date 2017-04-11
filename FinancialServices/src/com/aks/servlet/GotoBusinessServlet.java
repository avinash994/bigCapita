package com.aks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aks.model.UserAccount;
import com.aks.util.MyUtils;

@WebServlet(urlPatterns = { "/GotoBusinessServlet" })
public class GotoBusinessServlet extends HttpServlet {

	private static final long serialVersionUID = -3770390488888181540L;

	public GotoBusinessServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		// Check User has logged on
		UserAccount loginedUser = MyUtils.getLoginedUser(session);

		// Not logged in
		if (loginedUser == null) {

			// Redirect to login page.
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Business_Risk2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		else{
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/Business_Risk.jsp");
		dispatcher.forward(request, response);
		}

	}

	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}