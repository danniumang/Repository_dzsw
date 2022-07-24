package com.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Notice {
    private String noticeid;
    private String ntitle;
    private String ncontent;
    private Timestamp ntime;
	public String getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNtime() {
		return ntime;
	}
	public void setNtime(Timestamp ntime) {
		this.ntime = ntime;
	}
}
