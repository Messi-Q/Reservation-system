package com.hp.dao;

import com.hp.entity.UserInfo;

public interface UserDao {
	public int userRegister(UserInfo userinfo);
	public int userUpdate(UserInfo userinfo);
	public boolean userExist(String username);
	public UserInfo userLogin(UserInfo userinfo);	
}
