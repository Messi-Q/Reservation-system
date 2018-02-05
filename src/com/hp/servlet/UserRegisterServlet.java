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

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("reg");
//		System.out.println(1111);
		// 编码
		request.setCharacterEncoding("UTF-8");
		// 获取参数的值
		String name = request.getParameter("UserName");
		String pwd = request.getParameter("UserPwd");
		String realname = request.getParameter("RealName");
		String sex = request.getParameter("Sex");
		String age = request.getParameter("Age");
		String cardid = request.getParameter("CardId");
		String address = request.getParameter("UserAddress");
		String tel = request.getParameter("UserTel");
		String email = request.getParameter("Email");
		String ems = request.getParameter("Ems");
		// 封装：将用户输入的值封装成一个实体类对象
		UserInfo userinfo = new UserInfo(name, pwd, realname, sex, Integer.parseInt(age), cardid, address, tel, email,
				ems);
		// 调用业务层
		UserService userservice = new UserServiceImpl();

		boolean flg = userservice.userExist(userinfo.getUserName());

		if (flg) {
			request.setAttribute("error", "用户名已存在!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			int i = userservice.userRegister(userinfo);
			if (i > 0) {
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
		}

	}

}
