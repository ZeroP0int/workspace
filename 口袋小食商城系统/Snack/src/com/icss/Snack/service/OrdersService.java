package com.icss.Snack.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.icss.Snack.dao.CartDao;
import com.icss.Snack.dao.CommodityDao;
import com.icss.Snack.dao.OrdersDao;
import com.icss.Snack.dao.OrdersDetailDao;
import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.Orders;
import com.icss.Snack.entity.Orders_detail;
import com.icss.Snack.util.DBFactory;
import com.icss.Snack.util.PageUtil;

public class OrdersService {
	private OrdersDao ordersDao=new OrdersDao();
	public PageUtil<Orders> findAllOrdersByPage(int currentPage,int pageSize) throws Exception{
		PageUtil<Orders> pu=new PageUtil<Orders>();
		List<Orders> list=null;
		int count=0;
		try {
			list=ordersDao.findAllOrdersByPage(currentPage, pageSize);
			count=ordersDao.findAllOrdersCount();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		int totalPage=count%pageSize==0?count/pageSize:count/pageSize+1;
		pu.setCount(count);
		pu.setCurrentPage(currentPage);
		pu.setList(list);
		pu.setTotalPage(totalPage);
		return pu;
		
	}
	
	public void addOrder(int address_id,String remark,double totalprice,int uid,String cartIds) throws Exception {
		//创建日志记录对象
		Logger logger=Logger.getLogger(this.getClass().getName());
		
		CartDao cartDao=new CartDao();
		OrdersDao ordersDao=new OrdersDao();
		OrdersDetailDao ordersDetailDao=new OrdersDetailDao();
		CommodityDao commodityDao=new CommodityDao();
		try {
			DBFactory.beginTransaction();
			//订单表的添加
			String oid=UUID.randomUUID().toString();
			Orders orders=new Orders();
			orders.setAddress_id(address_id);
			orders.setOid(oid);
			orders.setOrdertime(new Timestamp(System.currentTimeMillis()));
			orders.setRemark(remark);
			orders.setState(1);
			orders.setTotalprice(totalprice);
			orders.setUid(uid);
			ordersDao.addOrders(orders);
			cartIds=cartIds.substring(0,cartIds.length()-1);
			
			String[] idArray=cartIds.split(",");
			List<Orders_detail> orderDetailList=new ArrayList<Orders_detail>();
			for(int i=0;i<idArray.length;i++) {
			//调方法-通过购物车编号查询
			int cart_id=Integer.parseInt(idArray[i]);
			Commodity commodity=commodityDao.findCommodityByCartid(cart_id);		
			//订单详情表的添加
			Orders_detail ordersDetail=new Orders_detail();
			ordersDetail.setBrand_id(commodity.getBrand_id());
			ordersDetail.setCommodity_id(commodity.getCommodity_id());
			
			ordersDetail.setFid(commodity.getFid());
			ordersDetail.setOid(oid);
			ordersDetail.setPrice(commodity.getPromotional_price());
			ordersDetail.setQuantity(commodity.getQuantity());
			ordersDetailDao.addOrdersDetail(ordersDetail);
			orderDetailList.add(ordersDetail);
			}
          //购物车表的删除
			cartDao.deleteCart(cartIds);
			orders.setOrderDetailList(orderDetailList);
			logger.info(orders);//记录订单日志
			
			DBFactory.commit();
		}catch(Exception e) {
			DBFactory.rollback();
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		
	}

}
