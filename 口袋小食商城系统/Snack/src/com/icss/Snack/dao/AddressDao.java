package com.icss.Snack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.entity.Address;
import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;


public class AddressDao {
	//��
		public  int Add(Address address) throws Exception{
			int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "insert into tb_address(address_id,uid,full_address,phone,zip_code,name,state) values(?,?,?,?,?,?,?)";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1,address.getAddress_id());
		    ps.setInt(2,address.getUid());
			ps.setString(3,address.getFull_address());
			ps.setString(4,address.getPhone());
			ps.setString(5,address.getZip_code());
			ps.setString(6,address.getName());
			ps.setInt(7,address.getState());
			
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
		}
		//��
	    public int updateAddress(Address address) throws Exception{
	    	int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "update tb_address set address_id=?,uid=?,full_address=?,phone=?,zip_code=?,name=?,state=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1,address.getAddress_id());
		    ps.setInt(2,address.getUid());
			ps.setString(3,address.getFull_address());
			ps.setString(4,address.getPhone());
			ps.setString(5,address.getZip_code());
			ps.setString(6,address.getName());
			ps.setInt(7,address.getState());
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
	    	}
	    //ɾ
	    public int deleteAddress(int address_id) throws Exception {
	    	int row = 0;
			//1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "delete from tb_user where address_id=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ps.setInt(1, address_id);
			//ִ��sql������Ӱ������
			row = ps.executeUpdate();
			//�ͷ���Դ
			ps.close();
			return row;
	    }
	    /*
	     * ��ѯ�û�����
	     */
	    public List<Address> findAddressByaddressid(int uid,int address_id)throws Exception{
	    	List<Address> addressList = new ArrayList<Address>();
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select * from tb_address where uid=? and address_id=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, uid);
			ps.setInt(2, address_id);
			//����ռλ����ֵ
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Address address=new Address();
				address=new Address();
				address.setAddress_id(rs.getInt("address_id"));
				address.setUid(rs.getInt("uid"));
				address.setFull_address(rs.getString("full_address"));
				address.setPhone(rs.getString("phone"));
				address.setZip_code(rs.getString("zip_code"));
				address.setName(rs.getString("name"));
				address.setState(rs.getInt("state"));
	
				addressList.add(address);
			}
			rs.close();
			ps.close();
	    	return addressList;
	     }
	    //��ѯ�ж�������
	    public List<Address> findAllAddressList() throws Exception{
	    	List<Address> addressList = new ArrayList<Address>();
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select * from tb_address";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			//����ռλ����ֵ
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Address address=new Address();
				address=new Address();
				address.setAddress_id(rs.getInt("address_id"));
				address.setUid(rs.getInt("uid"));
				address.setFull_address(rs.getString("full_address"));
				address.setPhone(rs.getString("phone"));
				address.setZip_code(rs.getString("zip_code"));
				address.setName(rs.getString("name"));
				address.setState(rs.getInt("state"));
	
				addressList.add(address);
			}
			rs.close();
			ps.close();
	    	return addressList;
	    }
	    //��ѯĳ�������ж���
	    public int findAddressCount() throws Exception{
	    	int count = 0;
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select count(*) from tb_address";
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
	    public List<Address> findAddressByUid(int uid) throws Exception{
	    	List<Address> list = new ArrayList<Address>();
	    	 //1.�������ݿ�
			java.sql.Connection connection = DBFactory.openConnection();
			//��дsql���
			String sql = "select * from tb_address where uid=?";
			//����ִ��sql�Ķ���
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, uid);
			//����ռλ����ֵ
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Address address=new Address();
				address=new Address();
				address.setAddress_id(rs.getInt("address_id"));
				address.setUid(rs.getInt("uid"));
				address.setFull_address(rs.getString("full_address"));
				address.setPhone(rs.getString("phone"));
				address.setZip_code(rs.getString("zip_code"));
				address.setName(rs.getString("name"));
				address.setState(rs.getInt("state"));
	
				list.add(address);
			}
			rs.close();
			ps.close();
	    	return list;
	    }
}
