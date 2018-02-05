package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.Cart;
import com.hp.service.CartService;
import com.hp.service.impl.CartServiceImpl;

@WebServlet("/DeleteAllCartInfoServlet")
public class DeleteAllCartInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteAllCartInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartService cartService=new CartServiceImpl();
		String[] str=request.getParameterValues("id");
		for(int i=0;i<str.length;i++) {
			
			int num=cartService.deleteCart(Integer.parseInt(str[i]));
		}
		Object i = request.getSession().getAttribute("userId");
		ArrayList<Cart> cartList=cartService.showAll((int)i);
		//request.setAttribute("num", num);
		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
