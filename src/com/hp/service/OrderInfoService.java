package com.hp.service;

import java.util.List;

import com.hp.entity.FoodCount;
import com.hp.entity.OrderInfo;

public interface OrderInfoService {
	/**
	 * ���ж�����Ϣ
	 * 
	 * @return
	 */
	public List<OrderInfo> findOrderDeltailsAll();

	/**
	 * �������ڲ�ѯ������ϸ
	 * 
	 * @param day
	 * @return
	 */
	public List<OrderInfo> findOrderDetailsByOrderTime(String day);

	/**
	 * ����id��ѯ������ϸ
	 * 
	 * @param userId
	 * @return
	 */
	public List<OrderInfo> findOrderDetailsByUserId(Integer userId);

	/**
	 * ���ݲ�Ʒ����ѯ������ϸ
	 * 
	 * @param foodName
	 * @return
	 */
	public List<OrderInfo> findOrderDetaisByFoodName(String foodName);

	/**
	 * ��������Ϣͳ��
	 * @return
	 */
	public List<FoodCount> getDaylyCount(String day);

	/**
	 * ���ܶ�ͳ��
	 * 
	 * @param foods
	 * @return
	 */
	public float getCountAll(List<FoodCount> foods);

	/**
	 * ȷ��ĳ������
	 * 
	 * @param orderId
	 */
	public void confirmOrder(int orderId);
	
	/**
	 * ��ȡ����ǰn�Ĳ�Ʒ
	 * @return
	 */
	public List<FoodCount> getTopSellFoods(int topN);


	public int addOrders(int userId);
}
