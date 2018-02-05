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

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddCartServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NoticeService proService = new NoticeServiceImpl();
		ArrayList<Notice> noticeList = proService.findLastThree();
		List<Food> dis=new FoodServiceImpl().findAll();
		CartService cartService=new CartServiceImpl();
		String foodId=request.getParameter("foodid");
		int userId=(int) request.getSession().getAttribute("userId");
		String orderNum=request.getParameter("ordernum");
		Cart cart =new Cart(Integer.parseInt(orderNum), userId, Integer.parseInt(foodId));
		int addNum=cartService.addCart(cart);
			ArrayList<Cart> cartList=cartService.showThree(userId);
			request.setAttribute("cartList", cartList);
		request.setAttribute("addNum", addNum);
		request.setAttribute("dis", dis);
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/indexs.jsp").forward(request, response);
	}
}
