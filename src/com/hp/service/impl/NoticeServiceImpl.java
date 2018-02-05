package com.hp.service.impl;

import java.util.ArrayList;

import com.hp.dao.NoticeDao;
import com.hp.dao.impl.NoticeDaoImpl;
import com.hp.entity.Notice;
import com.hp.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDao noticeDao = new NoticeDaoImpl(); 
	@Override
	public int addNotice(Notice notice) {
		return noticeDao.addNotice(notice);
	}

	@Override
	public int deleteNotice(int noticeId) {
		return this.noticeDao.deleteNotice(noticeId);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeDao.updateNotice(notice);
	}

	@Override
	public ArrayList<Notice> findAll() {
		return noticeDao.findAll();
	}

	@Override
	public ArrayList<Notice> findOneRow(int noticeId) {
		return noticeDao.findOneRow(noticeId);
	}
	
	public ArrayList<Notice> findSelectOne(int noticeId) {
		return noticeDao.findSelectOne(noticeId);
	}
	
	public ArrayList<Notice> findLastThree() {
		return noticeDao.findLastThree();
	}

	
}
