package com.hp.service.impl;

import java.util.List;

import com.hp.dao.AdminInfoDao;
import com.hp.dao.impl.AdminInfoDaoImp;
import com.hp.entity.AdminInfo;
import com.hp.service.AdminService;

public class AdminServiceImp implements AdminService {

	@Override
	public List<AdminInfo> queryAdmin(String sql, Object... values) {
		// TODO Auto-generated method stub
		AdminInfoDao aid=new AdminInfoDaoImp();
		List<AdminInfo> list=aid.queryAdmin(sql, values);
		return list;
	}

	@Override
	public int updateUser(String sql, Object... values) {
		// TODO Auto-generated method stub
		AdminInfoDao aid=new AdminInfoDaoImp();
		return aid.updateUser(sql, values);
	}
	
}
