package com.hp.entity;

import java.util.Date;

//订单信息表
public class OrderInfo {
//	CREATE TABLE OrderInfo(
//			OrderId  INT PRIMARY KEY AUTO_INCREMENT,
//			FoodId INT,
//			UserId INT,
//			OrderNum INT,
//			OrderTime DATETIME,
//			Send SMALLINT,
//			FOREIGN KEY(FoodId)REFERENCES FoodInfo(FoodId),
//			FOREIGN KEY(UserId)REFERENCES UserInfo(UserId)
//		)AUTO_INCREMENT=1,CHARSET=utf8;
	
	//订单id,主键
	private Integer orderId;
	
	//菜品id--外键foodInfo
	private Integer foodId;
	
	//用户id--外键 userinfo
	private Integer userId;
	
	//订单数量
	private Integer orderNum;
	
	//订单时间
	private Date orderTime;
	
	//是否送达
	private Integer send;
	
	//用户信息 
	private UserInfo userInfo;
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Food getFoodInfo() {
		return foodInfo;
	}

	public void setFoodInfo(Food foodInfo) {
		this.foodInfo = foodInfo;
	}

	//菜品信息
	private Food foodInfo;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getSend() {
		return send;
	}

	public void setSend(Integer send) {
		this.send = send;
	}

	public OrderInfo() {
	}

	public OrderInfo(Integer orderId, Integer foodId, Integer userId, Integer orderNum, Date orderTime, Integer send,
			UserInfo userInfo, Food foodInfo) {
		super();
		this.orderId = orderId;
		this.foodId = foodId;
		this.userId = userId;
		this.orderNum = orderNum;
		this.orderTime = orderTime;
		this.send = send;
		this.userInfo = userInfo;
		this.foodInfo = foodInfo;
	}

	

	


	
}



