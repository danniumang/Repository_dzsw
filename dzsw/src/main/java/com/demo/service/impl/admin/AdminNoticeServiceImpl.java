package com.demo.service.impl.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.dao.AdminNoticeDao;
import com.demo.entity.Notice;
import com.demo.service.admin.AdminNoticeService;
@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {
	private static final Log logger =LogFactory.getLog(AdminNoticeServiceImpl.class);
	@Autowired
    private AdminNoticeDao adminNoticeDao;
	@Override
	public String toAddNotice(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allNotice", adminNoticeDao.selectAllNotices());
		//logger.info(goodsTypeDao.selectGoodsType().toString());
		return "admin/addNotice";//转至 addNotice.jsp
	}

	@Override
	public String deleteNoticeSelect(String noticeid,Model model) {
		// TODO Auto-generated method stub
		if(adminNoticeDao.deleteNotice(noticeid)>0) {
			model.addAttribute("msg","公告删除成功");
		}
		return "forward:/adminNotice/toDeleteNotice";
	}

	@Override
	public String addNotice(Notice notice,Model model, HttpSession session) {
		// TODO Auto-generated method stub
		adminNoticeDao.addNotice(notice);
		return "forward:/adminNotice/toAddNotice";
	}

	@Override
	public String toDeleteNotice(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allNotices",adminNoticeDao.selectAllNotices());
		return "admin/deleteNoticeSelect";
	}

	@Override
	public String deleteNotices(String[] noticeids, Model model) {
		// TODO Auto-generated method stub
		List<String>list=new ArrayList<String>();
		for(int i=0;i<noticeids.length;i++) {
			list.add(noticeids[i]);
		}
		int count=adminNoticeDao.deleteNotices(list);
		model.addAttribute("msg","删除公告成功，共删除公告"+count);
		return "forward:/adminNotice/toDeleteNotice";
	}

	@Override
	public String selectNotices(Model model, Integer pageCur,String act) {
		// TODO Auto-generated method stub
		List<Notice>allNotices=adminNoticeDao.selectAllNotices();
		logger.info(allNotices+" and pageCur"+pageCur);
		int temp=allNotices.size();
		logger.info("temp************"+temp);
		model.addAttribute("totalCount",temp);
		int totalPage=0;
		if(temp==0) {
			totalPage=0;
		}else {
			totalPage=(int) Math.ceil((double)temp/10);
		}
		if(pageCur==null) {
			pageCur=1;
		}
		if((pageCur-1)*10>temp) {
			pageCur=pageCur-1;
		}
		/* 分页查询 */
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("startIndex", (pageCur-1)*10+1);
		map.put("perPageSize", pageCur*10);
		allNotices=adminNoticeDao.selectAllNoticesByPage(map);
		model.addAttribute("allNotices",allNotices);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("pageCur",pageCur);
		if("deleteSelect".equals(act)) {
		return "admin/deleteNoticeSelect";
		}else {
			return "admin/selectNotices";
		}
	}

	@Override
	public String selectANotice(Model model, String noticeid) {
		// TODO Auto-generated method stub
		Notice notice=adminNoticeDao.selectNoticeById(noticeid);
		model.addAttribute("notice",notice);
		return "admin/NoticeDetail";
	}

}
