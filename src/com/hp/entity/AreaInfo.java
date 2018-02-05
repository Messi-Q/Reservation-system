package com.hp.entity;

public class AreaInfo {

	private String name;
	private String hot;
	private String desp;

	public AreaInfo(String name, String hot, String desp) {
		super();
		this.name = name;
		this.hot = hot;
		this.desp = desp;
	}

	public AreaInfo() {
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Area [name=" + name + ", hot=" + hot + ",desp=" + desp + "]";
	}

	public String getHot() {
		return hot;
	}

	public String getDesp() {
		return desp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}
}
