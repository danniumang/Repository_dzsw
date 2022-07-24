package com.demo.service.impl.admin;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


import com.demo.dao.AdminDao;
import com.demo.entity.Auser;
import com.demo.service.admin.AdminService;
@Service
//@Transactional
public class AdminServiceImpl implements AdminService {
	private static Logger logger = Logger.getLogger(AdminServiceImpl.class.getName());
	@Autowired
    private AdminDao adminDao;
	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		if(adminDao.login(auser)!=null) {
			session.setAttribute("auser", auser);
			logger.info(auser.toString());
			//session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
			return "admin/main";
			
		}
		model.addAttribute("msg","用户或密码错误");
		logger.info("用户或密码错误+admin/login");
		return "admin/login";
	}

}
