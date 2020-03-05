package com.icss.Snack.entity;

import java.util.List;

public class Category {
	private int category_id;//分类编号，主键，自动增长
	private int category_parentid;//父级编号
	private String name;//类别名称
	private List<Category> subCategoryList;//父类别和子类别的关系 一对多
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
