package com.icss.Snack.service;

import java.util.List;

import com.icss.Snack.dao.UserDao;
import com.icss.Snack.entity.Commodity;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;
import com.icss.Snack.util.PageUtil;

public class AccountService {
	private UserDao userDao=new UserDao();
	public PageUtil<User> findAllUserByPage(int currentPage,int pageSize) throws Exception{
		PageUtil<User> pu=new PageUtil<User>();
		List<User> list=null;
		int count=0;
		try {
			list=userDao.findAllUserByPage(currentPage, pageSize);
			count=userDao.findAllUserCount();
		}catch(Exception e){
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
  
}
