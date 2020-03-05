package com.icss.Snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Commodity;
import com.icss.Snack.util.DBFactory;
import com.mysql.jdbc.Connection;

public class CommodityDao {
	public int addCategory(Commodity commodity) throws Exception{
		int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "insert into tb_commodity(commodity_id,category_id,brand_id,cname,promotional_price,original_price,description,img,createtime) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, commodity.getCommodity_id());
		ps.setInt(2, commodity.getCategory_parentid());
		ps.setInt(3, commodity.getBrand_id());
		ps.setString(4, commodity.getCname());
		ps.setDouble(5, commodity.getPromotional_price());
		ps.setDouble(6, commodity.getOriginal_price());
		ps.setString(7, commodity.getDescription());
		ps.setString(8, commodity.getImg());
		ps.setTimestamp(9, commodity.getDatetime());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public int updateCommodity(Commodity commodity) throws Exception{
		int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "insert into tb_commodity(commodity_id,category_id,brand_id,cname,promotional_price,original_price,description,img,createtime) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, commodity.getCommodity_id());
		ps.setInt(2, commodity.getCategory_parentid());
		ps.setInt(3, commodity.getBrand_id());
		ps.setString(4, commodity.getCname());
		ps.setDouble(5, commodity.getPromotional_price());
		ps.setDouble(6, commodity.getOriginal_price());
		ps.setString(7, commodity.getDescription());
		ps.setString(8, commodity.getImg());
		ps.setTimestamp(9, commodity.getDatetime());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public int deleteCommodity(int commodity_id)throws Exception{
		int row = 0;
		java.sql.Connection connection = DBFactory.openConnection();
		String sql = "delete from tb_category where commodity_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,commodity_id);
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	public Commodity findCommodityByUid(int commodity_id)throws Exception{
		Commodity commodity = null;
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "SELECT c.*, b. NAME brand_name,	ca. NAME category_name FROM tb_commodity c "
		 		+"INNER JOIN tb_brand b ON b.brand_id = c.brand_id "
		 		+"INNER JOIN tb_category ca ON ca.category_id = c.category_id where commodity_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, commodity_id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	commodity=new Commodity();
        	commodity.setCommodity_id(rs.getInt("commodity_id"));
        	commodity.setCategory_parentid(rs.getInt("category_id"));
        	commodity.setBrand_id(rs.getInt("brand_id"));
        	commodity.setCname(rs.getString("cname"));
        	commodity.setPromotional_price(rs.getDouble("promotional_price"));
        	commodity.setOriginal_price(rs.getDouble("original_price"));
        	commodity.setDescription(rs.getString("description"));
        	commodity.setImg(rs.getString("img"));
        	commodity.setParam_id(rs.getInt("param_id"));
        	commodity.setDatetime(rs.getTimestamp("createtime"));
            
        }
        rs.close();
        ps.close();
        return commodity;
	}
	
	//用于后台分页展示
	 public List<Commodity> findAllCommodityByPage(int currentPage,int pageSize) throws Exception{
	        List<Commodity> commodityList = new ArrayList<Commodity>();
	        java.sql.Connection connection = DBFactory.openConnection();
	        String sql = "SELECT c.*, b. NAME brand_name,	ca. NAME category_name FROM tb_commodity c "
			 		+"INNER JOIN tb_brand b ON b.brand_id = c.brand_id "
			 		+"INNER JOIN tb_category ca ON ca.category_id = c.category_id limit ?,?";
	        PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*pageSize);
	        ps.setInt(2,pageSize);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	Commodity commodity=new Commodity();
	        	commodity=new Commodity();
	        	commodity.setCommodity_id(rs.getInt("commodity_id"));
	        	commodity.setCategory_parentid(rs.getInt("category_id"));
	        	commodity.setBrand_id(rs.getInt("brand_id"));
	        	commodity.setCname(rs.getString("cname"));
	        	commodity.setPromotional_price(rs.getDouble("promotional_price"));
	        	commodity.setOriginal_price(rs.getDouble("original_price"));
	        	commodity.setDescription(rs.getString("description"));
	        	commodity.setImg(rs.getString("img"));
	        	commodity.setDatetime(rs.getTimestamp("createtime"));
	        	commodity.setBrand_name(rs.getString("brand_name"));
	        	commodity.setCategory_name(rs.getString("category_name"));
	        	commodityList.add(commodity);
	        }
	        rs.close();
	        ps.close();
	        return commodityList;
	    }
	 
