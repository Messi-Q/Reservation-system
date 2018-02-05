package com.hp.entity;

public class MapInfo {
	private String province;
	private String foodName;
	private String imgPath;
	private String hot;
	
	public MapInfo(String province, String foodName, String imgPath, String hot) {
		super();
		this.province = province;
		this.foodName = foodName;
		this.imgPath = imgPath;
		this.hot = hot;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	
}
