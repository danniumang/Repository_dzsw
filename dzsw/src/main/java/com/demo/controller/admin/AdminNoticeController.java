package com.demo.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Notice;
import com.demo.service.admin.AdminNoticeService;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController{
	@Autowired
    private AdminNoticeService adminNoticeService;
	@RequestMapping("/toAddNotice")
	public String toAddNotice(Model model) {
		return adminNoticeService.toAddNotice(model);
	}
	@RequestMapping("/toDeleteNotice")
	public String todeleteNotice(Model model) {
		return adminNoticeService.toDeleteNotice(model);
		
	}
	@RequestMapping("/deleteNoticeSelect")
	public String deleteNoticeSelect(String noticeid,Model model) {
		return adminNoticeService.deleteNoticeSelect(noticeid,model);
		
	}
	@RequestMapping("/addNotice")
	public String addNotice(Notice notice,Model model,HttpSession session) {
		return adminNoticeService.addNotice(notice,model,session);
	}
	@RequestMapping("/deleteNotices")
	public String deleteNotices(String noticeids[],Model  model) {
		return adminNoticeService.deleteNotices(noticeids,model);
	}
	@RequestMapping("/selectNotices")
	public String selectNotices(Model model,Integer pageCur,String act) {
		return adminNoticeService.selectNotices(model,pageCur,act);
	}
	@RequestMapping("/selectANotice")
	public String selectANotice(Model model,String noticeid) {
		return adminNoticeService.selectANotice(model,noticeid);
	}
}
