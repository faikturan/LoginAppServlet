package com.faikturan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd=null;
		
		//Cookie ck[] =request.getCookies();
		
		//if li kýsým cookie ile. 
		/*
		 * //if (ck != null && !Arrays.asList(ck).isEmpty() && Arrays.asList(ck).stream()
			//	.filter(c->c.getName().equals("username")).findFirst().isPresent())
		 */
		
		HttpSession session = request.getSession();
		
		if(session != null && session.getAttribute("username")!= null)
		{
			out.print("Welcome to profile....");
			rd = request.getRequestDispatcher("/profile.html");
			rd.include(request, response);
		}else{
			out.print("Please login first....");
			rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
	}

	

}
