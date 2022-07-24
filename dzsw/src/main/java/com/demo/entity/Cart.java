package com.demo.entity;

public class Cart {
    private String cartid;
    private String buserid;
    private String goodid;
    private  int shoppingnum;
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getBuserid() {
		return buserid;
	}
	public void setBuserid(String buserid) {
		this.buserid = buserid;
	}
	public String getGoodsid() {
		return goodid;
	}
	public void setGoodsid(String goodsid) {
		this.goodid = goodsid;
	}
	public int getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(int shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
}
