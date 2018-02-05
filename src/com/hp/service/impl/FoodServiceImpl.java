package com.hp.service.impl;

import java.util.List;

import com.hp.dao.FoodDao;
import com.hp.dao.impl.FoodDaoImpl;
import com.hp.entity.Food;
import com.hp.service.FoodService;

public class FoodServiceImpl implements FoodService {
	FoodDao foodDao=new FoodDaoImpl();
	/**
	 * 添加菜品
	 */
	@Override
	public int addFood(Food food) {
		return this.foodDao.addFood(food);
	}
	@Override
	public List<Food> findAll() {
		return this.foodDao.findAll();
	}
	@Override
	public List<Food> findId(int typeID) {
		return this.foodDao.findId(typeID);
	}
	@Override
	public int updFood(Food food) {
		return this.foodDao.updFood(food);
	}

}