	 public int findAllCommodityCount() throws Exception{
		 int count=0;
		 java.sql.Connection connection = DBFactory.openConnection();
		 String sql="Select count(*) from tb_commodity";
		 PreparedStatement ps = connection.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()) {
			 count=rs.getInt(1);
		 }
		 rs.close();
	     ps.close();
		return count;
	 }
	
    public List<Commodity> findAllCommodityList() throws Exception{
        List<Commodity> commodityList = new ArrayList<Commodity>();
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "select * from tb_commodity";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	Commodity commodity=new Commodity();
        	commodity=new Commodity();
        	commodity.setCommodity_id(rs.getInt("commodity_id"));
        	commodity.setCategory_parentid(rs.getInt("category_id"));
        	commodity.setBrand_id(rs.getInt("brand_id"));
        	commodity.setCname(rs.getString("cname"));
        	commodity.setPromotional_price(rs.getDouble("promotional_price"));
        	commodity.setOriginal_price(rs.getDouble("original_price"));
        	commodity.setDescription(rs.getString("description"));
        	commodity.setImg(rs.getString("img"));
        	commodity.setDatetime(rs.getTimestamp("createtime"));
        	commodityList.add(commodity);
        }
        rs.close();
        ps.close();
        return commodityList;
    }
    //最新商品查询
    public List<Commodity> findLatestCommodityList() throws Exception{
        List<Commodity> commodityList = new ArrayList<Commodity>();
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "select * from tb_commodity ORDER BY createtime DESC LIMIT 0,12";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	Commodity commodity=new Commodity();
        	commodity=new Commodity();
        	commodity.setCommodity_id(rs.getInt("commodity_id"));
        	commodity.setCategory_parentid(rs.getInt("category_id"));
        	commodity.setBrand_id(rs.getInt("brand_id"));
        	commodity.setCname(rs.getString("cname"));
        	commodity.setPromotional_price(rs.getDouble("promotional_price"));
        	commodity.setOriginal_price(rs.getDouble("original_price"));
        	commodity.setDescription(rs.getString("description"));
        	commodity.setImg(rs.getString("img"));
        	commodity.setDatetime(rs.getTimestamp("createtime"));
        	commodityList.add(commodity);
        }
        rs.close();
        ps.close();
        return commodityList;
    }
    
    
    public int findCommodityCount() throws Exception{
        int count = 0;
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "select count(*) from tb_commodity";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            count = rs.getInt(1);
        }
        rs.close();
        ps.close();
        return count;
    }
 
    public int deleteCommodityById(int id) throws Exception{
        int row = 0;
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "delete from tb_commodity where commodity_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
       ps.setInt(1, id);
       row=ps.executeUpdate();
       
        ps.close();
        return row;
    }
    public Commodity findCommodityByCartid(int cart_id)throws Exception{
		Commodity commodity = null;
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "select cart.quantity,cart.commodity_id,cart.fid,c.brand_id,c.promotional_price"
		 		+" FROM tb_cart cart"
		 		+" INNER JOIN tb_commodity c on c.commodity_id=cart.commodity_id"
		 		+" where cart.cart_id=?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cart_id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	commodity=new Commodity();
        	commodity.setCommodity_id(rs.getInt("commodity_id"));
           	commodity.setBrand_id(rs.getInt("brand_id"));
        	commodity.setPromotional_price(rs.getDouble("promotional_price"));
        	commodity.setQuantity(rs.getInt("quantity"));
        	commodity.setFid(rs.getInt("fid"));
        	
        }
        rs.close();
        ps.close();
        return commodity;
	}
    
    //用于直接付款
    public Commodity findCommodityByCid(int commodity_id)throws Exception{
		Commodity commodity = null;
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "select cart.quantity,cart.commodity_id,cart.fid,c.brand_id,c.promotional_price"
		 		+" FROM tb_cart cart"
		 		+" INNER JOIN tb_commodity c on c.commodity_id=cart.commodity_id"
		 		+" where c.commodity_id=?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, commodity_id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	commodity=new Commodity();
        	commodity.setCommodity_id(rs.getInt("commodity_id"));
           	commodity.setBrand_id(rs.getInt("brand_id"));
        	commodity.setPromotional_price(rs.getDouble("promotional_price"));
        	commodity.setQuantity(rs.getInt("quantity"));
        	commodity.setFid(rs.getInt("fid"));
        	
        }
        rs.close();
        ps.close();
        return commodity;
	}
    
    public Commodity findCommoditytoPay(int commodity_id)throws Exception{
		Commodity commodity = null;
        java.sql.Connection connection = DBFactory.openConnection();
        String sql = "SELECT cname,img,promotional_price from tb_commodity where commodity_id=?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, commodity_id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	commodity=new Commodity();
        	commodity.setCommodity_id(rs.getInt("commodity_id"));
           	commodity.setCname(rs.getString("cname"));
        	commodity.setPromotional_price(rs.getDouble("promotional_price"));
        	commodity.setImg(rs.getString("img"));
        	
        	
        }
        rs.close();
        ps.close();
        return commodity;
	}
}