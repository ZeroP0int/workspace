package com.icss.Snack.dao;

import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.Orders;
import com.icss.Snack.util.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {

    public int addOrders(Orders orders) throws Exception{
        int row = 0;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "insert into tb_orders(oid,uid,totalprice,remark,ordertime,state,address_id) values(?,?,?,?,?,?,?)";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setString(1,orders.getOid());
        ps.setInt(2,orders.getUid());
        ps.setDouble(3,orders.getTotalprice());
        ps.setString(4,orders.getRemark());
        ps.setTimestamp(5,orders.getOrdertime());
        ps.setInt(6,orders.getState());
        ps.setInt(7,orders.getAddress_id());
        //5.ִ��sql������Ӱ������
        row = ps.executeUpdate();
        //6.�ͷ���Դ
        ps.close();
        return row;
    }

    //ͨ�����۱���޸�����
    public  int updateOrders(Orders orders) throws Exception{
        int row = 0;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "update tb_orders set remark=?,state=? where oid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setString(1,orders.getRemark());
        ps.setInt(2,orders.getState());
        ps.setString(3,orders.getOid());
        //5.ִ��sql������Ӱ������
        row = ps.executeUpdate();
        //6.�ͷ���Դ
        ps.close();
        return row;
    }

    //ͨ���������ɾ��������Ϣ
    public int deleteOrders(String oid) throws Exception{
        int row = 0;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "delete from tb_orders where oid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setString(1,oid);
        //5.ִ��sql������Ӱ������
        row = ps.executeUpdate();
        //6.�ͷ���Դ
        ps.close();
        return row;
    }

    //ͨ���û���Ų�ѯ�û���������
    public List<Orders> findOrdersByUid(int uid) throws Exception{
        List<Orders> ordersList = new ArrayList<Orders>();
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "select * from tb_orders where uid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setInt(1,uid);
        //5.ִ��sql���ؽ����
        ResultSet rs = ps.executeQuery();
        //6.��������е�������ȡ�������������
        while (rs.next()){
            Orders orders = new Orders();
            orders.setUid(rs.getInt("uid"));
            orders.setState(rs.getInt("state"));
            orders.setOid(rs.getString("oid"));
            orders.setOrdertime(rs.getTimestamp("ordertime"));
            orders.setRemark(rs.getString("remark"));
            orders.setTotalprice(rs.getDouble("totalprice"));
            orders.setAddress_id(rs.getInt("address_id"));
            ordersList.add(orders);
        }
        return ordersList;
    }


    //ͨ��������Ų�ѯ�û���������
    public Orders findOrdersByOid(String oid) throws Exception{
        Orders orders = null;
        //1.�������ݿ�
        Connection connection = DBFactory.openConnection();
        //2.��дsql���
        String sql = "select * from tb_orders where oid=?";
        //3.����ִ��sql�Ķ���
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.����ռλ����ֵ
        ps.setString(1,oid);
        //5.ִ��sql���ؽ����
        ResultSet rs = ps.executeQuery();
        //6.��������е�������ȡ�������������
        if (rs.next()){
            orders = new Orders();
            orders.setUid(rs.getInt("uid"));
            orders.setState(rs.getInt("eid"));
            orders.setOid(rs.getString("oid"));
            orders.setOrdertime(rs.getTimestamp("createtime"));
            orders.setRemark(rs.getString("content"));
            orders.setTotalprice(rs.getDouble("totalprice"));
            orders.setAddress_id(rs.getInt("address_id"));

        }
        return orders;
    }

  //���ں�̨��ҳչʾ
  	 public List<Orders> findAllOrdersByPage(int currentPage,int pageSize) throws Exception{
  	        List<Orders> ordersList = new ArrayList<Orders>();
  	        java.sql.Connection connection = DBFactory.openConnection();
  	        String sql = "select * from tb_orders limit ?,?";
  			PreparedStatement ps = connection.prepareStatement(sql);
  			ps.setInt(1, (currentPage-1)*pageSize);
  	        ps.setInt(2,pageSize);
  	        ResultSet rs = ps.executeQuery();
  	        while(rs.next()) {
  	        	Orders orders=new Orders();
  	        	orders = new Orders();
  	            orders.setUid(rs.getInt("uid"));
  	            orders.setState(rs.getInt("eid"));
  	            orders.setOid(rs.getString("oid"));
  	            orders.setOrdertime(rs.getTimestamp("createtime"));
  	            orders.setRemark(rs.getString("content"));
  	            orders.setTotalprice(rs.getDouble("totalprice"));
  	            orders.setAddress_id(rs.getInt("address_id"));
  	        	ordersList.add(orders);
  	        }
  	        rs.close();
  	        ps.close();
  	        return ordersList;
  	    }
  	 
  	 public int findAllOrdersCount() throws Exception{
  		 int count=0;
  		 java.sql.Connection connection = DBFactory.openConnection();
  		 String sql="select count(*) from tb_orders";
  		 PreparedStatement ps = connection.prepareStatement(sql);
  		 ResultSet rs = ps.executeQuery();
  		 if(rs.next()) {
  			 count=rs.getInt(1);
  		 }
  		 rs.close();
  	     ps.close();
  		return count;
  	 }
  	

   
}

