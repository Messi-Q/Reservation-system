package com.hp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hp.dao.HDFSDao;
import com.hp.entity.HDFSFile;
import com.hp.util.DBUtil1;

public class HDFSDaoImpl implements HDFSDao{

	@Override
	public int update(HDFSFile hdfsfile) {
		// TODO Auto-generated method stub
		int rs=0;
		if (hdfsfile.getFileId()>0) {
		Connection conn=DBUtil1.getConn();
		StringBuffer sb=new StringBuffer("update hdfs set ");
		List<Object> values=new ArrayList<>();
		if (hdfsfile.getFileName()!=null) {
			sb.append(", fileId=?");
			values.add(hdfsfile.getFileName());
		}
		if (hdfsfile.getSize()>0) {
			sb.append(", size=?");
			values.add(hdfsfile.getSize());
		}
		if (hdfsfile.getUploadtime()!=null) {
			sb.append(", uploadtime=?");
			values.add(hdfsfile.getUploadtime());
		}
		
			sb.append(" where fileId=?");
			values.add(hdfsfile.getFileId());
		sb.deleteCharAt(sb.indexOf(","));
		String sql=sb.toString();
		rs=DBUtil1.executeUpdate(conn, sql, values);
		DBUtil1.closeConn(conn);

		}
		return rs;
	}

	@Override
	public int insert(List<HDFSFile> hdfsFiles) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil1.getConn();
		StringBuffer sb=new StringBuffer("insert into hdfs(fileName,size,uploadtime,parentId,isDir) values");
		List<Object> values=new ArrayList<>();
		for (int i = 0; i < hdfsFiles.size(); i++) {
			sb.append("(?,?,?,?,?),");
			values.add(hdfsFiles.get(i).getFileName());
			values.add(hdfsFiles.get(i).getSize());
			values.add(hdfsFiles.get(i).getUploadtime());
			values.add(hdfsFiles.get(i).getParentId());
			values.add(hdfsFiles.get(i).isDir()==false?0:1);
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		String sql=sb.toString();
		int rs=DBUtil1.executeUpdate(conn, sql, values);
		DBUtil1.closeConn(conn);
		return rs;
	}

	@Override
	public int delete(int hdfsId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil1.getConn();
		String sql="delete from hdfs where fileId=?";
		List<Object> values=new ArrayList<>();
		values.add(hdfsId);
		int rs=DBUtil1.executeUpdate(conn, sql, values);
		DBUtil1.closeConn(conn);
		return rs;
	}

	@Override
	public List<HDFSFile> selectAll(Integer parentId,int rows,int cols) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil1.getConn();
		String sql="select * from hdfs where parentId=? order by fileId desc limit ?,?";
		List<Object> values=new ArrayList<>();
		List<HDFSFile> files=new ArrayList<>();
		
		values.add(parentId);
		values.add(rows);
		values.add(cols);
		ResultSet rs=DBUtil1.executeQuery(conn, sql, values);
		try {
			while (rs.next()) {
				String name=rs.getString(2);
				boolean isdir=rs.getInt(6)==0?false:true;
				HDFSFile hdfsFile=new HDFSFile(rs.getInt(1),name.substring(name.lastIndexOf("/")+1) , rs.getFloat(3), rs.getDate(4),rs.getInt(5),isdir);
				files.add(hdfsFile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil1.closeConn(conn);
		return files;
	}
	@Override
	public int getCount(Integer parentId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil1.getConn();
		String sql="select count(*) from hdfs where parentId=?";
		List<Object> values=new ArrayList<>();
		
		values.add(parentId);
		ResultSet rs=DBUtil1.executeQuery(conn, sql, values);
		int result=0;
		try {
			if (rs.next()) {
//				rs.next();
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil1.closeConn(conn);
		return result;
	}

	@Override
	public List<HDFSFile> select(HDFSFile hdfsFile,int rows,int cols) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil1.getConn();
		List<HDFSFile> list=new ArrayList<HDFSFile>();
		List<Object> list2= new ArrayList<>();
		StringBuffer sb= new StringBuffer("select * from hdfs where ");
		if (hdfsFile.getSize()>0) {
			sb.append("and size=?");
			list2.add(hdfsFile.getSize());
		}
		if (hdfsFile.getFileId()>0) {
			sb.append("and fileId=?");
			list2.add(hdfsFile.getFileId());
		}
		if (hdfsFile.getFileName()!=null ) {
			sb.append(" and fileName=?");
			list2.add(hdfsFile.getFileName());
		}
		if (hdfsFile.getUploadtime()!=null) {
			sb.append("and uploadtime=?");
			list2.add(hdfsFile.getUploadtime());
		}
		if (hdfsFile.getParentId()!=null) {
			sb.append("and parentId=?");
			list2.add(hdfsFile.getParentId());
		}
		sb.delete(sb.indexOf("and"),sb.indexOf("and")+3);
		sb.append("order by fileId desc limit ?,?");
		list2.add(rows);
		list2.add(cols);
		String sql=sb.toString();
		ResultSet rs=DBUtil1.executeQuery(conn, sql, list2);
		try {
			while(rs.next()){
				boolean isDir=rs.getInt(6)==0?false:true;
				HDFSFile a=new HDFSFile(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDate(4),rs.getInt(5),isDir);
			list.add(a);			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil1.closeConn(conn);
		}
		return list;
	}

	@Override
	public List<HDFSFile> select(HDFSFile hdfsFile) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil1.getConn();
		List<HDFSFile> list=new ArrayList<HDFSFile>();
		List<Object> list2= new ArrayList<>();
		StringBuffer sb= new StringBuffer("select * from hdfs where ");
		if (hdfsFile.getSize()>0) {
			sb.append("and size=?");
			list2.add(hdfsFile.getSize());
		}
		if (hdfsFile.getFileId()>0) {
			sb.append("and fileId=?");
			list2.add(hdfsFile.getFileId());
		}
		if (hdfsFile.getFileName()!=null ) {
			sb.append(" and fileName=?");
			list2.add(hdfsFile.getFileName());
		}
		if (hdfsFile.getUploadtime()!=null) {
			sb.append("and uploadtime=?");
			list2.add(hdfsFile.getUploadtime());
		}
		if (hdfsFile.getParentId()!=null) {
			sb.append("and parentId=?");
			list2.add(hdfsFile.getParentId());
		}
		sb.delete(sb.indexOf("and"),sb.indexOf("and")+3);
		String sql=sb.toString();
		ResultSet rs=DBUtil1.executeQuery(conn, sql, list2);
		try {
			while(rs.next()){
				boolean isDir=rs.getInt(6)==0?false:true;
				HDFSFile a=new HDFSFile(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDate(4),rs.getInt(5),isDir);
			list.add(a);			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil1.closeConn(conn);
		}
		return list;
	}
	}
	
