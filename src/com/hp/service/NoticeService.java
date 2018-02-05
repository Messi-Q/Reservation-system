package com.hp.service;

import java.util.ArrayList;

import com.hp.entity.Notice;


public interface NoticeService {
	public int addNotice(Notice notice);
	public int deleteNotice(int noticeId);
	public int updateNotice(Notice notice);
	
	public ArrayList<Notice> findAll() ;
	
	public ArrayList<Notice> findOneRow(int noticeId) ;
	
	public ArrayList<Notice> findSelectOne(int noticeId) ;
	
	public ArrayList<Notice> findLastThree() ;
	
}
