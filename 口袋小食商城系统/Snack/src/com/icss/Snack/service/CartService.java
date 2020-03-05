package com.icss.Snack.service;

import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.dao.CartDao;
import com.icss.Snack.entity.Cart;
import com.icss.Snack.entity.CartVo;
import com.icss.Snack.entity.User;
import com.icss.Snack.util.DBFactory;

public class CartService {

	private CartDao cartDao=new CartDao();
	
	public  int addCart(Cart cart) throws Exception{
		int row=0;
		 try {
			 row=cartDao.addCart(cart);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }finally {
				 //���۳����Ƿ��쳣���ó���ʼ������
				 DBFactory.closeConnection();//2.�ر����ݿ�����
			 }
	
		return row;
			 
	}
	
	public List<CartVo> findCartListByUid(int uid) throws Exception{
		List<CartVo> list=new ArrayList<CartVo>();
		try {
			list=cartDao.findCartListByUid(uid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return list;
	}
	
	public List<CartVo> findCartListByUidAndCartId(int uid,String cartIds) throws Exception{
		List<CartVo> list=new ArrayList<CartVo>();
		try {
			list=cartDao.findCartListByUidAndCartId(uid,cartIds);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return list;
	}
//ɾ�����ﳵ
	 public int delCart(int cart_id) throws Exception{
		int row=0;
		
		 try {
			 row=cartDao.delCart(cart_id);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }finally {
				 //���۳����Ƿ��쳣���ó���ʼ������
				 DBFactory.closeConnection();//2.�ر����ݿ�����
			 }
	
		return row;
			 
	}
	 
	 //��չ��ﳵ
	    public int delAllCart() throws Exception{
	    	int row=0;
			
			 try {
				 row=cartDao.delAllCart();
				 }catch (Exception e) {
					 e.printStackTrace();
				 }finally {
					 //���۳����Ƿ��쳣���ó���ʼ������
					 DBFactory.closeConnection();//2.�ر����ݿ�����
				 }
		
			return row;
	    }
}
