package com.hp.dao;

import java.util.List;

import com.hp.entity.FoodType;

public interface FoodTypeDao {
	/**
	 * 查询所有类别
	 * @return
	 */
	public List<FoodType> queryAll();
	/**
	 * 添加类别
	 * @param foodtype
	 * @return
	 */
	public int addFoodType(FoodType foodtype);
	/**
	 * 根据编号查询
	 * @param typeID
	 * @return
	 */
	public List<FoodType> findId(int typeID);
	/**
	 * 根据编号修改
	 * @param typeID
	 * @return
	 */
	public int updById(FoodType foodtype);
	/**
	 * 删除类别
	 * @param typeID
	 * @return
	 */
	public int del(int typeID);
}
