package com.hp.dao;

import java.util.ArrayList;

import com.hp.entity.Cart;

public interface CartDao {
	
	public int addCart(Cart cart);
	
	public int deleteCart(int cartId);
	
	public int deleteByUserId(int userId);
	
	public ArrayList<Cart> showAll(int id);
	
	public ArrayList<Cart> showThree(int id);

}
