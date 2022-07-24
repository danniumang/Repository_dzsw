package com.demo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.dao.SysRoleDao;
import com.demo.entity.SysRole;
@Controller
public class SysRoleController {
	private static final Log logger =LogFactory.getLog(SysRoleController.class);
	@Autowired
    private SysRoleDao sysRoleDao;
	@RequestMapping("/selectRole")
	public String select(SysRole sysRole,Model model) {
		List<SysRole>list=sysRoleDao.selectRoleByname(sysRole);
		logger.info(list);
		model.addAttribute("roleList",list);
		return "roleList";
	}
    
    
}
