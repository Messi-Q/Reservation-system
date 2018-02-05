package com.hp.service;

import java.util.List;

import com.hp.entity.AdminInfo;

public interface AdminService {
	//查询所有
	public List<AdminInfo> queryAdmin(String sql,Object...values);
	//修改
	public int updateUser(String sql,Object...values);
}
