package com.hp.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.FoodCount;
import com.hp.entity.OrderInfo;
import com.hp.service.OrderInfoService;
import com.hp.service.impl.CartServiceImpl;
import com.hp.service.impl.OrderInfoServiceImpl;
import com.hp.util.PagerUtil;
import com.hp.util.StringUtil;

/**
 * Servlet implementation class OrderInfoServlet
 */
@WebServlet({ "/queryOrder", "/totalSell", "/confirmOrder", "/sellList", "/addOrder", "/cancelAll" })
public class OrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//订单服务
	private OrderInfoService orderService = new OrderInfoServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sPath = request.getServletPath();
		if (sPath.equals("/queryOrder")) {
			queryOrder(request, response);
		} else if (sPath.equals("/totalSell")) {
			getTopSell(request, response);
		} else if (sPath.equals("/sellList")) {
			getSellList(request, response);
		} else if (sPath.equals("/confirmOrder")) {
			confirmOrder(request, response);
		} else if (sPath.equals("/addOrder")) {
			addOrder(request, response);
		} else if (sPath.equals("/cancelAll")) { 
			cancelAll(request, response);
		}
	}

	// cancel all from cart table
	private void cancelAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId != null) {
			new CartServiceImpl().deleteBy(userId);
		}
		response.sendRedirect("/apsfc/IndexServlet");
	}

	// 购物车订单提交
	private void addOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userid = (Integer) request.getSession().getAttribute("userId");
		if (userid != null) {
			orderService.addOrders(userid);
		}
		response.sendRedirect("/apsfc/IndexServlet");
	}

	// 订单按条件查询
	public void queryOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String foodName = request.getParameter("foodName");
		String orderTime = request.getParameter("orderTime");
		List<OrderInfo> orderList = null;
		if (userId != null) {
			orderList = orderService.findOrderDetailsByUserId(StringUtil.parse(userId));
		}
		if (StringUtil.notNullValue(foodName)) {
			orderList = orderService.findOrderDetaisByFoodName(foodName);
		}
		if (StringUtil.notNullValue(orderTime)) {
			orderList = orderService.findOrderDetailsByOrderTime(orderTime);
		}
		request.setAttribute("queryResult", orderList);
		request.getRequestDispatcher("queryOrder.jsp").forward(request, response);
	}

	// 销售排行榜
	public void getTopSell(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List<FoodCount> foods = orderService.getDaylyCount(sdf.format(new Date()));
		request.setAttribute("totalSell", foods);
		request.setAttribute("countAll", orderService.getCountAll(foods));
		request.getRequestDispatcher("totalSell.jsp").forward(request, response);
	}

	// 确认某条订单
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = StringUtil.parse(request.getParameter("orderId"));
		if (orderId != -1) {
			orderService.confirmOrder(orderId);
		}
		request.getRequestDispatcher("/sellList").forward(request, response);
	}

	// 销售列表
	public void getSellList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("sellList", orderService.findOrderDeltailsAll());

		// 分页处理
		int currentPage = 1;
		if (request.getParameter("currentPage") != null)//
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int maxPage;
		PagerUtil pager = new PagerUtil();
		pager.setTopicSelect(orderService.findOrderDeltailsAll());
		pager.setSizePerPage(6);
		maxPage = pager.getTotalPage();
		pager.setCurrentPage(currentPage);
		// 将分页内容放入session中
		request.getSession().setAttribute("pager", pager);

		request.getRequestDispatcher("sellList.jsp").forward(request, response);
	}

	// 查询销量最高的菜品
	public void getFoodRank(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("topN", orderService.getTopSellFoods(5)); // top5
	}
}
