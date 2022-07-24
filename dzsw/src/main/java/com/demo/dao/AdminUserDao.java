package com.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.entity.Buser;

@Mapper
@Repository("adminUserDao")
public interface AdminUserDao {

	List<Buser> userInfo();

	void deleteuserById(String buserid);

}
