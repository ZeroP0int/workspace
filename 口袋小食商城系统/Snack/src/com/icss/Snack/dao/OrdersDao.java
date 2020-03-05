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
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "insert into tb_orders(oid,uid,totalprice,remark,ordertime,state,address_id) values(?,?,?,?,?,?,?)";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setString(1,orders.getOid());
        ps.setInt(2,orders.getUid());
        ps.setDouble(3,orders.getTotalprice());
        ps.setString(4,orders.getRemark());
        ps.setTimestamp(5,orders.getOrdertime());
        ps.setInt(6,orders.getState());
        ps.setInt(7,orders.getAddress_id());
        //5.执行sql返回受影响行数
        row = ps.executeUpdate();
        //6.释放资源
        ps.close();
        return row;
    }

    //通过评价编号修改评价
    public  int updateOrders(Orders orders) throws Exception{
        int row = 0;
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "update tb_orders set remark=?,state=? where oid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setString(1,orders.getRemark());
        ps.setInt(2,orders.getState());
        ps.setString(3,orders.getOid());
        //5.执行sql返回受影响行数
        row = ps.executeUpdate();
        //6.释放资源
        ps.close();
        return row;
    }

    //通过订单编号删除订单信息
    public int deleteOrders(String oid) throws Exception{
        int row = 0;
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "delete from tb_orders where oid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setString(1,oid);
        //5.执行sql返回受影响行数
        row = ps.executeUpdate();
        //6.释放资源
        ps.close();
        return row;
    }

    //通过用户编号查询用户订单详情
    public List<Orders> findOrdersByUid(int uid) throws Exception{
        List<Orders> ordersList = new ArrayList<Orders>();
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "select * from tb_orders where uid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setInt(1,uid);
        //5.执行sql返回结果集
        ResultSet rs = ps.executeQuery();
        //6.将结果集中的数据提取到对象的属性中
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


    //通过订单编号查询用户评价详情
    public Orders findOrdersByOid(String oid) throws Exception{
        Orders orders = null;
        //1.建立数据库
        Connection connection = DBFactory.openConnection();
        //2.编写sql语句
        String sql = "select * from tb_orders where oid=?";
        //3.创建执行sql的对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.设置占位符的值
        ps.setString(1,oid);
        //5.执行sql返回结果集
        ResultSet rs = ps.executeQuery();
        //6.将结果集中的数据提取到对象的属性中
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

  //用于后台分页展示
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

