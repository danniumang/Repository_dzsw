package com.demo.entity;

import java.util.List;

public class SysUser {
	 private String userid;
	    private String uname;
	    private String usex;
	    private String password;
	    private List<SysRole> sysRoles;
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getUsex() {
			return usex;
		}
		public void setUsex(String sex) {
			this.usex = sex;
		}
		public String toString() {
			return "User= [uid="+userid+",uname="+uname+",usex="+usex+"]";
			
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public List<SysRole> getSysRoles() {
			return sysRoles;
		}
		public void setSysRoles(List<SysRole> sysRoles) {
			this.sysRoles = sysRoles;
		}
		
}
