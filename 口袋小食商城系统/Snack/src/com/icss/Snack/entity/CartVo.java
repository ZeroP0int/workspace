package com.icss.Snack.entity;

public class CartVo {
	private int quantity;
	private String fname;
	private String cname;
	private double promotional_price;
	private String img;
	private int cart_id;//¹ºÎï³µ±àºÅ
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getPromotional_price() {
		return promotional_price;
	}
	public void setPromotional_price(double promotional_price) {
		this.promotional_price = promotional_price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	
	

}
