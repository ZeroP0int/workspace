package com.icss.Snack.service;

import com.icss.Snack.dao.UserDao;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

public class UserService {
	private UserDao userDao = new UserDao();
	 public User login(String name,String pwd) throws Exception{
		 User user = null;
		 try {
		 user = userDao.login(name,pwd);//1.�������ݲ�ķ���
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 //���۳����Ƿ��쳣���ó���ʼ������
			 DBFactory.closeConnection();//2.�ر����ݿ�����
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
	 //����û����Ƿ����
	 public User checkName(String name) throws Exception{
		 User user = null;
		 try {
		 user = userDao.checkName(name);//1.�������ݲ�ķ���
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 //���۳����Ƿ��쳣���ó���ʼ������
			 DBFactory.closeConnection();//2.�ر����ݿ�����
		 }
		 
		 return user;
	 }

}
