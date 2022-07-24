package com.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.entity.SysRole;

@Repository("sysRoleDao")
@Mapper
public interface SysRoleDao  {

	List<SysRole> selectRoleByname(SysRole sysRole);

}
