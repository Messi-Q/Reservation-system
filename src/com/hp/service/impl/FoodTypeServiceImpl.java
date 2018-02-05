package com.hp.service.impl;

import java.util.List;

import com.hp.dao.FoodTypeDao;
import com.hp.dao.impl.FoodTypeDaoImpl;
import com.hp.entity.FoodType;
import com.hp.service.FoodTypeService;

public class FoodTypeServiceImpl implements FoodTypeService {
	FoodTypeDao foodTypeDao = new FoodTypeDaoImpl();
	@Override
	public List<FoodType> queryAll() {
		return this.foodTypeDao.queryAll();
	}
	@Override
	public int addFoodType(FoodType foodtype) {
		return this.foodTypeDao.addFoodType(foodtype);
	}
	@Override
	public List<FoodType> findId(int typeID) {
		return this.foodTypeDao.findId(typeID);
	}
	@Override
	public int updById(FoodType foodtype) {
		return this.foodTypeDao.updById(foodtype);
	}
	@Override
	public int del(int typeID) {
		return this.foodTypeDao.del(typeID);
	}

}
