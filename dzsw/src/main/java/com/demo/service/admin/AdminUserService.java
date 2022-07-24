package com.demo.service.admin;

import org.springframework.ui.Model;

public interface AdminUserService {

	public String userInfo(Model model);

	public String deleteuserManager(String buserid);

}
