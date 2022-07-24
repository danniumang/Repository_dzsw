package com.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Focus {
    private String focurid;
    private String goodid;
    private String buserid;
    private Timestamp focustime;
	public String getFocurid() {
		return focurid;
	}
	public void setFocurid(String focurid) {
		this.focurid = focurid;
	}
	public String getGoodid() {
		return goodid;
	}
	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}
	public String getBuserid() {
		return buserid;
	}
	public void setBuserid(String buserid) {
		this.buserid = buserid;
	}
	public Date getFocustime() {
		return focustime;
	}
	public void setFocustime(Timestamp focustime) {
		this.focustime = focustime;
	}
}
