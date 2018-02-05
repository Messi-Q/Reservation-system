package com.hp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuitServlet")
public class QuitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuitServlet() {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ok");
		request.getSession().invalidate();
		request.getRequestDispatcher("userlogin.jsp").forward(request, response);
	}

}
