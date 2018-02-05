package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hp.dao.FoodDao;
import com.hp.entity.Food;
import com.hp.entity.FoodCount;
import com.hp.entity.FoodType;
import com.hp.util.DBUtil;

public class FoodDaoImpl implements FoodDao {
	Connection conn = DBUtil.getConn();
	String sql = "";

	// 添加菜品
	@Override
	public int addFood(Food food) {
		sql = "insert into FoodInfo(FoodName,VipPrice,MarketPrice,TypeId,FoodDesp,ImageUrl,FoodIng) values(?,?,?,?,?,?,?)";
		int i = DBUtil.executeUpdate(conn, sql, food.getFoodName(), food.getVipPrice(), food.getMarketPrice(),
				food.getTypeID(), food.getFoodDesp(), food.getImageUrl(), food.getFoodIng());
		return i;
	}

	@Override
	public List<Food> findAll() {
		List<Food> dist = new ArrayList<Food>();
		try {
			sql = "select * from FoodInfo,FoodType where FoodInfo.typeid=FoodType.typeid";
			ResultSet rs = DBUtil.executeQuery(conn, sql);
			while (rs.next()) {
				dist.add(new Food(rs.getInt("foodId"), rs.getString("foodName"), rs.getFloat("vipPrice"),
						rs.getFloat("marketPrice"), rs.getString("typeName"), rs.getString("foodDesp"),
						rs.getString("imageUrl"), rs.getString("foodIng")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dist;
	}

	@Override
	public List<Food> findId(int FoodID) {
		sql = "select * from FoodInfo where FoodId=?";
		List<Food> flist = new ArrayList<Food>();
		ResultSet rs = DBUtil.executeQuery(conn, sql, FoodID);
		try {
			while (rs.next()) {
				flist.add(new Food(rs.getInt("foodId"), rs.getString("foodName"), rs.getFloat("vipPrice"),
						rs.getFloat("marketPrice"), rs.getString("foodDesp"), rs.getString("imageUrl"),
						rs.getString("foodIng")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flist;
	}

	@Override
	public int updFood(Food food) {
		sql = "update FoodInfo set foodName=?,vipPrice=?,marketPrice=?,foodDesp=?,foodIng=? where foodId=? ";
		return DBUtil.executeUpdate(conn, sql, food.getFoodName(), food.getVipPrice(), food.getMarketPrice(),
				food.getFoodDesp(), food.getFoodIng(), food.getFoodId());
	}


}
