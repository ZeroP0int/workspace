package com.icss.Snack.entity;

import java.util.List;

public class Category {
	private int category_id;//�����ţ��������Զ�����
	private int category_parentid;//�������
	private String name;//�������
	private List<Category> subCategoryList;//�����������Ĺ�ϵ һ�Զ�
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getCategory_parentid() {
		return category_parentid;
	}
	public void setCategory_parentid(int category_parentid) {
		this.category_parentid = category_parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Category> getSubCategoryList() {
		return subCategoryList;
	}
	public void setSubCategoryList(List<Category> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
	

}
