package com.icss.Snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Orders_detail;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

public class OrdersDetailDao {
	public int addOrdersDetail(Orders_detail odd) throws Exception{
		int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "insert into tb_orders_detail(commodity_id,quantity,price,fid,brand_id,oid) values(?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
	    ps.setInt(1,odd.getCommodity_id());
		ps.setInt(2,odd.getQuantity());
		ps.setDouble(3,odd.getPrice());
		ps.setInt(4,odd.getFid());
		ps.setInt(5,odd.getBrand_id());
		ps.setString(6,odd.getOid());
		
		row = ps.executeUpdate();
		ps.close();
		return row;
		
	}
	
    public int updateOrdersDetail(Orders_detail odd) throws Exception{
    	int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "update tb_orders_detail set detail_id=?,commodity_id=?,quantity=?,price=?,fid=?,brand_id=?,oid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,odd.getDetail_id());
	    ps.setInt(2,odd.getCommodity_id());
		ps.setInt(3,odd.getQuantity());
		ps.setDouble(4, odd.getPrice());
		ps.setInt(5,odd.getFid());
		ps.setInt(6, odd.getBrand_id());
		ps.setString(7, odd.getOid());
		row = ps.executeUpdate();
		ps.close();
		return row;
    	}
    public int deleteOrdersDetail(int oid) throws Exception {
    	int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "delete from tb_orders_detail where oid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, oid);
		row = ps.executeUpdate();
		ps.close();
		return row;
    }
 
    public Orders_detail findOddByOid(int oid)throws Exception{
    			Orders_detail odd= null;
    			java.sql.Connection connection = DBFactory.openConnection();
    			String sql = "select * from tb_orders_detail where oid=?";
    			PreparedStatement ps = connection.prepareStatement(sql);
    			ps.setInt(1, oid);
    			ResultSet rs = ps.executeQuery();
    			if(rs.next()) {
    				odd=new Orders_detail();
    				odd.setBrand_id(rs.getInt("brand_id"));
    				odd.setCommodity_id(rs.getInt("commodity_id"));
    				odd.setOid(rs.getString("oid"));
    				odd.setDetail_id(rs.getInt("detail_id"));
    				odd.setFid(rs.getInt("fid"));
    				odd.setQuantity(rs.getInt("quantity"));
    				odd.setPrice(rs.getDouble("price"));
    			}
    			rs.close();
    			ps.close();
    			return odd;
     }
    public List<Orders_detail> findAllOrders_detailList() throws Exception{
    	List<Orders_detail> oddList = new ArrayList<Orders_detail>();
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "select * from tb_orders_detail";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Orders_detail odd=new Orders_detail();
			odd=new Orders_detail();
			odd.setBrand_id(rs.getInt("brand_id"));
			odd.setCommodity_id(rs.getInt("commodity_id"));
			odd.setOid(rs.getString("oid"));
			odd.setDetail_id(rs.getInt("detail_id"));
			odd.setFid(rs.getInt("fid"));
			odd.setQuantity(rs.getInt("quantity"));
			odd.setPrice(rs.getDouble("price"));
			oddList.add(odd);
		}
		rs.close();
		ps.close();
    	return oddList;
    }
    public int findUserCount() throws Exception{
    	int count = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "select count(*) from tb_orders_detail";
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
		
    OrdersDetailDao oddDao = new OrdersDetailDao();
    List<Orders_detail> oddList = oddDao.findAllOrders_detailList();
    System.out.println(oddList.size());    
    
   }
}
