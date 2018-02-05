package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hp.dao.OrderInfoDao;

import com.hp.entity.FoodCount;
import com.hp.entity.Food;
import com.hp.entity.OrderInfo;
import com.hp.entity.UserInfo;
import com.hp.util.DBUtil;

public  class OrderInfoDaoImpl implements OrderInfoDao {

	private final static String FIND_ALL = "select orderId,foodId,userId,orderNum,orderTime,send from orderInfo";

	private final static String FIND_ONE_BY_ID = "select orderId,foodId,userId,orderNum,orderTime,send from orderInfo where orderId = ?";

	private static final String DELETE_ONE_BY_ID = "delete from orderInfo where orderId = ?";

	private static final String UPDATE_FOR_ALL_FILEDS = "update orderInfo set foodId = ?, orderNum = ? ,orderTime = ? ,send =? where orderId =?  ";

	private static final String ADD_ONE = "insert into orderInfo(foodId,userId,orderNum,orderTime,send) values (?,?,?,?,?)";

	private static final String FIND_USERINFO_AND_ORDERINFO = "select orderId, o.foodId as foodId, u.userId,realName,userTel,userAddress,foodName,orderNum,marketPrice, orderTime,send from userInfo u,orderInfo o ,foodInfo f where u.userId=o.userId and o.foodId=f.foodId";

	private static final String DAYLY_COUNT = "select foodName ,sum(orderNum) as nums,marketPrice as price,sum(orderNum*marketPrice) as singleCount from foodinfo, orderInfo where foodInfo.foodId=orderInfo.foodId and orderTime > ? and orderTime < date_add(?,Interval 1 day) group by foodName";

	private static final String TOP_SELL_FOODS = "select foodName,sum(orderNum) as nums from foodInfo,orderInfo where foodInfo.foodId=orderInfo.foodId group by foodName order by count(orderNum) desc limit 0,?";

	private static final String SET_SEND = "update orderInfo set send =? where orderId =?  ";
	
	private static final String ADD_FROM_CART="INSERT into orderinfo(userid,foodId,ordernum,orderTime,send) (select user_id ,foodId, count(orderNum) ,CURRENT_TIMESTAMP(),0 from cart where cart.user_Id=? GROUP BY foodId) ";
	
//	private static final String FIND_FOODINFO_ORDERINFO_FOODTYPE="select foodId,foodName,foodType, from foodInfo,orderInfo,footype where foodInfo.foodId=orderInfo.foodId and foodInfo.foodId=foodType.foodId  ";
	
	private static final int ALL = 0;

	public static final int BY_UERID = 1;

	public static final int BY_FOODNAME = 2;

	public static final int BY_ORDERTIME = 3;

