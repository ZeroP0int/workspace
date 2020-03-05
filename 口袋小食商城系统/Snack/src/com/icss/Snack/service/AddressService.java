package com.icss.Snack.service;

import java.util.ArrayList;
import java.util.List;

import com.icss.Snack.dao.AddressDao;
import com.icss.Snack.entity.Address;
import com.icss.Snack.util.DBFactory;

public class AddressService {
	private AddressDao addressDao=new AddressDao();
	public List<Address> findAddressByUid(int uid) throws Exception{
    	List<Address> list = new ArrayList<Address>();
    	try {
    		list=addressDao.findAddressByUid(uid);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		DBFactory.closeConnection();
    	}
		return list;
	}
	
	public List<Address> findAddressByaddressid(int uid,int address_id) throws Exception{
    	List<Address> list = new ArrayList<Address>();
    	try {
    		list=addressDao.findAddressByaddressid(uid,address_id);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		DBFactory.closeConnection();
    	}
		return list;
	}
}
