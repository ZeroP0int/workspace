package com.icss.Snack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;


/*
用户数据层：用户添加，删除，修改
*/
public class UserDao {
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
//增
	public  int register(User user) throws Exception{
		int row = 0;
		//1.连接数据库
		java.sql.Connection connection = DBFactory.openConnection();
		//编写sql语句
		String sql = "insert into tb_user(username,password,regtime) values(?,?,?)";
		//创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//设置占位符的值
		ps.setString(1,user.getUsername());
	    ps.setString(2,user.getPassword());
		ps.setTimestamp(3,user.getRegtime());
		//执行sql返回受影响行数
		row = ps.executeUpdate();
		//释放资源
		ps.close();
		return row;
		
	}
	//改
    public int updateUser(User user) throws Exception{
    	int row = 0;
		//1.连接数据库
		java.sql.Connection connection = DBFactory.openConnection();
		//编写sql语句
		String sql = "update tb_user set username=?,password=?,phone=?,sex=?,email=? where uid=?";
		//创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//设置占位符的值
		ps.setString(1,user.getUsername());
	    ps.setString(2,user.getPassword());
	    ps.setString(3,user.getPhone());
	    ps.setString(4,user.getSex());
	    ps.setString(5,user.getEmail());
	    ps.setInt(6,user.getUid());
		//执行sql返回受影响行数
		row = ps.executeUpdate();
		//释放资源
		ps.close();
		return row;
    	}
    //删
    public int deleteUser(int uid) throws Exception {
    	int row = 0;
		//1.连接数据库
		java.sql.Connection connection = DBFactory.openConnection();
		//编写sql语句
		String sql = "delete from tb_user where uid=?";
		//创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//设置占位符的值
		ps.setInt(1, uid);
		//执行sql返回受影响行数
		row = ps.executeUpdate();
		//释放资源
		ps.close();
		return row;
    }
 
    /*
     * 查询用户详情
     */
    public User findUserByUid(int uid)throws Exception{
    	        User user = null;
    	       //1.连接数据库
    			java.sql.Connection connection = DBFactory.openConnection();
    			//编写sql语句
    			String sql = "select * from tb_user where uid=?";
    			//创建执行sql的对象
    			PreparedStatement ps = connection.prepareStatement(sql);
    			//设置占位符的值
    			ps.setInt(1, uid);
    			//执行sql返回结果集
    			ResultSet rs = ps.executeQuery();
    			if(rs.next()) {
    				user=new User();
    				user.setUid(rs.getInt("uid"));
    				user.setAccout_id(rs.getInt("account_id"));
    				user.setEmail(rs.getString("email"));
    				user.setPassword(rs.getString("password"));
    				user.setPhone(rs.getString("phone"));
    				user.setRegtime(rs.getTimestamp("regtime"));
    				user.setSex(rs.getString("sex"));
    				user.setUsername(rs.getString("username"));
    				
    			}
    			rs.close();
    			ps.close();
    			return user;
     }
    //查询有多少种类
    public List<User> findAllUserList() throws Exception{
    	List<User> userList = new ArrayList<User>();
    	 //1.连接数据库
		java.sql.Connection connection = DBFactory.openConnection();
		//编写sql语句
		String sql = "select * from tb_user";
		//创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//设置占位符的值
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			User user=new User();
			user.setUid(rs.getInt("uid"));
			user.setAccout_id(rs.getInt("account_id"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setRegtime(rs.getTimestamp("regtime"));
			user.setSex(rs.getString("sex"));
			user.setUsername(rs.getString("username"));
			userList.add(user);
		}
		rs.close();
		ps.close();
    	return userList;
    }
    
    //用户登录方法
    public User login(String name,String pwd) throws Exception {
    	User user = null;
    	Connection connection = DBFactory.openConnection();
    	String sql = "select * from tb_user where username=? and password=?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	ps.setString(1, name);;
    	ps.setString(2,pwd);
    	ResultSet rs = ps.executeQuery();
    	if(rs.next()) {
			user=new User();
			user.setUid(rs.getInt("uid"));
			user.setAccout_id(rs.getInt("account_id"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setRegtime(rs.getTimestamp("regtime"));
			user.setSex(rs.getString("sex"));
			user.setUsername(rs.getString("username"));	
		}
    	
    	return user;
    }
  //用于后台分页展示
  	 public List<User> findAllUserByPage(int currentPage,int pageSize) throws Exception{
  	        List<User> userList = new ArrayList<User>();
  	        java.sql.Connection connection = DBFactory.openConnection();
  	        String sql = "SELECT * from tb_user limit ?,?";
  	        PreparedStatement ps = connection.prepareStatement(sql);
  			ps.setInt(1, (currentPage-1)*pageSize);
  	        ps.setInt(2,pageSize);
  	        ResultSet rs = ps.executeQuery();
  	        while(rs.next()) {
  	        	User user=new User();
  	        	user=new User();
  	        	user.setUid(rs.getInt("uid"));
  				user.setAccout_id(rs.getInt("account_id"));
  				user.setEmail(rs.getString("email"));
  				user.setPassword(rs.getString("password"));
  				user.setPhone(rs.getString("phone"));
  				user.setRegtime(rs.getTimestamp("regtime"));
  				user.setSex(rs.getString("sex"));
  				user.setUsername(rs.getString("username"));	
  				userList.add(user);
  	        }
  	        rs.close();
  	        ps.close();
  	        return userList;
  	    }
  	 
  	 public int findAllUserCount() throws Exception{
  		 int count=0;
  		 java.sql.Connection connection = DBFactory.openConnection();
  		 String sql="Select count(*) from tb_user";
  		 PreparedStatement ps = connection.prepareStatement(sql);
  		 ResultSet rs = ps.executeQuery();
  		 if(rs.next()) {
  			 count=rs.getInt(1);
  		 }
  		 rs.close();
  	     ps.close();
  		return count;
  	 }
  	 
  	 public User checkName(String name) throws Exception {
     	User user = null;
     	Connection connection = DBFactory.openConnection();
     	String sql = "select * from tb_user where username=?";
     	PreparedStatement ps = connection.prepareStatement(sql);
     	ps.setString(1, name);
     	ResultSet rs = ps.executeQuery();
     	if(rs.next()) {
 			user=new User();
 			user.setUid(rs.getInt("uid"));
 			user.setAccout_id(rs.getInt("account_id"));
 			user.setEmail(rs.getString("email"));
 			user.setPassword(rs.getString("password"));
 			user.setPhone(rs.getString("phone"));
 			user.setRegtime(rs.getTimestamp("regtime"));
 			user.setSex(rs.getString("sex"));
 			user.setUsername(rs.getString("username"));	
 		}
     	
     	return user;
     }
  	
  public static void main(String[] args) {
    	UserDao userdao = new UserDao();
    	try {
    		User user = userdao.login("whn","123456");
    		System.out.println(user);
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
