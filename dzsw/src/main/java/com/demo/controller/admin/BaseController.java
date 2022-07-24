package com.demo.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.exception.AdminLoginNoException;

@Controller
public class BaseController {
	/**
	 *@param session
	 *@param request
	 *@throws AdminLoginNoException
	 *前台用户登录权限控制，在处理方法执行钱执行该方法
	 */
	@ModelAttribute
    public void isLogin(HttpSession session,HttpServletRequest request) throws AdminLoginNoException{
    	if(session.getAttribute("auser")==null) {
    		throw new AdminLoginNoException("没有登录");
    	}
    }
}
