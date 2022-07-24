package com.demo.entity;

public class GoodsType {
    private String gstypeid;
    private String typeName;
	public String getGstypeid() {
		return gstypeid;
	}
	public void setGstypeid(String gstypeid) {
		this.gstypeid = gstypeid;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String toString() {
		return "goodsType : gstypeid= "+"gstypeid"+" typeName"+typeName;
	}
}
