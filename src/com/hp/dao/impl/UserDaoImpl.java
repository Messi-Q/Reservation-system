package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.dao.UserDao;
import com.hp.entity.UserInfo;
import com.hp.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int userRegister(UserInfo userinfo) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into UserInfo(UserName,UserPwd,RealName,Sex,Age,CardId,UserAddress,UserTel,Email,Ems)values(?,?,?,?,?,?,?,?,?,?)";
		int i = DBUtil.executeUpdate(conn, sql, userinfo.getUserName(), userinfo.getUserPwd(), userinfo.getRealName(),
				userinfo.getSex(), userinfo.getAge(), userinfo.getCardId(), userinfo.getUserAddress(),
				userinfo.getUserTel(), userinfo.getEmail(), userinfo.getEms());
		DBUtil.closeConn(conn);
		return i;
	}

	@Override
	public UserInfo userLogin(UserInfo userinfo) {
		UserInfo u=null;
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select * from UserInfo where UserName=? and UserPwd=?";
			ResultSet rs = DBUtil.executeQuery(conn, sql, userinfo.getUserName(), userinfo.getUserPwd());
			// 判断
			if (rs.next()) {
				u = new UserInfo();
				u.setUserId(rs.getInt("userid"));
				u.setUserName(rs.getString("username"));
				u.setUserPwd(rs.getString("userpwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return u;
	}

	@Override
	public boolean userExist(String username) {
		boolean flg = true;
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select UserName from UserInfo where UserName=?";
			ResultSet rs = DBUtil.executeQuery(conn, sql, username);
			if (rs.next()) {
				flg = true;
			} else {
				flg = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
		}
		return flg;
	}

	@Override
	public int userUpdate(UserInfo userinfo) {
		Connection conn = DBUtil.getConn();
		String sql = "update UserInfo set UserName=?,UserPwd=? where UserId=?";
		int i = DBUtil.executeUpdate(conn, sql, userinfo.getUserName(), userinfo.getUserPwd(), userinfo.getUserId());
		DBUtil.closeConn(conn);
		return i;
	}

}
