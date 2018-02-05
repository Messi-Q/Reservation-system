package com.hp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.UserInfo;
import com.hp.service.UserService;
import com.hp.service.impl.UserServiceImpl;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//编码
		request.setCharacterEncoding("UTF-8");
		//获取参数的值
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		
		UserService userservice = new UserServiceImpl();
		UserInfo i = userservice.userLogin(new UserInfo(name,pwd));
		if (i != null) {
			request.getSession().setAttribute("userId", i.getUserId());
			request.getSession().setAttribute("name", name);
			request.getRequestDispatcher("IndexServlet").forward(request, response);
		} else {
			request.setAttribute("error", "用户名或密码错误!");
			request.getRequestDispatcher("userlogin.jsp").forward(request, response);
		}
	}

}
