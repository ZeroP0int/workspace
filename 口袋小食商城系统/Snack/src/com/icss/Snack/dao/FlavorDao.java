package com.icss.Snack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Flavor;
import com.icss.Snack.util.DBFactory;

public class FlavorDao {

	public int addFlavor(Flavor flavor) throws Exception{
		int row = 0;
		Connection connection = DBFactory.openConnection();
		String sql = "insert into tb_flavor(fname) values(?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, flavor.getFname());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	public int updateFlavor(Flavor flavor) throws Exception{
		int row = 0;
		Connection connection = DBFactory.openConnection();
		String sql = "update tb_flavor set fname=? where fid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, flavor.getFname());
		ps.setInt(2, flavor.getFid());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	public int deleteFlavor(int fid) throws Exception{
		int row = 0;
		Connection connection = DBFactory.openConnection();
		String sql = "delete from tb_flavor where fid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, fid);
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	public List<Flavor> findFlavorById(int commodity_id){
		
		List<Flavor> flavorList = new ArrayList<Flavor>();
		try {
		Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_flavor_commodity,tb_flavor where tb_flavor_commodity.fid = tb_flavor.fid and commodity_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, commodity_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			Flavor flavor = new Flavor();
			flavor.setFid(rs.getInt("fid"));
			flavor.setCommodity_id(rs.getInt("commodity_id"));
			flavor.setFname(rs.getString("fname"));
			flavor.setStock(rs.getInt("stock"));
			flavorList.add(flavor);
		}
		rs.close();
		ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flavorList;
	}
	
	public List<Flavor> findAllFlavorList() throws Exception{
		List<Flavor> flavorList = new ArrayList<Flavor>();
		Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_flavor";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Flavor flavor = new Flavor();
			flavor.setFname(rs.getString("fname"));
			flavorList.add(flavor);
		}
		rs.close();
		ps.close();
		return flavorList;
	}
	public int findFlavorCount() throws Exception{
		int count = 0;
		Connection connection = DBFactory.openConnection();
		String sql = "select count(*) from tb_flavor";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		return count;
	}
}
