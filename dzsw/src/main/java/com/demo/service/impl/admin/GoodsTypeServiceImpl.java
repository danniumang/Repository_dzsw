package com.demo.service.impl.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.controller.admin.AdminGoodsTypeController;
import com.demo.dao.GoodsTypeDao;
import com.demo.entity.GoodsType;
import com.demo.service.admin.GoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
	private static final Log logger = LogFactory.getLog(GoodsTypeServiceImpl.class);
	@Autowired
	private GoodsTypeDao goodsTypeDao;

	@Override
	public String toAddType(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allTypes", goodsTypeDao.selectGoodsType());
		logger.info(goodsTypeDao.selectGoodsType().toString());
		return "admin/addType";
	}

	@Override
	public String addType(String typename, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		goodsTypeDao.addType(typename);
		session.setAttribute("goodsType", goodsTypeDao.selectGoodsType());

		return "forward:/adminType/toAddType";// 跳转至controller中的action
	}

	@Override
	public String deleteType(String gstype, Model model) {
		// TODO Auto-generated method stub
		if (goodsTypeDao.selectGoodsByType(gstype).size() > 0) {
			model.addAttribute("msg", "类型被使用。不允许删除");
			return "forward:/adminType/toDeleteType";
		}
		if (goodsTypeDao.deleteType(gstype) > 0) {
			model.addAttribute("msg", "类型删除成功");
		}
		return "forward:/adminType/toDeleteType";
	}

	@Override
	public String toDeleteType(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("allTypes", goodsTypeDao.selectGoodsType());
		return "admin/deleteType";
	}

	@Override
	public List<GoodsType> selectSessionGoodsType() {
		// TODO Auto-generated method stub
		return goodsTypeDao.selectGoodsType();
	}

}
