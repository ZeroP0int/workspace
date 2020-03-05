package com.icss.Snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Brand;
import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

public class BrandDao {
	//增
		public  int Add(Brand brand) throws Exception{
			int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "insert into tb_brand(brand_id,name,phone,email,address,state) values(?,?,?,?,?,?)";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1,brand.getBrand_id());
			ps.setString(2,brand.getName());
		    ps.setString(3,brand.getPhone());
		    ps.setString(4,brand.getEmail());
		    ps.setString(5,brand.getAddress());
		    ps.setString(6,brand.getState());
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
			
		}
		//改
	    public int updateBrand(Brand brand) throws Exception{
	    	int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "update tb_brand set brand_id=?,name=?,phone=?,email=?,address=?,state=?";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1,brand.getBrand_id());
			ps.setString(2,brand.getName());
		    ps.setString(3,brand.getPhone());
		    ps.setString(4,brand.getEmail());
		    ps.setString(5,brand.getAddress());
		    ps.setString(6,brand.getState());
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
	    	}
	    //删
	    public int deleteBrand(int brand_id) throws Exception {
	    	int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "delete from tb_brand where bran_id=?";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1, brand_id);
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
	    }
	    /*
	     * 查询用户详情
	     */
	    public Brand findBrandBybrandid(int brand_id)throws Exception{
	    	        Brand brand = null;
	    	       //1.连接数据库
	    			java.sql.Connection connection = DBFactory.openConnection();
	    			//编写sql语句
	    			String sql = "select * from tb_brand where brand_id=?";
	    			//创建执行sql的对象
	    			PreparedStatement ps = connection.prepareStatement(sql);
	    			//设置占位符的值
	    			ps.setInt(1, brand_id);
	    			//执行sql返回结果集
	    			ResultSet rs = ps.executeQuery();
	    			if(rs.next()) {
	    				brand=new Brand();
	    				brand.setBrand_id(rs.getInt("brand_id"));
	    				brand.setName(rs.getString("name"));
	    				brand.setEmail(rs.getString("email"));
	    				brand.setAddress(rs.getString("address"));
	    				brand.setPhone(rs.getString("phone"));
	    				brand.setState(rs.getString("state"));
	    				
	    			}
	    			rs.close();
	    			ps.close();
	    			return brand;
	     }
	  //查询有多少种类
	    public List<Brand> findAllBrandList() throws Exception{
	    	List<Brand> brandList = new ArrayList<Brand>();
	    	 //1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "select * from tb_brand";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Brand brand=new Brand();
				brand.setBrand_id(rs.getInt("brand_id"));
				brand.setName(rs.getString("name"));
				brand.setEmail(rs.getString("email"));
				brand.setAddress(rs.getString("address"));
				brand.setPhone(rs.getString("phone"));
				brand.setState(rs.getString("state"));
				
				brandList.add(brand);
			}
			rs.close();
			ps.close();
	    	return brandList;
	    } 
	    //查询某种种类有多少
	    public int findBrandCount() throws Exception{
	    	int count = 0;
	    	 //1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "select count(*) from tb_brand";
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
 public static void main(String[] args) throws Exception {
			
	        BrandDao brandDao = new BrandDao();
	        
	        Brand brand = new Brand();
	        brand.setName("余杭");
	        brand.setEmail("1567286783@qq.com");
	        brand.setAddress("北京市昌平区");
	        brand.setPhone("13562534546");
	        brand.setState("0");
	        
	        int row = brandDao.Add(brand);
	       
	       /* List<Cart> cartList = cartDao.findAllCartList();
	        System.out.println(cartList.size());    
	    */    
	       }   
}
