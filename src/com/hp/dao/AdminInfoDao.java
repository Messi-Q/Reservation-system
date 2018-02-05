package com.hp.dao;

import java.util.List;

import com.hp.entity.AdminInfo;

public interface AdminInfoDao {
	//查询所有
	public List<AdminInfo> queryAdmin(String sql,Object...values);
	//修改
	public int updateUser(String sql,Object...values);
}
