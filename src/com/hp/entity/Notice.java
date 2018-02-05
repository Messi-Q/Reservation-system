package com.hp.entity;

public class Notice {
	private int noticeId;
	private String noticeTitle;
	private String noticeTime;
	private String noticeCont;
	
	public Notice(){}
	
	public Notice(int noticeId) {
		super();
		this.noticeId=noticeId;
	}
	
	public Notice(String noticeTitle) {
		super();
		this.noticeTitle=noticeTitle;
	}
	
	public Notice(String noticeTitle,String noticeCont) {
		super();
		this.noticeTitle=noticeTitle;
		this.noticeCont=noticeCont;
	}	
	
	public Notice( String noticeTitle,String noticeCont,int noticeId) {
		super();	
		this.noticeTitle=noticeTitle;
		this.noticeCont=noticeCont;
		this.noticeId=noticeId;
		
	}
	public Notice(int noticeId, String noticeTitle,String noticeTime,String noticeCont) {
		super();
		this.noticeId=noticeId;
		this.noticeTitle=noticeTitle;
		this.noticeTime=noticeTime;
		this.noticeCont=noticeCont;
		
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}
	
	
	public String getNoticeCont() {
		return noticeCont;
	}
	public void setNoticeCont(String noticeCont) {
		this.noticeCont = noticeCont;
	}
}
