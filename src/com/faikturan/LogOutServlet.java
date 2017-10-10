package com.faikturan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		//Cookie ck = new Cookie("username", "");
		//ck.setMaxAge(0);
		HttpSession session = request.getSession();
		session.invalidate();
		out.println("Log out Successfull...");
		rd = request.getRequestDispatcher("/logout.html");
		rd.include(request, response);
	}

	
}
