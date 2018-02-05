package com.hp.entity;

public class Food {
	private int foodId ;
	private String foodName;
	private float vipPrice;//会员价
	private float marketPrice;//市场价
	private int typeID;//类别编号
	private String typeName;
	private String foodDesp;
	private String imageUrl;
	private String foodIng;//原料
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Food(int foodId, String foodName, float vipPrice, float marketPrice, String foodDesp, String foodIng) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.vipPrice = vipPrice;
		this.marketPrice = marketPrice;
		this.foodDesp = foodDesp;
		this.foodIng = foodIng;
	}
	public float getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(float vipPrice) {
		this.vipPrice = vipPrice;
	}
	public float getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getFoodIng() {
		return foodIng;
	}
	public void setFoodIng(String foodIng) {
		this.foodIng = foodIng;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getFoodDesp() {
		return foodDesp;
	}
	public void setFoodDesp(String foodDesp) {
		this.foodDesp = foodDesp;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Food() {
		super();
	}
	public Food(String foodName, float vipPrice, float marketPrice, int typeID, String foodDesp, String imageUrl,
			String foodIng) {
		super();
		this.foodName = foodName;
		this.vipPrice = vipPrice;
		this.marketPrice = marketPrice;
		this.typeID = typeID;
		this.foodDesp = foodDesp;
		this.imageUrl = imageUrl;
		this.foodIng = foodIng;
	}
	public Food(String foodName, float vipPrice, float marketPrice, String foodDesp, String imageUrl,
			String foodIng) {
		super();
		this.foodName = foodName;
		this.vipPrice = vipPrice;
		this.marketPrice = marketPrice;
		this.foodDesp = foodDesp;
		this.imageUrl = imageUrl;
		this.foodIng = foodIng;
	}
	public Food(int foodId, String foodName, float vipPrice, float marketPrice, int typeID, String foodDesp,
			String imageUrl, String foodIng) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.vipPrice = vipPrice;
		this.marketPrice = marketPrice;
		this.typeID = typeID;
		this.foodDesp = foodDesp;
		this.imageUrl = imageUrl;
		this.foodIng = foodIng;
	}
	public Food(int foodId, String foodName, float vipPrice, float marketPrice, String foodDesp,
			String imageUrl, String foodIng) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.vipPrice = vipPrice;
		this.marketPrice = marketPrice;
		this.foodDesp = foodDesp;
		this.imageUrl = imageUrl;
		this.foodIng = foodIng;
	}
	public Food(String foodName, float vipPrice, float marketPrice, String typeName, String foodDesp, String imageUrl,
			String foodIng) {
		super();
		this.foodName = foodName;
		this.vipPrice = vipPrice;
		this.marketPrice = marketPrice;
		this.typeName = typeName;
		this.foodDesp = foodDesp;
		this.imageUrl = imageUrl;
		this.foodIng = foodIng;
	}
	public Food(int foodId,String foodName, float vipPrice, float marketPrice, String typeName, String foodDesp, String imageUrl,
			String foodIng) {
		super();
		this.foodId=foodId;
		this.foodName = foodName;
		this.vipPrice = vipPrice;
		this.marketPrice = marketPrice;
		this.typeName = typeName;
		this.foodDesp = foodDesp;
		this.imageUrl = imageUrl;
		this.foodIng = foodIng;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", vipPrice=" + vipPrice + ", marketPrice="
				+ marketPrice + ", typeID=" + typeID + ", FoodDesp=" + foodDesp + ", ImageUrl=" + imageUrl
				+ ", FoodIng=" + foodIng + "]";
	}
}
