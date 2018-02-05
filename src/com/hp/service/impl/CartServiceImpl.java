package com.hp.service.impl;

import java.util.ArrayList;

import com.hp.dao.CartDao;
import com.hp.dao.impl.CartDaoImpl;
import com.hp.entity.Cart;
import com.hp.service.CartService;

public class CartServiceImpl implements CartService {
	
	CartDao cartDao=new CartDaoImpl();
	@Override
	public ArrayList<Cart> showAll(int id) {
		
		return cartDao.showAll(id);
	}
	@Override
	public int deleteCart(int cartId) {
		
		return cartDao.deleteCart(cartId);
	}
	@Override
	public int addCart(Cart cart) {
		
		return cartDao.addCart(cart);
	}
	@Override
	public ArrayList<Cart> showThree(int id) {
		
		return cartDao.showThree(id);
	}

	
	public int deleteBy(int userId){
		return cartDao.deleteByUserId(userId);
	}
}
