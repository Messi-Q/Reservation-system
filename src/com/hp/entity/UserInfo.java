package com.hp.entity;

/**
 * 用户实体类
 * 
 * @author Administrator
 *
 */
public class UserInfo {
	private Integer UserId;
	private String UserName;
	private String UserPwd;
	private String RealName;
	private String Sex;
	private Integer Age;
	private String CardId;
	private String UserAddress;
	private String UserTel;
	private String Email;
	private String Ems;

	public UserInfo() {
	}

	public UserInfo(Integer userId, String userName, String userPwd) {
		super();
		UserId = userId;
		UserName = userName;
		UserPwd = userPwd;
	}

	public UserInfo(String userName, String userPwd) {
		super();
		UserName = userName;
		UserPwd = userPwd;
	}

	public UserInfo(String userName, String userPwd, String realName, String sex, Integer age, String cardId,
			String userAddress, String userTel, String email, String ems) {
		super();
		UserName = userName;
		UserPwd = userPwd;
		RealName = realName;
		Sex = sex;
		Age = age;
		CardId = cardId;
		UserAddress = userAddress;
		UserTel = userTel;
		Email = email;
		Ems = ems;
	}

	public UserInfo(Integer userId, String userName, String userPwd, String realName, String sex, Integer age,
			String cardId, String userAddress, String userTel, String email, String ems) {
		super();
		UserId = userId;
		UserName = userName;
		UserPwd = userPwd;
		RealName = realName;
		Sex = sex;
		Age = age;
		CardId = cardId;
		UserAddress = userAddress;
		UserTel = userTel;
		Email = email;
		Ems = ems;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer Userid) {
		UserId = Userid;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPwd() {
		return UserPwd;
	}

	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}

	public String getRealName() {
		return RealName;
	}

	public void setRealName(String realName) {
		RealName = realName;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getCardId() {
		return CardId;
	}

	public void setCardId(String cardId) {
		CardId = cardId;
	}

	public String getUserAddress() {
		return UserAddress;
	}

	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}

	public String getUserTel() {
		return UserTel;
	}

	public void setUserTel(String userTel) {
		UserTel = userTel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEms() {
		return Ems;
	}

	public void setEms(String ems) {
		Ems = ems;
	}

}
