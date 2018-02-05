package com.hp.entity;

//��Ʒ����
public class FoodCount {
	private String foodName;
	private int nums;
	private float price;
	private float count;
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}
	public FoodCount(String foodName, int nums, float price, float count) {
		super();
		this.foodName = foodName;
		this.nums = nums;
		this.price = price;
		this.count = count;
	}
	public FoodCount() {
		super();
	}
	@Override
	public String toString() {
		return "FoodCount [foodName=" + foodName + ", nums=" + nums + ", price=" + price + ", count=" + count + "]";
	}
	
}
