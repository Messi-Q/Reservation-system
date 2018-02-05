package com.hp.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBC锟斤拷锟斤拷锟洁（锟斤拷锟斤拷锟洁，锟斤拷锟斤拷JDBC锟侥癸拷锟斤拷锟斤拷锟斤拷锟斤拷
 * @author Administrator
 *
 */
public class DBUtil1 {
	//锟斤拷锟藉常锟斤拷锟街凤拷锟斤拷锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷拥锟斤拷锟较�
    	//锟斤拷锟斤拷锟斤拷锟铰凤拷锟�
	private static final String DRIVER = "com.mysql.jdbc.Driver"; 
	//锟斤拷锟斤拷锟街凤拷锟斤拷
	private static final String URL = "jdbc:mysql://localhost:3306/orderdb?useUnicode=true&characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PWD = "root";	
	

	/**
	 * 锟斤拷锟斤拷锟斤拷锟�
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			//锟斤拷锟斤拷锟斤拷锟斤拷
			Class.forName(DRIVER);
			//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥伙拷锟斤拷锟较伙拷锟斤拷锟斤拷锟�
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
	 * 锟截憋拷锟斤拷锟斤拷
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
	 * 锟斤拷锟斤拷SQL锟斤拷锟斤拷胁锟斤拷锟斤拷锟街�
	 * @param ps
	 * @param values
	 */
	public static void setParam(PreparedStatement ps,List<Object> values){
		//锟叫讹拷SQL锟斤拷锟斤拷锟斤拷欠锟斤拷胁锟�
		if(values!=null && values.size()>0){
			//循锟斤拷锟斤拷锟矫诧拷锟斤拷锟斤拷值
			for (int i = 0; i < values.size(); i++) {
				try {
					ps.setObject(i+1, values.get(i));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 执锟斤拷锟斤拷 删 锟斤拷
	 * @param conn
	 * @param sql
	 * @param values
	 * @return
	 */
	public static int executeUpdate(Connection conn, String sql,List<Object> values){
		int count=0;
		try {
			//锟斤拷写SQL锟斤拷锟�
			PreparedStatement ps = conn.prepareStatement(sql);
			//锟斤拷锟矫诧拷锟斤拷锟斤拷值
			setParam(ps,values);
			//执锟斤拷SQL锟斤拷锟�
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 执锟叫诧拷询
	 * @param conn
	 * @param sql
	 * @param values
	 * @return
	 */
	public static ResultSet executeQuery(Connection conn, String sql,List<Object> values){
		ResultSet rs = null;
		try {
			//锟斤拷写SQL锟斤拷锟�
			PreparedStatement ps = conn.prepareStatement(sql);
			//锟斤拷锟矫诧拷锟斤拷锟斤拷值
			setParam(ps,values);
			//执锟斤拷SQL锟斤拷锟�
			rs  = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
