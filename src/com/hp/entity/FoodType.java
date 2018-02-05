package com.hp.entity;

public class FoodType {
	private int typeId;
	private String typeName;
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public FoodType() {
		super();
	}
	public FoodType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public FoodType(String typeName) {
		super();
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "FoodType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
