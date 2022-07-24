package com.demo.controller.admin;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Auser;
import com.demo.service.admin.AdminService;
 
@Controller
public class AdminController {
	private static Logger logger = Logger.getLogger(AdminController.class.getName());
	@Autowired
	private AdminService adminService;
	@RequestMapping("/admin")
	public String tologin(@ModelAttribute("auser") Auser auser) {
		logger.info(auser);
		return "admin/login";//jsp
		
	}
	@RequestMapping("/adminlogin")
	public String login(@ModelAttribute("auser") Auser auser,Model model,HttpSession session) {
		logger.info("*************"+adminService.login(auser, model, session));
		return adminService.login(auser, model, session);
	}
	@RequestMapping("/exit")
	public String exit(@ModelAttribute("auser") Auser auser,HttpSession session) {
		session.invalidate();
		return "admin/login";
	}

}
