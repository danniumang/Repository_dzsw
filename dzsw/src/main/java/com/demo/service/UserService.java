package com.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.entity.SysUser;

public interface UserService extends UserDetailsService{
   public List<Map<String, Object>>selectUserByUname(SysUser user);
   public SysUser  checkSysUser(SysUser user);
}
