package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.dao.CartDao;
import com.hp.entity.Cart;
import com.hp.util.DBUtil;

public class CartDaoImpl implements CartDao {

	@Override
	public ArrayList<Cart> showAll(int id) {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select cartid,foodname,VipPrice,ordernum from foodinfo,cart,userinfo where foodinfo.foodid=cart.foodid and cart.user_id=userinfo.userid and userinfo.userid=?";
			String sql1 = "select sum(VipPrice*ordernum) 'totalPrice',sum(ordernum) 'totalNum' from foodinfo,cart,userinfo where foodinfo.foodid=cart.foodid and cart.user_id=userinfo.userid and userinfo.userid=? ";
			ResultSet rs1 = DBUtil.executeQuery(conn, sql,id);
			while (rs1.next()) {
				Cart cart1 = new Cart();
				cart1.setPrice(rs1.getFloat("VipPrice"));
				cart1.setCartId(rs1.getInt("cartId"));
				cart1.setFoodName(rs1.getString("foodname"));
				cart1.setOrderNum(rs1.getInt("ordernum"));
				cartList.add(cart1);
			}
			ResultSet rs2 = DBUtil.executeQuery(conn, sql1,id);
			rs2.next();
			Cart cart2 = new Cart(rs2.getFloat("totalPrice"), rs2.getInt("totalNum"));
			cartList.add(cart2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return cartList;
	}

	@Override
	public int deleteCart(int cartId) {
		Connection conn = DBUtil.getConn();
		String sql = "delete from cart where cartId=?";
		int i = DBUtil.executeUpdate(conn, sql, cartId);
		DBUtil.closeConn(conn);
		return i;
	}

	@Override
	public int addCart(Cart cart) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into cart (foodid,user_id,ordernum) values (?,?,?)";
		int i = DBUtil.executeUpdate(conn, sql, cart.getFoodId(), cart.getUserId(), cart.getOrderNum());
		DBUtil.closeConn(conn);
		return i;
	}

	@Override
	public ArrayList<Cart> showThree(int id) {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select cartid,foodname,VipPrice,ordernum from foodinfo,cart,userinfo where foodinfo.foodid=cart.foodid and cart.user_id=userinfo.userid and userinfo.userid=? limit 3";
			String sql1 = "select sum(VipPrice*ordernum) 'totalPrice',sum(ordernum) 'totalNum' from foodinfo,cart,userinfo where foodinfo.foodid=cart.foodid and cart.user_id=userinfo.userid and userinfo.userid=? ";
			ResultSet rs1 = DBUtil.executeQuery(conn, sql,id);
			while (rs1.next()) {
				Cart cart1 = new Cart();
				cart1.setPrice(rs1.getFloat("VipPrice"));
				cart1.setCartId(rs1.getInt("cartId"));
				cart1.setFoodName(rs1.getString("foodname"));
				cart1.setOrderNum(rs1.getInt("ordernum"));
				cartList.add(cart1);
			}
			ResultSet rs2 = DBUtil.executeQuery(conn, sql1,id);
			if (rs2.next()) {
				Cart cart2 = new Cart(rs2.getFloat("totalPrice"), rs2.getInt("totalNum"));
				cartList.add(cart2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return cartList;
	}

	@Override
	public int deleteByUserId(int userId) {
		Connection conn= DBUtil.getConn();
		String sql = "delete from cart where user_Id = ?";
		return DBUtil.executeUpdate(conn, sql, userId);
	}
}
