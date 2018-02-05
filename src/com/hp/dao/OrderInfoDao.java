package com.hp.dao;

import java.util.List;

import com.hp.entity.FoodCount;
import com.hp.entity.OrderInfo;

public interface OrderInfoDao {

	/**
	 * 返回所有订单记录
	 * 
	 * @return
	 */
	public List<OrderInfo> findAll();

	/**
	 * 根据id查询单个订单
	 * 
	 * @param orderId
	 * @return
	 */
	public OrderInfo findById(Integer orderId);

	/**
	 * 根据订单id删除一条订单
	 * 
	 * @param orderId
	 * @return
	 */
	public int deleteById(Integer orderId);

	/**
	 * 更新一条订单
	 * 
	 * @param orderInfo
	 * @return
	 */
	public int updateById(OrderInfo orderInfo);

	/**
	 * 添加一条订单
	 * 
	 * @param orderInfo
	 */
	public int add(OrderInfo orderInfo);

	/**
	 * @param day
	 * @return
	 */
	public List<OrderInfo> findOrderDetailsByOrderTime(String day);

	/**
	 * @param userId
	 * @return
	 */
	public List<OrderInfo> findOrderDetailsByUserId(Integer userId);

	/**
	 * @param foodName
	 * @return
	 */
	public List<OrderInfo> findOrderDetaisByFoodName(String foodName);

	
	/**
	 * @param day ,如'2018-01-05'
	 * @return
	 */
	public List<FoodCount> getDaylyCount(String day);
	
	/**
	 * 查询销量最高的5种菜品销量
	 * @return
	 */
	public List<FoodCount> getTopSellFoods(int topN);
	
	/**
	 * 确认订单
	 * @param orderId
	 * @param value
	 * @return
	 */
	public int setSend(int orderId,int value);
	
	/**
	 * 查询所有订单信息
	 * @return
	 */
	public List<OrderInfo> findOrderDetaisAll();
	
	
	public  int addFromCart(int userId);

}
