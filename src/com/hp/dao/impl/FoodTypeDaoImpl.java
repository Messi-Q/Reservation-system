package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hp.dao.*;
import com.hp.entity.FoodType;
import com.hp.util.DBUtil;

public class FoodTypeDaoImpl implements FoodTypeDao {
	Connection conn = DBUtil.getConn();
	String sql = "";
	
	@Override
	public List<FoodType> queryAll() {
		List<FoodType> flist = new ArrayList<FoodType>();
		try {
			sql = "select * from FoodType";
			ResultSet rs = DBUtil.executeQuery(conn, sql);
			while (rs.next()) {
				flist.add(new FoodType(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flist;
	}

	@Override
	public int addFoodType(FoodType foodtype) {
		sql = "insert into FoodType(TypeName) values(?)";
		int i = DBUtil.executeUpdate(conn, sql, foodtype.getTypeName());
		return i;
	}

	@Override
	public List<FoodType> findId(int typeID) {
		sql = "select * from FoodType where typeid=?";
		List<FoodType> flist = new ArrayList<FoodType>();
		ResultSet rs = DBUtil.executeQuery(conn, sql,typeID);
		try {
			while (rs.next()) {
				flist.add(new FoodType(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flist;
	}

	@Override
	public int updById(FoodType foodtype) {
		sql = "update FoodType set TypeName=? where typeID=? ";
		return DBUtil.executeUpdate(conn, sql,foodtype.getTypeName(),foodtype.getTypeId());
	}

	@Override
	public int del(int typeID) {
		String sql1 = "DELETE from FoodInfo where typeid=?";
		String sql2="DELETE from FoodType where typeid=?";
		DBUtil.executeUpdate(conn, sql1, typeID);
		int i2=	DBUtil.executeUpdate(conn, sql2, typeID);
		return i2;
	}

}
