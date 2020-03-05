package com.icss.Snack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.icss.Snack.entity.CommodityParam;
import com.icss.Snack.util.DBFactory;

public class CommodityParamDao {

	public int addParam(CommodityParam param) throws Exception{
		int row = 0;
		Connection connection = DBFactory.openConnection();
		String sql = "insert into tb_commodity_param(type,product_area,product_place,product_specification,expiration_date,use_method,storage_method,standard_number,license_number) value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, param.getType());
		ps.setString(2, param.getProduct_area());
		ps.setString(3,param.getProduct_place());
		ps.setString(4, param.getProduct_specification());
		ps.setString(5, param.getExpiration_date());
		ps.setString(6, param.getUsage());
		ps.setString(7, param.getStorage_method());
		ps.setString(8, param.getStandard_number());
		ps.setString(9,param.getLicense_number());
		row = ps.executeUpdate();
		ps.close();
		
		return row;
	}
	public int deleteParam(int param_id) throws Exception {
		int row = 0;
		Connection connection = DBFactory.openConnection();
		String sql = "delete from tb_commodity_param where param_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,param_id);
		row = ps.executeUpdate();
		ps.close();
		
		return row;		
	}
	public int updateParam(CommodityParam param) throws Exception{
		int row = 0;
		Connection connection = DBFactory.openConnection();
		String sql = "update tb_commodity_param set type=?,product_area=?,product_place=?,product_specification=?,expiration_date=?,use_method=?,storage_method=?,standard_number=?,license_number=? where param_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, param.getType());
		ps.setString(2, param.getProduct_area());
		ps.setString(3,param.getProduct_place());
		ps.setString(4, param.getProduct_specification());
		ps.setString(5, param.getExpiration_date());
		ps.setString(6, param.getUsage());
		ps.setString(7, param.getStorage_method());
		ps.setString(8, param.getStandard_number());
		ps.setString(9,param.getLicense_number());
		ps.setInt(10, param.getParam_id());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	public CommodityParam findParamById(int param_id) throws Exception{
		CommodityParam param = null;
		
		Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_commodity_param where param_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,param_id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			param = new CommodityParam();
			param.setType(rs.getString("type"));
			param.setProduct_area(rs.getString("product_area"));
			param.setProduct_place(rs.getString("product_place"));
			param.setProduct_specification(rs.getString("product_specification"));
			param.setExpiration_date(rs.getString("expiration_date"));
			param.setUsage(rs.getString("usage"));
			param.setStorage_method(rs.getString("storage_method"));
			param.setStandard_number(rs.getString("standard_number"));
			param.setLicense_number(rs.getString("license_number"));
		}
		rs.close();
		ps.close();
		return param;
	}
	public CommodityParam findCommodityParamById(int id) throws Exception{
		CommodityParam commodityparam = null;
		
		Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_commodity_param where param_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			commodityparam = new CommodityParam();
			commodityparam.setType(rs.getString("type"));
			commodityparam.setProduct_area(rs.getString("product_area"));
			commodityparam.setProduct_place(rs.getString("product_place"));
			commodityparam.setProduct_specification(rs.getString("product_specification"));
			commodityparam.setExpiration_date(rs.getString("expiration_date"));
			commodityparam.setUsage(rs.getString("usage"));
			commodityparam.setStorage_method(rs.getString("storage_method"));
			commodityparam.setStandard_number(rs.getString("standard_number"));
			commodityparam.setLicense_number(rs.getString("license_number"));
		}
		rs.close();
		ps.close();
		return commodityparam;
	}
	public List<CommodityParam> findAllParamList() throws Exception{
		List<CommodityParam> paramList = new ArrayList<CommodityParam>();
		Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_commodity_param";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CommodityParam param = new CommodityParam();
			param.setType(rs.getString("type"));
			param.setProduct_area(rs.getString("product_area"));
			param.setProduct_place(rs.getString("product_place"));
			param.setProduct_specification(rs.getString("product_specification"));
			param.setExpiration_date(rs.getString("expiration_date"));
			param.setUsage(rs.getString("usage"));
			param.setStorage_method(rs.getString("storage_method"));
			param.setStandard_number(rs.getString("standard_number"));
			param.setLicense_number(rs.getString("license_number"));
			paramList.add(param);
		}
		rs.close();
		ps.close();
		
		return paramList;
	}
	public int findParamCount() throws Exception{
		int count = 0 ;
		Connection connection = DBFactory.openConnection();
		String sql = "select count(*) from tb_commodity_param";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		
		return count;
	}
	
	
	public static void main(String[] args) throws Exception {
		CommodityParamDao paramDao = new CommodityParamDao();
		CommodityParam param = new CommodityParam();
		int param_id = 2;
		param = paramDao.findParamById(param_id);
		System.out.println(param.getType());
		System.out.println(param.getProduct_area());
	}
}
















