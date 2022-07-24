package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.SysUser;
import com.demo.service.UserService;
@Controller("sysUserController")
public class SysUserController {
	private static final Log logger =LogFactory.getLog(SysUserController.class);
	@Autowired
    private UserService userService;
	@RequestMapping("/selectUser")
	public String select(SysUser user,Model model) {
		List<Map<String,Object>>list=userService.selectUserByUname(user);
		model.addAttribute("sysuserList",list);
		logger.info(list);
		
		return "userList";
	}
	@RequestMapping("/login")
	@Secured({"permitAll()"})
	public String login(SysUser user,Model model) {
		SysUser sysuser=userService.checkSysUser(user);
		if(sysuser!=null) {
		//model.addAttribute("sysuser",sysuser);
logger.info("in the login"+sysuser);
		
		return "index";
		}
		else {
		logger.info("error 登录错误重新登录"+sysuser);
		
		return "login";
		}
	}
    
}
