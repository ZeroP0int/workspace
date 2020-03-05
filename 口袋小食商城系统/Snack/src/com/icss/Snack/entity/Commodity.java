package com.icss.Snack.entity;

import java.sql.Timestamp;
import java.util.List;

public class Commodity {

	private int commodity_id;//��Ʒ��ţ��������Զ�����
	private int category_parentid;//����ţ������
	private int brand_id;//Ʒ�Ʊ�ţ������
	private String cname;//��Ʒ����
	private double promotional_price;//������
	private double original_price;//ԭ��
	private String description;//��Ʒ����
	private String img;//��ƷͼƬ��
	private Timestamp datetime;//����ʱ��
	private int param_id;//��Ʒ�����������
	private String brand_name;//Ʒ������
	private String category_name;//��������
	 private CommodityParam commodityParam;//��Ʒ����  ��Ʒ�Ͳ�Ʒ������һ��һ��ʵ�壩
	 private int quantity;
	 private int fid;
	 private double totalMoney;
	private List<Flavor> flavorList;
	
	public List<Flavor> getFlavorList() {
		return flavorList;
	}
	public void setFlavorList(List<Flavor> flavorList) {
		this.flavorList = flavorList;
	}
	public int getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}
	public int getCategory_parentid() {
		return category_parentid;
	}
	public void setCategory_parentid(int category_parentid) {
		this.category_parentid = category_parentid;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
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
	public double getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(double original_price) {
		this.original_price = original_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	public int getParam_id() {
		return param_id;
	}
	public void setParam_id(int param_id) {
		this.param_id = param_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public CommodityParam getCommodityParam() {
		return commodityParam;
	}
	public CommodityParam setCommodityParam(CommodityParam commodityParam) {
		return this.commodityParam = commodityParam;
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
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
