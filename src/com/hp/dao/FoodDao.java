package com.hp.dao;

import java.util.List;

import com.hp.entity.Food;
import com.hp.entity.FoodCount;
import com.hp.entity.FoodType;

public interface FoodDao {
	/**
	 * 添加菜品
	 * @param food
	 * @return
	 */
	public int addFood(Food food);
	/**
	 * 查询所有要菜品
	 * @return
	 */
	public List<Food> findAll();
	/**
	 * 根据编号查询菜品详情
	 * @param typeID
	 * @return
	 */
	public List<Food> findId(int typeID);
	/**
	 * 修改菜品
	 * @param food
	 * @return
	 */
	public int updFood(Food food);
}
