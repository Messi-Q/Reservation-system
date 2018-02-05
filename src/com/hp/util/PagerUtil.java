package com.hp.util;
import java.util.*;
/**
 * 分页Bean
 * @author Cc.liu
 *
 */
public class PagerUtil {

	/** 当前页码数 */
	private int currentPage = 1;

	/** 每页显示记录条数, 默认为 2 */
	private int sizePerPage = 2;

	/** 总页数 */
	private int totalPage;

	/** 需要分页的长字符串 */
	@SuppressWarnings("unchecked")
	private List topicSelect;

	public PagerUtil() {
	}

	/**
	 * 返回当前页的文本
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getCurrentPagedText() {
		try {
			if (getCurrentPage() < getTotalPage()) {
				return getTopicSelect().subList(
						(getCurrentPage() - 1) * getSizePerPage(),getCurrentPage() * getSizePerPage());
			} else if (getTotalPage() > 0) {
				return getTopicSelect().subList((getCurrentPage() - 1) * getSizePerPage(),getTopicSelect().size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return Returns the 当前页码数.
	 */
	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		return currentPage;
	}

	/**
	 * 设置当前页码, 从 1 开始.
	 * 
	 * @param currentPage
	 *            The 当前页码数 to set.
	 */
	public void setCurrentPage(int currentPage) {
		if (currentPage <= 0) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}

	/**
	 * @return Returns the 总页码数, 如果没有数据, 就返回 1.
	 */
	public int getTotalPage() {
		if (getTopicSelect() == null)
			totalPage = 0;
		totalPage = (int) Math.ceil(1.0 * getTopicSelect().size()
				/ getSizePerPage()); // 总页面数

		if (totalPage == 0)
			totalPage = 1;
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            The totalPage to set.
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return Returns the 每页显示行数.
	 */
	public int getSizePerPage() {
		return sizePerPage;
	}

	/**
	 * @param sizePerPage
	 *            The 每页显示行数to set.
	 */
	public void setSizePerPage(int sizePerPage) {
		this.sizePerPage = sizePerPage;
	}

	/**
	 * @return Returns the 需要分页的文本.
	 */
	@SuppressWarnings("unchecked")
	public List getTopicSelect() {
		return topicSelect;
	}

	@SuppressWarnings("unchecked")
	public void setTopicSelect(List topicSelect) {
		this.topicSelect = topicSelect;
	}
}
