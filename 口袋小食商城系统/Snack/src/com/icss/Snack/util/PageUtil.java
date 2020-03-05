package com.icss.Snack.util;

import java.util.List;
/**
 * @author whn
 * 分页工具类
 */
public class PageUtil<T> {
	
	private int currentPage;//当前页码
	private int totalPage;//总页数 ：总记录数%每页显示==0?总记录数/每页显示:总记录数/每页显示+1
	private int count;//总记录数
	private List<T> list;//数据集合
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
