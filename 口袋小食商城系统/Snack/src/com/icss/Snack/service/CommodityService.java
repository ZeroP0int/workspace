package com.icss.Snack.service;

import java.util.List;

import com.icss.Snack.dao.CommodityDao;
import com.icss.Snack.dao.CommodityParamDao;
import com.icss.Snack.dao.FlavorDao;
import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.CommodityParam;
import com.icss.Snack.entity.Flavor;
import com.icss.Snack.util.DBFactory;
import com.icss.Snack.util.PageUtil;

public class CommodityService {
	private CommodityDao commodityDao = new CommodityDao();
	private FlavorDao flavorDao=new FlavorDao();
	//首页最新商品展示
	public List<Commodity> findLatestCommodityList() throws Exception{
		List<Commodity>list = null;
		try{
			list=commodityDao.findLatestCommodityList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return list;
		
	}
	
	public Commodity findCommodityById(int id)throws Exception{
		Commodity commodity = null;
		try {
			commodity = commodityDao.findCommodityByUid(id);
			CommodityParam commodityParam=new CommodityParamDao().findCommodityParamById(commodity.getParam_id());
			commodity.setCommodityParam(commodityParam);//添加产品参数
			List<Flavor> flavorList=new FlavorDao().findFlavorById(id);
			commodity.setFlavorList(flavorList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return commodity;
	}
	
	
	public PageUtil<Commodity> findAllCommodityByPage(int currentPage,int pageSize) throws Exception{
		PageUtil<Commodity> pu=new PageUtil<Commodity>();
		List<Commodity> list=null;
		int count=0;
		try {
			list=commodityDao.findAllCommodityByPage(currentPage, pageSize);
			count=commodityDao.findAllCommodityCount();
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
	
	public int deleteCommodityById(int id) throws Exception{
		int row=0;
		try {
			row=commodityDao.deleteCommodityById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBFactory.closeConnection();
		}
		return row;
	}
	

	 public Commodity findCommodityByCid(int commodity_id)throws Exception{
		 Commodity commodity = null;
		 try {
			commodity=commodityDao.findCommodityByCid(commodity_id);
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				DBFactory.closeConnection();
			}
		 
		return commodity;
		 
	 }
		//用于直接付款
	 public Commodity findCommoditytoPay(int commodity_id)throws Exception{
		 
		 Commodity commodity = null;
		 try {
			commodity=commodityDao.findCommoditytoPay(commodity_id);
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				DBFactory.closeConnection();
			}
		 
		return commodity;
	 }
}

