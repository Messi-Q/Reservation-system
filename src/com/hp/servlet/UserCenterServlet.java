package com.hp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.hp.entity.UserInfo;
import com.hp.service.UserService;
import com.hp.service.impl.UserServiceImpl;

@WebServlet("/UserCenterServlet")
public class UserCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserCenterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");

		String userid = request.getParameter("UserId");
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		String newpwd = request.getParameter("newuserpwd");
		// 封装：将用户输入的值封装成一个实体类对象
//		UserInfo userinfo = new UserInfo(Integer.parseInt(userid), name, pwd);
		// 调用业务层
		UserService userservice = new UserServiceImpl();
		UserInfo i = userservice.userLogin(new UserInfo(name, pwd));

		if (i != null) {
			int t = userservice.userUpdate(new UserInfo(Integer.parseInt(userid),name, newpwd));
			if (t > 0) {
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
		}
	}
}
