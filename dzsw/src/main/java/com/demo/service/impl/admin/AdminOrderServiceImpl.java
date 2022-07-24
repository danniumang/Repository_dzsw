package com.demo.service.impl.admin;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.demo.dao.AdminOrderDao;
import com.demo.service.admin.AdminOrderService;
@Service
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService {
	private static final Log logger =LogFactory.getLog(AdminOrderServiceImpl.class);
	@Autowired
    private AdminOrderDao adminOrderDao;
	@Override
	public String orderInfo(Model model) {
		// TODO Auto-generated method stub
		List<Map<String,Object>>list=adminOrderDao.orderInfo();
		logger.info(list);
		model.addAttribute("orderList",list);
		return "admin/orderManager";
	}

	@Override
	public String deleteorderManager(String orderid) {
		// TODO Auto-generated method stub
		/* 明细表 */
		adminOrderDao.deleteOrderDetail(orderid);
		/* 订单表 */
		adminOrderDao.deleteOrderBase(orderid);
		return "forward:/adminOrder/orderInfo";
	}

}
