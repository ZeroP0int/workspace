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
�û����ݲ㣺�û���ӣ�ɾ�����޸�
*/
public class UserDao {
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
//��
	public  int register(User user) throws Exception{
		int row = 0;
		//1.�������ݿ�
		java.sql.Connection connection = DBFactory.openConnection();
		//��дsql���
		String sql = "insert into tb_user(username,password,regtime) values(?,?,?)";
		//����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//����ռλ����ֵ
		ps.setString(1,user.getUsername());
	    ps.setString(2,user.getPassword());
		ps.setTimestamp(3,user.getRegtime());
		//ִ��sql������Ӱ������
		row = ps.executeUpdate();
		//�ͷ���Դ
		ps.close();
		return row;
		
	}
	//��
    public int updateUser(User user) throws Exception{
    	int row = 0;
		//1.�������ݿ�
		java.sql.Connection connection = DBFactory.openConnection();
		//��дsql���
		String sql = "update tb_user set username=?,password=?,phone=?,sex=?,email=? where uid=?";
		//����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//����ռλ����ֵ
		ps.setString(1,user.getUsername());
	    ps.setString(2,user.getPassword());
	    ps.setString(3,user.getPhone());
	    ps.setString(4,user.getSex());
	    ps.setString(5,user.getEmail());
	    ps.setInt(6,user.getUid());
		//ִ��sql������Ӱ������
		row = ps.executeUpdate();
		//�ͷ���Դ
		ps.close();
		return row;
    	}
    //ɾ
    public int deleteUser(int uid) throws Exception {
    	int row = 0;
		//1.�������ݿ�
		java.sql.Connection connection = DBFactory.openConnection();
		//��дsql���
		String sql = "delete from tb_user where uid=?";
		//����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//����ռλ����ֵ
		ps.setInt(1, uid);
		//ִ��sql������Ӱ������
		row = ps.executeUpdate();
		//�ͷ���Դ
		ps.close();
		return row;
    }
 
    /*
     * ��ѯ�û�����
     */
    public User findUserByUid(int uid)throws Exception{
    	        User user = null;
    	       //1.�������ݿ�
    			java.sql.Connection connection = DBFactory.openConnection();
    			//��дsql���
    			String sql = "select * from tb_user where uid=?";
    			//����ִ��sql�Ķ���
    			PreparedStatement ps = connection.prepareStatement(sql);
    			//����ռλ����ֵ
    			ps.setInt(1, uid);
    			//ִ��sql���ؽ����
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
    //��ѯ�ж�������
    public List<User> findAllUserList() throws Exception{
    	List<User> userList = new ArrayList<User>();
    	 //1.�������ݿ�
		java.sql.Connection connection = DBFactory.openConnection();
		//��дsql���
		String sql = "select * from tb_user";
		//����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//����ռλ����ֵ
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
    
    //�û���¼����
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
  //���ں�̨��ҳչʾ
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
