package com.demo.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.demo.entity.Notice;

public interface AdminNoticeService {

public 	String toAddNotice(Model model);

public String deleteNoticeSelect(String noticeid,Model model);

public String addNotice(Notice notice, Model model, HttpSession session);

public String toDeleteNotice(Model model);

public String deleteNotices(String[] noticeids, Model model);

public String selectNotices(Model model, Integer pageCur, String act);

public String selectANotice(Model model, String noticeid);

}
