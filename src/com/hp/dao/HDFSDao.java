package com.hp.dao;

import java.util.List;

import com.hp.entity.HDFSFile;

public interface HDFSDao {
	public int update(HDFSFile hdfsfile);
	public int  insert(List<HDFSFile> hdfsFiles);
	public int delete(int hdfsId);
	public int getCount(Integer parentId);
	public List<HDFSFile> select(HDFSFile hdfsFile,int rows,int cols);
	public List<HDFSFile> select(HDFSFile hdfsFile);
	public List<HDFSFile> selectAll(Integer parentId,int rows,int cols);
}	
