package com.hp.entity;
public class AdminInfo {
	private int AdminId;
	private String AdminName;
	private String AdminPwd;
	
	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminInfo(String adminName, String adminPwd) {
		super();
		AdminName = adminName;
		AdminPwd = adminPwd;
	}
	
	public AdminInfo(int adminId, String adminName, String adminPwd) {
		super();
		AdminId = adminId;
		AdminName = adminName;
		AdminPwd = adminPwd;
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPwd() {
		return AdminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		AdminPwd = adminPwd;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getAdminId()+this.getAdminName()+this.getAdminPwd();
	}
	
}

