package com.hp.service;

import java.util.ArrayList;

import com.hp.entity.Cart;

public interface CartService {
	
	public int addCart(Cart cart);
	
	public int deleteCart(int cartId);
	
	public ArrayList<Cart> showAll(int id);

	public ArrayList<Cart> showThree(int id);
	
	public int deleteBy(int userId);
}
