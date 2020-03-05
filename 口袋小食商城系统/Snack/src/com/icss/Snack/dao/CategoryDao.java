package com.icss.Snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.icss.Snack.entity.Category;
import com.icss.Snack.util.DBFactory;

public class CategoryDao {
	public int addCategory(Category category) throws Exception{
		int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "update tb_category set category_parentid=?,name=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, category.getCategory_parentid());
		ps.setString(2, category.getName());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public int updateCategory(Category category) throws Exception{
		int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "update tb_category set category_id=?,category_parentid=?,name=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, category.getCategory_id());
		ps.setInt(2, category.getCategory_parentid());
		ps.setString(3, category.getName());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public int deleteCategory(int category_id)throws Exception{
		int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "delete from tb_category where category_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,category_id);
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public Category findCategoryById(int category_id)throws Exception{
		Category category = null;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_category where category_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,category_id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_parentid(rs.getInt("category_parentid"));
			category.setName(rs.getString("name"));
		}
		rs.close();
		ps.close();
		return category;
	}
	public List<Category> findAllCategoryList() throws Exception{
		List<Category> categoryList = new ArrayList<Category>();
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_category";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Category category = new Category();
			category.setCategory_id(rs.getInt("category_id"));
			category.setCategory_parentid(rs.getInt("category_parentid"));
			category.setName(rs.getString("name"));
		}
		rs.close();
		ps.close();
		return categoryList;
	}
	public int findCategoryCount() throws Exception{
		int count = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "select count(*) from tb_category";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		return count;
	}
	public static void main(String[] args) throws Exception{
		CategoryDao categoryDao = new CategoryDao();
		List<Category> categoryList = categoryDao.findAllCategoryList();
		System.out.println(categoryList.size());
	}
}