package com.hp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.FoodType;
import com.hp.service.FoodTypeService;
import com.hp.service.impl.FoodTypeServiceImpl;

@WebServlet("/FoodTypeServlet")
public class FoodTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodTypeService foodTypeService = new FoodTypeServiceImpl();
	public FoodTypeServlet() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String opt = request.getParameter("opt");
		if(opt.equals("queryAll")){
			this.queryAll(request,response);
		}else if(opt.equals("add")){
			this.addFoodType(request,response);
		}else if(opt.equals("findId")){
			this.findId(request,response);
		}else if(opt.equals("updById")){
			this.updById(request,response);
		}else if(opt.equals("queryAlls")){
			this.queryAlls(request,response);
		}else if(opt.equals("del")){
			this.del(request,response);
		}
	}
	
	//删除类别
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.foodTypeService.del(Integer.parseInt(request.getParameter("id")));
		this.queryAll(request, response);
	}

	//根据编号修改
	private void updById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(Integer.parseInt(request.getParameter("typeId")));
		this.foodTypeService.updById(new FoodType(Integer.parseInt(request.getParameter("typeId")), request.getParameter("typeName")));
		this.queryAll(request, response);
	}

	//根据编号查询
	private void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(Integer.parseInt(request.getParameter("id")));
		List<FoodType> is =	this.foodTypeService.findId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("is", is);
		request.getRequestDispatcher("typeDetail.jsp").forward(request, response);
	}

	//添加类别
	private void addFoodType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		foodTypeService.addFoodType(new FoodType(request.getParameter("typeName")));
		this.queryAll(request, response);
	}
	//所有类别
	private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodType> fist = foodTypeService.queryAll();
		request.setAttribute("fist",fist);
		request.getRequestDispatcher("menutype.jsp").forward(request, response);
	}
	private void queryAlls(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodType> st = foodTypeService.queryAll();
		request.setAttribute("st",st);
		request.getRequestDispatcher("addmenu.jsp").forward(request, response);
	}
}
