package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.Cart;
import com.hp.entity.Food;
import com.hp.entity.Notice;
import com.hp.service.CartService;
import com.hp.service.NoticeService;
import com.hp.service.impl.CartServiceImpl;
import com.hp.service.impl.FoodServiceImpl;
import com.hp.service.impl.NoticeServiceImpl;
import com.hp.service.impl.OrderInfoServiceImpl;
import com.hp.util.PagerUtil;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService proService = new NoticeServiceImpl();
		ArrayList<Notice> noticeList = proService.findLastThree();
		List<Food> dis = new FoodServiceImpl().findAll();
		CartService cartService = new CartServiceImpl();

		Object i = request.getSession().getAttribute("userId");

		if (i != null) {
			ArrayList<Cart> cartList = cartService.showThree((int) i);
			request.setAttribute("cartList", cartList);
		}
		request.setAttribute("top5", new OrderInfoServiceImpl().getTopSellFoods(5));
		request.setAttribute("dis", dis);
		// 2 当前是第几页
		int currentPage = 1;
		// 3 判断界面提交过来的当前页码是否为空
		if (request.getParameter("currentPage") != null)//
		{
			// 不为空则界面中用户在请求的当前页
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// 4 最大页数
		int maxPage;
		////// 6、创建分页类对象
		PagerUtil pager = new PagerUtil();
		////// 7、需要分页的文本
		pager.setTopicSelect(dis);
		////// 8、设置每页显示行数
		pager.setSizePerPage(6);
		////// 9、获取最大页数
		maxPage = pager.getTotalPage();
		////// 10、根据当前页吗获取获取当前页内容
		pager.setCurrentPage(currentPage);
		////// 11、request中存放的是分页对象
		request.getSession().setAttribute("pager", pager);
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
