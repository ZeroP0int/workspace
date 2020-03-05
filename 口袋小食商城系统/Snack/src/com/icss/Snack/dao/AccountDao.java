package com.icss.Snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Account;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

//增
public class AccountDao {
	public int Add(Account account) throws Exception {
		int row = 0;
		//1.连接数据库
		java.sql.Connection connection = DBFactory.openConnection();
		//编写sql语句
		String sql = "insert into tb_account(account_id,uid,money) values(?,?,?)";
		//创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//设置占位符的值
		ps.setInt(1,account.getAccount_id());
	    ps.setInt(2,account.getUid());
		ps.setDouble(3,account.getMoney());
		//执行sql返回受影响行数
		row = ps.executeUpdate();
		//释放资源
		ps.close();
		return row;
	}
	//改
	 public int updateAccount(Account account) throws Exception{
		 int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "update tb_account set account_id=?,uid=?,money=?";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1,account.getAccount_id());
		    ps.setInt(2,account.getUid());
			ps.setDouble(3,account.getMoney());
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
		 
	 }
	
	//删
	 public int deleteAccount(int account_id) throws Exception {
	    	int row = 0;
			//1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "delete from tb_user where account_id=?";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1, account_id);
			//执行sql返回受影响行数
			row = ps.executeUpdate();
			//释放资源
			ps.close();
			return row;
	    }
	 
	//查询用户详情 
	 public Account findAccountByaccountid(int account_id)throws Exception{
	        Account account = null;
	       //1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "select * from tb_account where account_id=?";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ps.setInt(1, account_id);
			//执行sql返回结果集
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				account=new Account();
				account.setAccount_id(rs.getInt("account_id"));
			    account.setUid(rs.getInt("uid"));
				account.setMoney( rs.getDouble("money"));
				
			}
			rs.close();
			ps.close();
			return account;
}
	 
//查询有多少种类
	 public  List<Account> findAllAccountList() throws Exception{
	    	List<Account> accountList = new ArrayList<Account>();
	    	 //1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "select * from tb_account";
			//创建执行sql的对象
			PreparedStatement ps = connection.prepareStatement(sql);
			//设置占位符的值
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account=new Account();
				account.setAccount_id(rs.getInt("account_id"));
			    account.setUid(rs.getInt("uid"));
				account.setMoney(rs.getDouble("money"));
				accountList.add(account);
			}
			rs.close();
			ps.close();
	    	return accountList;
	    }
	//查询某种种类有多少
	    public int findAccountCount() throws Exception{
	    	int count = 0;
	    	 //1.连接数据库
			java.sql.Connection connection = DBFactory.openConnection();
			//编写sql语句
			String sql = "select count(*) from account_user";
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
		AccountDao accountDao = new AccountDao();
		List<Account> accountList = accountDao.findAllAccountList();
	    System.out.println(accountList.size());    
	    
	   }
}
