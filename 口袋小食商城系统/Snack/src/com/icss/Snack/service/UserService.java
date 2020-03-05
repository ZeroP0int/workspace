package com.icss.Snack.service;

import com.icss.Snack.dao.UserDao;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

public class UserService {
	private UserDao userDao = new UserDao();
	 public User login(String name,String pwd) throws Exception{
		 User user = null;
		 try {
		 user = userDao.login(name,pwd);//1.调用数据层的方法
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 //无论程序是否异常，该程序始终运行
			 DBFactory.closeConnection();//2.关闭数据库连接
		 }
		 
		 return user;
	 }
	 
	 public  int register(User user) throws Exception{
		 int row=0;
		 try {
		   row=userDao.register(user);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBFactory.closeConnection();
		 }
		 return row;
	 }
	 //检查用户名是否存在
	 public User checkName(String name) throws Exception{
		 User user = null;
		 try {
		 user = userDao.checkName(name);//1.调用数据层的方法
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 //无论程序是否异常，该程序始终运行
			 DBFactory.closeConnection();//2.关闭数据库连接
		 }
		 
		 return user;
	 }

}
