package com.icss.Snack.entity;

public class CommodityParam {
	private int param_id;//主键
	private String type;//产品类型
	private String product_area;//原料产地
	private String product_place;//产地
	private String product_specification;//产品规格
	private String expiration_date;//保质期
	private String usage;//食用方法
	private String storage_method;//储存方法
	private String standard_number;//产品标准号
	private String license_number;//生产许可证编号
	public int getParam_id() {
		return param_id;
	}
	public void setParam_id(int param_id) {
		this.param_id = param_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct_area() {
		return product_area;
	}
	public void setProduct_area(String product_area) {
		this.product_area = product_area;
	}
	public String getProduct_place() {
		return product_place;
	}
	public void setProduct_place(String product_place) {
		this.product_place = product_place;
	}
	public String getProduct_specification() {
		return product_specification;
	}
	public void setProduct_specification(String product_specification) {
		this.product_specification = product_specification;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getStorage_method() {
		return storage_method;
	}
	public void setStorage_method(String storage_method) {
		this.storage_method = storage_method;
	}
	public String getStandard_number() {
		return standard_number;
	}
	public void setStandard_number(String standard_number) {
		this.standard_number = standard_number;
	}
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}

}
