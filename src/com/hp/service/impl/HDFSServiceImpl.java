package com.hp.service.impl;

import java.util.List;
import com.hp.entity.HDFSFile;
import com.hp.dao.HDFSDao;
import com.hp.dao.impl.HDFSDaoImpl;
import com.hp.service.HDFSService;

public class HDFSServiceImpl implements HDFSService {
	HDFSDao hdfsdao=new HDFSDaoImpl();

	@Override
	public int update(HDFSFile hdfsfile) {
		// TODO Auto-generated method stub
		return hdfsdao.update(hdfsfile);
	}

	@Override
	public int insert(List<HDFSFile> hdfsFiles) {
		// TODO Auto-generated method stub
		return hdfsdao.insert(hdfsFiles);
	}

	@Override
	public int delete(int hdfsId) {
		// TODO Auto-generated method stub
		return hdfsdao.delete(hdfsId);
	}

	@Override
	public int getCount(Integer parentId) {
		// TODO Auto-generated method stub
		return hdfsdao.getCount(parentId);
	}

	@Override
	public List<HDFSFile> select(HDFSFile hdfsFile, int rows, int cols) {
		// TODO Auto-generated method stub
		return hdfsdao.select(hdfsFile, rows, cols);
	}

	@Override
	public List<HDFSFile> selectAll(Integer parentId, int rows, int cols) {
		// TODO Auto-generated method stub
		return hdfsdao.selectAll(parentId, rows, cols);
	}

	@Override
	public List<HDFSFile> select(HDFSFile hdfsFile) {
		// TODO Auto-generated method stub
		return hdfsdao.select(hdfsFile);
	}
	
}
