package com.hp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.Food;
import com.hp.service.FoodService;
import com.hp.service.impl.FoodServiceImpl;
import com.hp.util.PagerUtil;

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodService foodService=new FoodServiceImpl();
	public FoodServlet() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String opt = request.getParameter("opt");
		if(opt.equals("add")){
			this.addFood(request,response);
		}else if (opt.equals("findAll")) {
			this.findAll(request,response);
		}else if (opt.equals("find")) {
			this.find(request,response);
		}else if (opt.equals("updById")) {
			this.updById(request,response);
		}
	}
	//修改菜品信息
	private void updById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("foodId"));
		//System.out.println(id);
		String name =  request.getParameter("foodName");
		float vp=Float.parseFloat(request.getParameter("vipPrice"));
		float mp=Float.parseFloat(request.getParameter("marketPrice"));
		String desp = request.getParameter("foodDesp");
		String yl = request.getParameter("foodIng");
		this.foodService.updFood(new Food(id, name, vp, mp, desp, yl));
		this.findAll(request, response);
	}
	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Food>	di= this.foodService.findId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("di", di);
		request.getRequestDispatcher("menuDetail.jsp").forward(request, response);
	}
	//查询所有菜品信息
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Food> dist=this.foodService.findAll();
		request.setAttribute("dist", dist);
		
		int currentPage = 1;
		//3 判断界面提交过来的当前页码是否为空
		if (request.getParameter("currentPage") != null)//
		{
			// 不为空则界面中用户在请求的当前页
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		//4 最大页数
		int maxPage; 
		//5 创建业务逻辑层对象并调用方法查询返回list集合
		//////6、创建分页类对象
		PagerUtil pager = new PagerUtil();
		//////7、需要分页的文本 
		pager.setTopicSelect(dist);
	    //////8、设置每页显示行数 
		pager.setSizePerPage(4);
	    //////9、获取最大页数 
		maxPage = pager.getTotalPage();
	    //////10、根据当前页吗获取获取当前页内容
		pager.setCurrentPage(currentPage);
		//////11、request中存放的是分页对象
		request.getSession().setAttribute("pager", pager); 
		
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}
	//添加菜品
	protected void addFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodName=request.getParameter("foodName");
		String foodIng=request.getParameter("FoodIng");
		Float marketPrice=Float.parseFloat(request.getParameter("marketPrice")) ;
		Float vipPrice=Float.parseFloat(request.getParameter("vipPrice"));
		String foodDesp=request.getParameter("FoodDesp");
		int typeID=Integer.parseInt(request.getParameter("typeID")) ;
		String imageUrl=request.getParameter("ImageUrl");
		//System.out.println(imageUrl);
		foodService.addFood(new Food(foodName, vipPrice, marketPrice, typeID, foodDesp, imageUrl, foodIng));
		this.findAll(request, response);
	}
}
