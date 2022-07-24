package com.demo.service.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.dao.AdminUserDao;
import com.demo.service.admin.AdminUserService;
@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired
	private AdminUserDao adminUserDao;

	@Override
	public String userInfo(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("userList", adminUserDao.userInfo());
		return "admin/userManager";
	}

	@Override
	public String deleteuserManager(String buserid) {
		// TODO Auto-generated method stub
		adminUserDao.deleteuserById(buserid);
		return "forward:/adminUser/userInfo";
	}

}
