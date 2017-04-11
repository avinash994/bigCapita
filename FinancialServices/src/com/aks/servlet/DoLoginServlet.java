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
import javax.servlet.http.HttpSession;

import com.aks.model.UserAccount;
import com.aks.util.DBUtils;
import com.aks.util.MyUtils;

@WebServlet(urlPatterns = { "/doLogin" })
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = -6671896143379743097L;

	public DoLoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("hello");
		/*
		 * String rememberMeStr = request.getParameter("rememberMe"); boolean
		 * remember = "Y".equals(rememberMeStr);
		 */

		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;

		if (userName == null || password == null || userName.length() == 0
				|| password.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				System.out.println("C");
				user = DBUtils.findUser(conn, userName, password);
				System.out.println(user);
				if (user == null) {
					hasError = true;
					errorString = "User Name or password invalid";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		// If error, forward to /WEB-INF/views/login.jsp
		if (hasError) {
			user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher //
			= this.getServletContext().getRequestDispatcher(
					"/index2.jsp");

			dispatcher.forward(request, response);
		}

		// If no error
		// Store user information in Session
		// And redirect to userInfo page.
		/*
		 * else { HttpSession session = request.getSession();
		 * MyUtils.storeLoginedUser(session, user);
		 * 
		 * // If user checked "Remember me". if (remember) {
		 * MyUtils.storeUserCookie(response, user); }
		 * 
		 * // Else delete cookie. else { MyUtils.deleteUserCookie(response); }
		 */
		// Redirect to userInfo page.

		/*RequestDispatcher dispatcher //
		= this.getServletContext().getRequestDispatcher("/index.jsp");

		dispatcher.forward(request, response);*/
		// }
		else {
			
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, user);

			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		/*
		 * String rememberMeStr = request.getParameter("rememberMe"); boolean
		 * remember = "Y".equals(rememberMeStr);
		 */

		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;

		if (userName == null || password == null || userName.length() == 0
				|| password.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				user = DBUtils.findUser(conn, userName, password);
				System.out.println(user);
				if (user == null) {
					hasError = true;
					errorString = "User Name or password invalid";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		// If error, forward to /WEB-INF/views/login.jsp
		if (hasError) {
			user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher //
			= this.getServletContext().getRequestDispatcher(
					"/index2.jsp");

			dispatcher.forward(request, response);
		}

		// If no error
		// Store user information in Session
		// And redirect to userInfo page.
		/*
		 * else { HttpSession session = request.getSession();
		 * MyUtils.storeLoginedUser(session, user);
		 * 
		 * // If user checked "Remember me". if (remember) {
		 * MyUtils.storeUserCookie(response, user); }
		 * 
		 * // Else delete cookie. else { MyUtils.deleteUserCookie(response); }
		 */
		// Redirect to userInfo page.

		/*RequestDispatcher dispatcher //
		= this.getServletContext().getRequestDispatcher("/index.jsp");

		dispatcher.forward(request, response);*/
		// }
		else {
			
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, user);

			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}
	}

}