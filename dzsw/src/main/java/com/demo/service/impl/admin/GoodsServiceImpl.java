package com.demo.service.impl.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.dao.GoodsDao;
import com.demo.entity.Goods;
import com.demo.service.admin.GoodsService;
import com.demo.util.MyUtil;
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	private static final Log logger =LogFactory.getLog(GoodsServiceImpl.class);
	@Autowired
    private GoodsDao goodsDao;
	
	@Override
	public String addorUpdateGoods(Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addorUpdateGoods(Goods goods, HttpServletRequest request, String updateAct) {
		// TODO Auto-generated method stub
		//储存图片信息，图片非text需要特殊处理。
		//request.setAttribute("goodsType", goodsDao.goodsType());
		String newFileName="";
		String fileName=goods.getLogoImage().getOriginalFilename();
		if(fileName.length()>0) {
			String realPath=MyUtil.imgePath();//request.getServletContext().getRealPath("logos");
			String fileType=fileName.substring(fileName.lastIndexOf("."));
			newFileName=MyUtil.getStringID()+fileType;
			goods.setGricture(newFileName);//goods 图片名称
			File targerFile=new File(realPath,newFileName);
			if(!targerFile.exists()) {
				targerFile.mkdir();
			}
			try {
				goods.getLogoImage().transferTo(targerFile);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			 
		}
		//修改
		if("update".equals(updateAct)) {
			logger.info("update(((((((**********");
			//修改到数据库
			if(goodsDao.updateGoodsById(goods)>0) {
				logger.info("goodsDao.updateGoodsById(goods)>0");
				return "forward:/adminGoods/selectGoods?act=updateSelect";
			}else {
				return "return /adminGoods/updateAgoods";
			}
		}else {
			if(goodsDao.addGoods(goods)>0) {
				return "forward:/adminGoods/selectGoods";
			}else {
				return "cart/addCard";
			}
		}
		
	}
	@Override
	public String selectGoods(Model model, Integer pageCur, String act) {
		// TODO Auto-generated method stub
		List<Goods>allGoods=goodsDao.selectGoods();
		logger.info(allGoods+" and pageCur"+pageCur);
		int temp=allGoods.size();
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
		allGoods=goodsDao.selectAllGoodsByPage(map);
		model.addAttribute("allGoods",allGoods);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("pageCur",pageCur);
		
		if("deleteSelect".equals(act)) {
			return "admin/deleteSelectGoods";
		}else if("updateSelect".equals(act)) {
			logger.info("admin/updateSelectGoods");
			return "admin/updateSelectGoods";
		}else {
		return "admin/selectGoods";
		}
	}
	@Override
	public String selectAGoods(Model model, String id, String act) {
		// TODO Auto-generated method stub
		Goods goods=goodsDao.selectGoodsById(id);
		model.addAttribute("goods",goods);
		model.addAttribute("goodsType", goodsDao.goodsType());
		model.addAttribute("imgaePath",MyUtil.imgePath());
		if("updateAgoods".equals(act)) {
			logger.info("updateAgoods");
			return "admin/updateAgoods";
		}
		return "admin/goodsDetail";
	}
	/**
	 *批量删除
	 */
	@Override
	public String deleteGoods(String[] goodids, Model model) {
		// TODO Auto-generated method stub
		List<String>list=new ArrayList<String>();
		for(int i=0;i<goodids.length;i++) {
			if(goodsDao.selectCartGoods(goodids[i]).size()>0||goodsDao.selectFocusGoods(goodids[i]).size()>0||goodsDao.selectOrderdetailGoods(goodids[i]).size()>0) {
				model.addAttribute("msg","商品有关联，不允许删除！");
				return "forward:/adminGoods/selectGoods?act=deleteSelect";
			}
			list.add(goodids[i]);
		}
		int count=goodsDao.deleteGoods(list);
		model.addAttribute("msg","删除商品成功,共删除商品 ： "+count);
		return "forward:/adminGoods/selectGoods?act=deleteSelect";
	}
	/**
	 *单一删除
	 *
	 */
	@Override
	public String deleteAGoods(String goodid, Model model) {
		// TODO Auto-generated method stub

			if(goodsDao.selectCartGoods(goodid).size()>0||goodsDao.selectFocusGoods(goodid).size()>0||goodsDao.selectOrderdetailGoods(goodid).size()>0) {
				model.addAttribute("msg","商品有关联，不允许删除！");
				return "forward:/adminGoods/selectGoods?act=deleteSelect";
			}	
		
		goodsDao.deleteAGoods(goodid);
		model.addAttribute("msg","删除商品成功");
		return "forward:/adminGoods/selectGoods?act=deleteSelect";
	}

}
