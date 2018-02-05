package com.hp.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.dao.CartDao;
import com.hp.dao.OrderInfoDao;
import com.hp.dao.impl.CartDaoImpl;
import com.hp.dao.impl.OrderInfoDaoImpl;
import com.hp.entity.Cart;
import com.hp.entity.FoodCount;
import com.hp.entity.OrderInfo;
import com.hp.service.OrderInfoService;
import com.hp.util.DBUtil;

public class OrderInfoServiceImpl implements OrderInfoService {

	private OrderInfoDao orderDao = new OrderInfoDaoImpl();

	private CartDao cartDao = new CartDaoImpl();

	@Override
	public List<OrderInfo> findOrderDetailsByOrderTime(String day) {
		return orderDao.findOrderDetailsByOrderTime(day);
	}

	@Override
	public List<OrderInfo> findOrderDetailsByUserId(Integer userId) {
		return orderDao.findOrderDetailsByUserId(userId);
	}

	@Override
	public List<OrderInfo> findOrderDetaisByFoodName(String foodName) {
		return orderDao.findOrderDetaisByFoodName(foodName);
	}

	@Override
	public List<FoodCount> getDaylyCount(String day) {

		return orderDao.getDaylyCount(day);
	}

	@Override
	public float getCountAll(List<FoodCount> foods) {
		float countAll = 0.0F;
		for (FoodCount foodCount : foods) {
			countAll += foodCount.getCount();
		}
		return countAll;
	}

	@Override
	public void confirmOrder(int orderId) {
		orderDao.setSend(orderId, 1);
	}

	@Override
	public List<OrderInfo> findOrderDeltailsAll() {
		return orderDao.findOrderDetaisAll();
	}

	@Override
	public List<FoodCount> getTopSellFoods(int topN) {
		//
		return orderDao.getTopSellFoods(topN);
	}

	@Override
	public int addOrders(int userId) {
		int effectedRows=orderDao.addFromCart(userId);
		int deletedRows = cartDao.deleteByUserId(userId);
		if (effectedRows>0 && deletedRows>0) {
			return 1;
		}
		return -1;
	}
}
