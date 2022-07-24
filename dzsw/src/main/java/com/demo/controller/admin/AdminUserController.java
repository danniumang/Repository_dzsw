package com.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.admin.AdminUserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController{
	@Autowired
	private AdminUserService adminUserService;
	@RequestMapping("/userInfo")
	public String userInfo(Model model) {
		return adminUserService.userInfo(model);
	}
	@RequestMapping("/deleteuserManager")
	public  String deleteuserManager(String buserid) {
		return adminUserService.deleteuserManager(buserid);
	}

}
