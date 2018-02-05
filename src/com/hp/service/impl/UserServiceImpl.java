package com.hp.service.impl;

import com.hp.dao.UserDao;
import com.hp.dao.impl.UserDaoImpl;
import com.hp.entity.UserInfo;
import com.hp.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userdao=new UserDaoImpl();
	
	@Override
	public int userRegister(UserInfo userinfo) {
		return userdao.userRegister(userinfo);
	}

	@Override
	public UserInfo userLogin(UserInfo userinfo) {
		return userdao.userLogin(userinfo);
	}

	@Override
	public boolean userExist(String username) {
		return userdao.userExist(username);
	}

	@Override
	public int userUpdate(UserInfo userinfo) {
		return userdao.userUpdate(userinfo);
	}

}
