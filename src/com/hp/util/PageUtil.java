package com.hp.util;


public class PageUtil {
	//用于页面显示的第一个页面地址
	private  int firstIndex;
	//用于页面显示的第二个页面地址
	private  int endIndex;
	//总的查找条数
	private  int totalCount;
	//总的页面
	private  int totalPage;
	//每页显示多少条数据
	private  int everyPageCount;
	
	
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	//主要用于实例totalPage totalCount everyPageCount
	public PageUtil(int totalCount, int everyPageCount) {
		super();
		this.totalCount = totalCount;
		//防止出现6/3=2但是再加一页就3页原本只有两页但是现在却有三页所以要判断。
		this.totalPage=totalCount%everyPageCount==0?totalCount/everyPageCount:(totalCount/everyPageCount+1);
		this.everyPageCount = everyPageCount;
	}
	public int getEveryPageCount() {
		return everyPageCount;
	}
	public void setEveryPageCount(int everyPageCount) {
		this.everyPageCount = everyPageCount>0?everyPageCount:1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex>0?firstIndex:1;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex>totalPage?totalPage:1;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void getPageView(int nowPage,int viewPage,int totalCount) {
		if ((nowPage-viewPage/2)>0) {
			firstIndex=nowPage-viewPage/2;
			endIndex=firstIndex+viewPage;
			if (endIndex>totalPage) {
				endIndex=totalPage;
				firstIndex=(endIndex-viewPage)>0?endIndex-viewPage:1;
			}
		}else {
			firstIndex=1;
			endIndex=firstIndex+viewPage;
			if (endIndex>totalPage) {
				endIndex=totalPage;
			}
		}
	}
}
