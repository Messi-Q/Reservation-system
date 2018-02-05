package com.hp.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hp.dao.AdminInfoDao;
import com.hp.entity.AdminInfo;
import com.hp.util.DBUtil;

public class AdminInfoDaoImp implements AdminInfoDao{

	@Override
	public List<AdminInfo> queryAdmin(String sql,Object...values) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		List<AdminInfo> list=new ArrayList<AdminInfo>();
		
		ResultSet rs=DBUtil.executeQuery(conn, sql, values);
		try {
			while(rs.next()){
			AdminInfo a=new AdminInfo(rs.getInt(1),rs.getString(2),rs.getString(3));
			list.add(a);			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public int updateUser(String sql,Object...values) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		List<AdminInfo> list=new ArrayList<AdminInfo>();
		
		int rs=DBUtil.executeUpdate(conn, sql,values);
		
		DBUtil.closeConn(conn);
		return rs;
	}
}
