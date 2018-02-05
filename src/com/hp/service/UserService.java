package com.hp.service;

import com.hp.entity.UserInfo;

public interface UserService {
	public int userRegister(UserInfo userinfo);
	public int userUpdate(UserInfo userinfo);
	public UserInfo userLogin(UserInfo userinfo);
	public boolean userExist(String username);
}
