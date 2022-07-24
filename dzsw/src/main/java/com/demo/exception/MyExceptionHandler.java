package com.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Auser;
import com.demo.entity.Buser;

public class MyExceptionHandler implements HandlerExceptionResolver {
    
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		Map<String,Object>model=new HashMap<String,Object>();
		model.put("ex", ex);
		
		if(ex instanceof AdminLoginNoException) {
			request.setAttribute("auser", new Auser());	
			request.setAttribute("msg", "没有登录，请登录");
			return new ModelAndView("admin/login",model);
		}else if(ex instanceof UserLOginNoException) {
			request.setAttribute("buser", new Buser());	
			request.setAttribute("msg", "没有登录，请登录");
			return new ModelAndView("/before/login",model);	
		}else {
			return new ModelAndView("/error/error",model); 
		}
	
	}

}
