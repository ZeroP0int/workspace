package com.icss.Snack.entity;

public class Cart {
	private int cart_id;//���ﳵ��ţ��������Զ�����
	private int uid;//�û���ţ������
	private int quantity;//��Ʒ������
	private int fid;//��ζ���
	private int commodity_id;//��Ʒ���
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}
	

}
