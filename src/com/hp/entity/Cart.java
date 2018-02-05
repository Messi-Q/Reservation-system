package com.hp.entity;

public class Cart {
	
	private String foodName;
	private float price;
	private int orderNum;
	private float totalPrice;
	private int totalNum;
	private int cartId;
	private int userId;
	private int foodId;
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public Cart() {
		super();
	}
	
	public Cart(float totalPrice, int totalNum) {
		super();
		this.totalPrice = totalPrice;
		this.totalNum = totalNum;
	}
	
	public Cart(String foodName, float price) {
		super();
		this.foodName = foodName;
		this.price = price;
	}
	
	public Cart(int orderNum, int userId, int foodId) {
		super();
		this.orderNum = orderNum;
		this.userId = userId;
		this.foodId = foodId;
	}
	public Cart(String foodName, float price, int orderNum) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.orderNum = orderNum;
	}
	
	public Cart(String foodName, float price, int orderNum, int cartId) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.orderNum = orderNum;
		this.cartId = cartId;
	}
	public Cart(String foodName, float price, int orderNum, float totalPrice, int totalNum, int cartId) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.orderNum = orderNum;
		this.totalPrice = totalPrice;
		this.totalNum = totalNum;
		this.cartId = cartId;
	}

}
