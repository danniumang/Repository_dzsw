package com.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.entity.SysRole;
import com.demo.entity.SysUser;

@Repository("sysUserDao")
@Mapper
public interface SysUserDao {
	/* 接口方法对应mapping 中的sql中的id */
	/*
	 * public User selectUserById(String userId); public User
	 * selectUserByMaP(Map<String,Object>param);
	 */
	/* public List<User>selectAllUser(); */
	public List<Map<String, Object>> selectUserByUname(SysUser user);
	/*
	 * public int addUser(User user); public int updateUser(User user); public int
	 * deleteUser(String userid); public User selectUserOrdersById1(String userid);
	 * public User selectUserOrdersById2(String userid); public
	 * List<SelectUserOrdersById>selectUserOrdersById3(String userid);
	 * //*************************** public int updaste(String sql,Object[]param);
	 * public List<User>query(String sql,Object[]param);
	 */

	public SysUser checkSysUser(SysUser user);
	
	public SysUser findByName(String uname);
	
	public List<SysRole> sysRoles(String rname);
}
