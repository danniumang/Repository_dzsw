package com.demo.entity;

public class OrderDetail {
   private String orderDetailid;
   private String orderid;
   private String goodid;
   private int shoppingNum;
public String getOrderDetailid() {
	return orderDetailid;
}
public void setOrderDetailid(String orderDetailid) {
	this.orderDetailid = orderDetailid;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public String getGoodid() {
	return goodid;
}
public void setGoodid(String goodid) {
	this.goodid = goodid;
}
public int getShoppingNum() {
	return shoppingNum;
}
public void setShoppingNum(int shoppingNum) {
	this.shoppingNum = shoppingNum;
}
}
