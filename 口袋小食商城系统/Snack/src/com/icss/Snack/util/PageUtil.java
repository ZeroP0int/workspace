package com.icss.Snack.util;

import java.util.List;
/**
 * @author whn
 * ��ҳ������
 */
public class PageUtil<T> {
	
	private int currentPage;//��ǰҳ��
	private int totalPage;//��ҳ�� ���ܼ�¼��%ÿҳ��ʾ==0?�ܼ�¼��/ÿҳ��ʾ:�ܼ�¼��/ÿҳ��ʾ+1
	private int count;//�ܼ�¼��
	private List<T> list;//���ݼ���
	
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
