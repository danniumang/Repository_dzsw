package com.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.demo.entity.Buser;

public class MyUtil {
    /**
     *@return
     *获得时间字符串
     */
    public static String getStringID() {
    	String id="";
    	Date date=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	id=sdf.format(date);
    	return id;
    }
    /**
     *@param session
     *@return
     *获得用户id
     */
    public static String getBuserid(HttpSession session) {
    	Buser buser=(Buser) session.getAttribute("buser");
    	return buser.getBuserid();
    }
    
    public static String imgePath() {
    	return "D:"+System.getProperty("file.separator")+"dzsw"+System.getProperty("file.separator")+"logos";
    }
}
