package com.demo.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Goods;
import com.demo.service.admin.GoodsService;
import com.demo.service.admin.GoodsTypeService;

@Controller
@RequestMapping("/adminGoods")
public class GoodsController extends BaseController{
	private static final Log logger =LogFactory.getLog(GoodsController.class);
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	@RequestMapping("/toAddGoods")
	public String toAddGoods(Model model) {
		model.addAttribute("goods",new Goods());
		model.addAttribute("goodsType",goodsTypeService.selectSessionGoodsType());
		return "admin/addGoods";
	}
	@RequestMapping("/addGoods")
	public String addGoods(@ModelAttribute("goods") Goods goods,HttpServletRequest request,String updateAct) {
		return goodsService.addorUpdateGoods(goods,request,updateAct);
	}
	@RequestMapping("/selectGoods")
	public  String selectGoods(Model model,Integer pageCur,String act) {
		logger.info("pageCur:"+pageCur);
		return goodsService.selectGoods(model, pageCur, act);	
	}
	@RequestMapping("/selectAGoods")
	public String selectAGoods(Model model,String goodid,String act) {
		return goodsService.selectAGoods(model, goodid, act);
	}
	@RequestMapping("/deleteGoods")
    public String deleteGoods(String goodids[],Model model) {
    	return goodsService.deleteGoods(goodids,model);
    }
	@RequestMapping("/deleteAGoods")
    public String deleteAGoods(String goodid,Model model) {
    	return goodsService.deleteAGoods(goodid,model);
    }
}
