package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.SysUserDao;
import com.demo.entity.SysRole;
import com.demo.entity.SysUser;
import com.demo.service.UserService;
import com.demo.service.impl.admin.AdminOrderServiceImpl;
@Service("userService")
@Transactional//接受spring事务管理
public class UserServiceImpl implements UserService {
	private static final Log logger =LogFactory.getLog(UserServiceImpl.class);
	@Autowired
    private SysUserDao sysUserDao;
	@Override
	public List<Map<String, Object>> selectUserByUname(SysUser user) {
		// TODO Auto-generated method stub
		return sysUserDao.selectUserByUname(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SysUser sysUser=sysUserDao.findByName(username);
		if(sysUser==null) { logger.info("sysuser is null");  return null;}
		logger.info(sysUser);
		List<SimpleGrantedAuthority>authorities=new ArrayList<SimpleGrantedAuthority>();
		for(SysRole role:sysUser.getSysRoles()) {//这里处理一下，获得当前用户的角色信息。多对多sql语句更改
			logger.info("roleTest "+role.getRoleName());
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		//if(sysUser.getUname().equals("liuyujie")) {authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));}
		UserDetails userDetails = new User(sysUser.getUname(), /* "{noop}" +*/sysUser.getPassword(),authorities);
		logger.info(userDetails);
	return userDetails;
	}
	@Override
	public SysUser checkSysUser(SysUser user) {
		// TODO Auto-generated method stub
		SysUser sysUser=sysUserDao.checkSysUser(user);
		if(sysUser!=null)
		return sysUser;
		else
			return null;
	}

}
