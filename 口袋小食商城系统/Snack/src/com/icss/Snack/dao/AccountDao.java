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

//��
public class AccountDao {
	public int Add(Account account) throws Exception {
		int row = 0;
		//1.�������ݿ�
		java.sql.Connection connection = DBFactory.openConnection();
		//��дsql���
		String sql = "insert into tb_account(account_id,uid,money) values(?,?,?)";
		//����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//����ռλ����ֵ
		ps.setInt(1,account.getAccount_id());
	    ps.setInt(2,account.getUid());
		ps.setDouble(3,account.getMoney());
		//ִ��sql������Ӱ������
		row = ps.executeUpdate();
		//�ͷ���Դ
		ps.close();
		return row;
	}
	//��
	 public int updateAccount(Account account) throws Exception{
		 int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "update tb_account set account_id=?,uid=?,money=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1,account.getAccount_id());
		    ps.setInt(2,account.getUid());
			ps.setDouble(3,account.getMoney());
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
		 
	 }
	
	//ɾ
	 public int deleteAccount(int account_id) throws Exception {
	    	int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "delete from tb_user where account_id=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1, account_id);
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
	    }
	 
	//��ѯ�û����� 
	 public Account findAccountByaccountid(int account_id)throws Exception{
	        Account account = null;
	       //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select * from tb_account where account_id=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1, account_id);
			//ִ��sql���ؽ����
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
	 
//��ѯ�ж�������
	 public  List<Account> findAllAccountList() throws Exception{
	    	List<Account> accountList = new ArrayList<Account>();
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select * from tb_account";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
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
	//��ѯĳ�������ж���
	    public int findAccountCount() throws Exception{
	    	int count = 0;
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select count(*) from account_user";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
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
