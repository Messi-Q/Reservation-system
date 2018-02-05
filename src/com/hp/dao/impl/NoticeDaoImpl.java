package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.dao.NoticeDao;
import com.hp.entity.Notice;
import com.hp.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public int addNotice(Notice notice) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into noticeinfo(noticeTitle,noticeTime,noticeCont) values(?,now(),?)";
		int i = DBUtil.executeUpdate(conn, sql, notice.getNoticeTitle(),notice.getNoticeCont());
		DBUtil.closeConn(conn);
		return i;
	}

	@Override
	public int deleteNotice(int noticeId) {
		Connection conn = DBUtil.getConn();
		String sql = "delete from noticeinfo where noticeId=?";
		int i = DBUtil.executeUpdate(conn, sql,noticeId);
		DBUtil.closeConn(conn);
		return i;
	}

	@Override
	public int updateNotice(Notice notice) {
		Connection conn = DBUtil.getConn();
		String sql = "update noticeinfo set noticeTitle=?,noticeTime=now(),noticeCont=? where noticeId=?";
		int i = DBUtil.executeUpdate(conn, sql, notice.getNoticeTitle(),notice.getNoticeCont(),notice.getNoticeId());
		DBUtil.closeConn(conn);
		return i;
	}

	@Override
	public ArrayList<Notice> findAll() {
		ArrayList<Notice> deptList = new ArrayList<Notice>();
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select * from noticeinfo";
			ResultSet rs = DBUtil.executeQuery(conn, sql);
			while (rs.next()) {
				Notice notice = new Notice(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
				deptList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.closeConn(conn);
		}
		return deptList;
	}

	
	@Override
	public ArrayList<Notice> findOneRow(int noticeId) {
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select * from noticeinfo where noticeId=?";
			ResultSet rs = DBUtil.executeQuery(conn, sql,noticeId);
			while (rs.next()) {
				Notice notice = new Notice(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
				noticeList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.closeConn(conn);
		}
		return noticeList;
	}
	
	
	
	public ArrayList<Notice> findLastThree() {
		ArrayList<Notice> deptList = new ArrayList<Notice>();
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select * from noticeinfo order by noticeId desc limit 0,3";
			ResultSet rs = DBUtil.executeQuery(conn, sql);
			while (rs.next()) {
				Notice notice = new Notice( rs.getInt("noticeId"),rs.getString("noticeTitle") ,rs.getString("noticeTime"),rs.getString("noticeCont"));
				deptList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.closeConn(conn);
		}
		return deptList;
	}

	@Override
	public ArrayList<Notice> findSelectOne(int noticeId) {
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		Connection conn = DBUtil.getConn();
		try {
			String sql = "select * from noticeinfo where noticeId=?";
			ResultSet rs = DBUtil.executeQuery(conn, sql,noticeId);
			while (rs.next()) {
				Notice notice = new Notice(rs.getInt("noticeId"),rs.getString("noticeTitle") ,rs.getString("noticeTime"),rs.getString("noticeCont"));
				noticeList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.closeConn(conn);
		}
		return noticeList;
	}

}
