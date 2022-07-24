package com.demo.controller.before;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.exception.UserLOginNoException;

@Controller
public class BaseBefooreController {
	
	/**
	 *@param session
	 *@param request
	 *@throws UserLOginNoException
	 *前台用户登录权限控制，在处理方法执行钱执行该方法。
	 */
	@ModelAttribute
    public void isLogin(HttpSession session,HttpServletRequest request) throws UserLOginNoException {
    	if(session.getAttribute("bruser")==null) {
    		throw new UserLOginNoException("没有登录");
    	}
    }

}
