package com.hp.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC工具类（帮助类，处理JDBC的公共操作）
 * @author Administrator
 *
 */
public class DBUtil {
	//定义常量字符串存放数据库连接的信息
    //驱动类的路径
	private static final String DRIVER = "com.mysql.jdbc.Driver"; 
	//连接字符串
	private static final String URL = "jdbc:mysql://localhost:3306/orderdb?useUnicode=true&characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PWD = "root";	
	

	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(DRIVER);
			//在驱动管理器的基础上获得链接
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void closeConn(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * 设置SQL语句中参数的值
	 * @param ps
	 * @param values
	 */
	public static void setParam(PreparedStatement ps,Object...values){
		//判断SQL语句中是否有参
		if(values!=null && values.length>0){
			//循环设置参数的值
			for (int i = 0; i < values.length; i++) {
				try {
					ps.setObject(i+1, values[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 执行增 删 改
	 * @param conn
	 * @param sql
	 * @param values
	 * @return
	 */
	public static int executeUpdate(Connection conn, String sql,Object...values){
		int count=0;
		try {
			//编写SQL语句
			PreparedStatement ps = conn.prepareStatement(sql);
			//设置参数的值
			setParam(ps,values);
			//执行SQL语句
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 执行查询
	 * @param conn
	 * @param sql
	 * @param values
	 * @return
	 */
	public static ResultSet executeQuery(Connection conn, String sql,Object...values){
		ResultSet rs = null;
		try {
			//编写SQL语句
			PreparedStatement ps = conn.prepareStatement(sql);
			//设置参数的值
			setParam(ps,values);
			//执行SQL语句
			rs  = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
