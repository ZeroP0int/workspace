package com.icss.Snack.entity;

public class Orders_detail {
	private int detail_id;//��ţ����Զ�����
	private int commodity_id;//��Ʒ��ţ������
	private int quantity;//��Ʒ����
	private double price;//����
	private int fid;//��ζ��ţ������
	private int brand_id;//Ʒ�Ʊ�ţ������
	private String oid;//�������
	public int getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}
	public int getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Orders_detail [detail_id=" + detail_id + ", commodity_id=" + commodity_id + ", quantity=" + quantity
				+ ", price=" + price + ", fid=" + fid + ", brand_id=" + brand_id + ", oid=" + oid + "]";
	}
	

}