	@Override
	public List<OrderInfo> findAll() {
		Connection conn = DBUtil.getConn();
		List<OrderInfo> orders = new ArrayList<>();

		try {

			ResultSet rs = DBUtil.executeQuery(conn, FIND_ALL);
			while (rs.next()) {

				OrderInfo order = new OrderInfo();
				order.setOrderId(rs.getInt("orderId"));
				order.setFoodId(rs.getInt("foodId"));
				order.setUserId(rs.getInt("userId"));
				order.setOrderNum(rs.getInt("orderNum"));
				order.setOrderTime(rs.getTimestamp("orderTime"));
				order.setSend(rs.getInt("send"));

				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return orders;
	}
	@Override
	public OrderInfo findById(Integer orderId) {
		Connection conn = DBUtil.getConn();
		OrderInfo uniqueOrder = null;
		try {

			ResultSet rs = DBUtil.executeQuery(conn, FIND_ONE_BY_ID, new Object[] { orderId });
			if (rs.next()) {
				uniqueOrder = new OrderInfo();
				uniqueOrder.setOrderId(rs.getInt("orderId"));
				uniqueOrder.setFoodId(rs.getInt("foodId"));
				uniqueOrder.setUserId(rs.getInt("userId"));
				uniqueOrder.setOrderNum(rs.getInt("orderNum"));
				uniqueOrder.setOrderTime(rs.getDate("orderTime"));
				uniqueOrder.setSend(rs.getInt("send"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return uniqueOrder;
	}
	@Override
	public int deleteById(Integer orderId) {
		Connection conn = DBUtil.getConn();
		int effectedRows = DBUtil.executeUpdate(conn, DELETE_ONE_BY_ID, new Object[] { orderId });
		DBUtil.closeConn(conn);
		if (effectedRows == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateById(OrderInfo orderInfo) {
		Connection conn = DBUtil.getConn();
		Object[] params = { orderInfo.getFoodId(), orderInfo.getOrderNum(), orderInfo.getOrderTime(),
				orderInfo.getSend(), orderInfo.getOrderId() };
		int effectedRows = DBUtil.executeUpdate(conn, UPDATE_FOR_ALL_FILEDS, params);
		DBUtil.closeConn(conn);
		if (effectedRows == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int add(OrderInfo orderInfo) {
		Connection conn = DBUtil.getConn();
		Object[] params = { orderInfo.getFoodId(), orderInfo.getUserId(), orderInfo.getOrderNum(),
				orderInfo.getOrderTime(), orderInfo.getSend() };
		int effectedRows = DBUtil.executeUpdate(conn, ADD_ONE, params);
		DBUtil.closeConn(conn);
		if (effectedRows == 1) {
			return 1;
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.apsfc.dao.OrderInfoDao#findUserOrders(int, java.lang.Object)
	 */
	private List<OrderInfo> findUserOrders(int findBy, Object param) {
		Connection conn = DBUtil.getConn();
		List<OrderInfo> orders = new ArrayList<>();

		try {
			String sql = FIND_USERINFO_AND_ORDERINFO;
			ResultSet rs = null;
			if (findBy == ALL) {
				rs = DBUtil.executeQuery(conn, sql);
			} else if (findBy == BY_UERID) {
				sql += " and u.userId = ? order by u.userId";
				rs = DBUtil.executeQuery(conn, sql, param);
			} else if (findBy == BY_FOODNAME) {
				sql += " and foodName like ? order by foodName";
				rs = DBUtil.executeQuery(conn, sql, "%" + param + "%");
			} else if (findBy == BY_ORDERTIME) {
				sql += " and orderTime > ? and orderTime < date_add(?,interval 1 day) order by orderTime"; // ���ڴ���
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
				if (param == null)
					param = new Date();
				if (param instanceof java.util.Date) {
					rs = DBUtil.executeQuery(conn, sql, sdf.format(param), sdf.format(param));
				}
				if (param instanceof String) {
					rs = DBUtil.executeQuery(conn, sql, param, param);
				}
			} 
				while (rs.next()) {

					OrderInfo order = new OrderInfo();
					order.setUserInfo(new UserInfo());

					order.getUserInfo().setUserId(rs.getInt("userId"));
					order.getUserInfo().setRealName(rs.getString("realName"));
					order.getUserInfo().setUserTel(rs.getString("userTel"));
					order.getUserInfo().setUserAddress(rs.getString("userAddress"));

					order.setFoodInfo(new Food());
					order.getFoodInfo().setFoodName(rs.getString("foodName"));

					order.setOrderId(rs.getInt("orderId")); // ����ʾ����Ϊȷ�ϵ�����
					order.setOrderNum(rs.getInt("orderNum"));
					order.getFoodInfo().setMarketPrice(rs.getFloat("marketPrice"));
					order.setOrderTime(rs.getTimestamp("orderTime"));
					order.setSend(rs.getInt("send"));

					orders.add(order);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return orders;
	}



	@Override
	public List<OrderInfo> findOrderDetaisAll() {
		return findUserOrders(ALL, null);
	}

	
	
	@Override
	public List<OrderInfo> findOrderDetailsByOrderTime(String day) {

		return findUserOrders(BY_ORDERTIME, day);
	}

	@Override
	public List<OrderInfo> findOrderDetailsByUserId(Integer userId) {
		return findUserOrders(BY_UERID, userId);
	}

	@Override
	public List<OrderInfo> findOrderDetaisByFoodName(String foodName) {
		return findUserOrders(BY_FOODNAME, foodName);
	}

	@Override
	public List<FoodCount> getDaylyCount(String day) {
		Connection conn = DBUtil.getConn();

		List<FoodCount> daylyLists = new ArrayList<>();
		try {
			ResultSet rs = DBUtil.executeQuery(conn, DAYLY_COUNT, day, day);
			while (rs.next()) {
				daylyLists.add(new FoodCount(rs.getString("foodName"), rs.getInt("nums"), rs.getFloat("price"),
						rs.getFloat("singleCount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return daylyLists;

	}

	@Override
	public List<FoodCount> getTopSellFoods(int topN) {
		Connection conn = DBUtil.getConn();

		List<FoodCount> tops = new ArrayList<>();
		try {
			ResultSet rs = DBUtil.executeQuery(conn, TOP_SELL_FOODS,topN);
			while (rs.next()) {
				FoodCount food = new FoodCount();
				food.setFoodName(rs.getString("foodName"));
				food.setNums(rs.getInt("nums"));
				tops.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return tops;
	}

	@Override
	public int setSend(int orderId, int value) {
		Connection conn = DBUtil.getConn();
		int rows = DBUtil.executeUpdate(conn, SET_SEND, value, orderId);
		DBUtil.closeConn(conn);
		return rows;
	}

	/**
	 * 从购物车中添加菜品到订单表
	 * @param userId
	 * @return
	 */
	public  int addFromCart(int userId){
		Connection conn = DBUtil.getConn();
		int rows = DBUtil.executeUpdate(conn, ADD_FROM_CART, userId);
		DBUtil.closeConn(conn);
		return rows;
	}
	
//	public 
	
}
