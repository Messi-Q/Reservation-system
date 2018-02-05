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

@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCartServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService proService = new NoticeServiceImpl();
		List<Food> dis=new FoodServiceImpl().findAll();
		CartService cartService=new CartServiceImpl();
		
		ArrayList<Notice> noticeList = proService.findLastThree();
		String cartId=request.getParameter("cartId");
		int num=cartService.deleteCart(Integer.parseInt(cartId));
		Object i = request.getSession().getAttribute("userId");
		ArrayList<Cart> cartList=cartService.showThree((int)i);
		request.setAttribute("dis", dis);
		request.setAttribute("noticeList", noticeList);
		//request.setAttribute("num", num);
		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
