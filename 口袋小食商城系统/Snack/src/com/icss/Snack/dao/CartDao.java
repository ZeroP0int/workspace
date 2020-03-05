 package com.icss.Snack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.CartVo;
import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

public class CartDao {
	//增
		public  int Add(Cart cart) throws Exception{
			int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "insert into tb_cart(cart_id,uid,quantity,commodity_id,fid) values(?,?,?,?,?)";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1,cart.getCart_id());
			ps.setInt(2,cart.getUid());
			ps.setInt(3,cart.getQuantity());
			ps.setInt(4,cart.getCommodity_id());
			ps.setInt(5,cart.getFid());
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
			
		}
		
		//改
	    public int updateCart(Cart cart) throws Exception{
	    	int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "update tb_cart set cart_id=?,uid=?,quantity=?,commodity_id=?,fid=?";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1,cart.getCart_id());
			ps.setInt(2,cart.getUid());
			ps.setInt(3,cart.getQuantity());
			ps.setInt(4,cart.getCommodity_id());
			ps.setInt(5,cart.getFid());
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
	    	}
	    
	    //删
	    public int deleteCart(String cartIds) throws Exception {
	    	int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "delete from tb_cart where cart_id in("+cartIds+")";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
	    }
	    

	    
	    //删除购物车
	    public int delCart(int cart_id) throws Exception {
	    	int row = 0;
	    
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "delete from tb_cart where cart_id=?";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1,cart_id);
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
	    }
	    
	    //清空购物车
	    public int delAllCart() throws Exception {
	    	int row = 0;
	    
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "delete from tb_cart";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);

			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
	    }

	    /*
	     * 查询用户详情
	     */
	    public Cart findCartBycarid(int cart_id)throws Exception{
	    	        Cart cart = null;
	    	       //1.连接数据库
	    			java.sql.Connection connection = DBFactory.openConnection();
	    			//编写sql语句
	    			String sql = "select * from tb_cart where cart_id=?";
	    			//创建执行sql的对象
	    			PreparedStatement ps = connection.prepareStatement(sql);
	    			//设置占位符的值
	    			ps.setInt(1, cart_id);
	    			//执行sql返回结果集
	    			ResultSet rs = ps.executeQuery();
	    			if(rs.next()) {
	    				cart=new Cart();
	    				cart.setCart_id(rs.getInt("cart_id"));
	    				cart.setUid(rs.getInt("uid"));
	    				cart.setQuantity(rs.getInt("quantity"));
	    				cart.setCommodity_id(rs.getInt("commodity_id"));
	    				cart.setFid(rs.getInt("fid"));
	    				
	    			}
	    			rs.close();
	    			ps.close();
	    			return cart;
	     }
	    //查询有多少种类
	    public List<Cart> findAllCartList() throws Exception{
	    	List<Cart> cartList = new ArrayList<Cart>();
	    	 //1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "select * from tb_cart";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ResultSet rs = ps.executeQuery();
			 
			while(rs.next()) {
				Cart cart=new Cart();
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setUid(rs.getInt("uid"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setCommodity_id(rs.getInt("commodity_id"));
				cart.setFid(rs.getInt("fid"));
				cartList.add(cart);
			}
			rs.close();
			ps.close();
	    	return cartList;
	    }
	  //查询某种种类有多少
	    public int findCartCount() throws Exception{
	    	int count = 0;
	    	 //1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "select count(*) from tb_cart";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
			return count;
	    } 
	    public  int addCart(Cart cart) throws Exception{
			int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "insert into tb_cart(uid,quantity,commodity_id,fid) values(?,?,?,?)";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1,cart.getUid());
			ps.setInt(2,cart.getQuantity());
			ps.setInt(3,cart.getCommodity_id());
			ps.setInt(4,cart.getFid());
	        //执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
			
		}
	
	    public List<CartVo> findCartListByUid(int uid) throws Exception{
	    	
	    	List<CartVo> list=new ArrayList<CartVo>();
	    	java.sql.Connection connection = DBFactory.openConnection();
	    	String sql = "select cart.cart_id,c.cname,c.img,c.promotional_price,f.fname,cart.quantity from tb_cart cart"
			 		+" inner JOIN tb_commodity c on c.commodity_id=cart.commodity_id"
			 		+" INNER JOIN tb_flavor f on f.fid=cart.fid"
			 		+" where uid=?";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, uid);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	CartVo cv=new CartVo();
	        	cv.setCname(rs.getString("cname"));
	        	cv.setFname(rs.getString("fname"));
	        	cv.setImg(rs.getString("img"));
	        	cv.setPromotional_price(rs.getInt("promotional_price"));
	        	cv.setQuantity(rs.getInt("quantity"));
	        	cv.setCart_id(rs.getInt("cart_id"));
	        	list.add(cv);
	        }
	        rs.close();
	        ps.close();
	    	
	    	return list;
	    	
	    }
	    
	    public Cart checkifSame(String commodity_id,String fid) throws Exception {
	     	Cart cart = null;
	     	Connection connection = DBFactory.openConnection();
	     	String sql = "select * from tb_cart where commodity_id=? and fid=?";
	     	PreparedStatement ps = connection.prepareStatement(sql);
	     	ps.setString(1, commodity_id);
	     	ps.setString(2,fid);
	     	ResultSet rs = ps.executeQuery();
	     	if(rs.next()) {
	     		cart=new Cart();
	     		cart.setCart_id(rs.getInt("cart_id"));
				cart.setUid(rs.getInt("uid"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setCommodity_id(rs.getInt("commodity_id"));
				cart.setFid(rs.getInt("fid"));
	 		}
	     	rs.close();
	        ps.close();
	    	
	     	return cart;
	     }
	  
public List<CartVo> findCartListByUidAndCartId(int uid,String cartIds) throws Exception{
	    	
	    	List<CartVo> list=new ArrayList<CartVo>();
	    	java.sql.Connection connection = DBFactory.openConnection();
	    	String sql = "select cart.cart_id,c.cname,c.img,c.promotional_price,f.fname,cart.quantity from tb_cart cart"
			 		+" inner JOIN tb_commodity c on c.commodity_id=cart.commodity_id"
			 		+" INNER JOIN tb_flavor f on f.fid=cart.fid"
			 		+" where uid=? and cart.cart_id in(";
	    	String[] cartIdArray=cartIds.split(",");
	    	int count=1;
	    	for(String cartid:cartIdArray){
	    		int cart_id=Integer.parseInt(cartid);
	    		sql+=cart_id;
	    		if(count!=cartIdArray.length) {
	    		 sql+=",";	
	    		}
	    		count++;		
	    	}
	    	sql+=")";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, uid);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	CartVo cv=new CartVo();
	        	cv.setCname(rs.getString("cname"));
	        	cv.setFname(rs.getString("fname"));
	        	cv.setImg(rs.getString("img"));
	        	cv.setPromotional_price(rs.getInt("promotional_price"));
	        	cv.setQuantity(rs.getInt("quantity"));
	        	cv.setCart_id(rs.getInt("cart_id"));
	        	list.add(cv);
	        }
	        rs.close();
	        ps.close();
	    	
	    	return list;
	    	
	    }


}
