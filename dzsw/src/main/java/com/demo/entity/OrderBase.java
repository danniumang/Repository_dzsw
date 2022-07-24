package com.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class OrderBase {
    private String orderid;
    private String buserid;
    private int amount;
    private String status;
    private Timestamp orderDate;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getBuserid() {
		return buserid;
	}
	public void setBuserid(String buserid) {
		this.buserid = buserid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
}
