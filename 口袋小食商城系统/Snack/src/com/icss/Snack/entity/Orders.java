package com.icss.Snack.entity;

import java.sql.Timestamp;
import java.util.List;

public class Orders {
	private String oid;//������ţ�����
	private int uid;//�û���ţ������
	private double totalprice;//�ܼ�
	private String remark;//��ע
	private Timestamp ordertime;//�µ�ʱ��
	private int state;//����״̬��0�������� 1�������� 2�����ջ� 3��������
	private int address_id;//��ַ���
	private List<Orders_detail> orderDetailList;//�����Ͷ������飺һ�Զ�
	
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
