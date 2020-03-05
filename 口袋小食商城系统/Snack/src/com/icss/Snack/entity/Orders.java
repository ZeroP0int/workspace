package com.icss.Snack.entity;

import java.sql.Timestamp;
import java.util.List;

public class Orders {
	private String oid;//订单编号，主键
	private int uid;//用户编号（外键）
	private double totalprice;//总价
	private String remark;//备注
	private Timestamp ordertime;//下单时间
	private int state;//订单状态：0：待付款 1：代发货 2：待收货 3：待评价
	private int address_id;//地址编号
	private List<Orders_detail> orderDetailList;//订单和订单详情：一对多
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public List<Orders_detail> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<Orders_detail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", uid=" + uid + ", totalprice=" + totalprice + ", remark=" + remark
				+ ", ordertime=" + ordertime + ", state=" + state + ", address_id=" + address_id + ", orderDetailList="
				+ orderDetailList + "]";
	}
    
}
