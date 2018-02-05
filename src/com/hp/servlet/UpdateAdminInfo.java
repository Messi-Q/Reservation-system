package com.hp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.service.AdminService;
import com.hp.service.impl.AdminServiceImp;

/**
 * Servlet implementation class UpdateAdminInfo
 */
@WebServlet("/UpdateAdminInfo")
public class UpdateAdminInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService as=new AdminServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				String adminName=request.getParameter("adminName");
				String adminPwd=request.getParameter("pwd");
				String adminId=request.getParameter("adminId");
				String sql="update admininfo set adminName=? , adminPwd=? where adminId=?";
				int rs=as.updateUser(sql, adminName, adminPwd,adminId);
				if (rs>0) {
					request.getRequestDispatcher("success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("updateFalse.jsp").forward(request, response);
				}
			}
	}
