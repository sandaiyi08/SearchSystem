package com.mlxt.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mlxt.pojo.Manager;
import com.mlxt.service.ManagerService;

/**
 * Filename: ManagerController.java
 * 
 * ·管理员控制层
 * 
 * @author Luor
 * @version 1.0
 */

@Controller
@RequestMapping("/mlxt/manage")
public class ManagerController {
	
	private ManagerService managerService;
	
	private String indexPath;
	
	@RequestMapping("/login")
	public String managerLogin(@Param("account")String account, @Param("password")String password, 
			Model model, RedirectAttributesModelMap modelMap, HttpSession session) {
		Manager manager = null;
		if(account != null && account !="" && password != null && password != "") {
			manager = this.managerService.findManager(account, password);
		}else {
			return "adminLogin";
		}
		if(manager != null) {
			session.setAttribute("Manager_SESSION", manager);
			modelMap.addFlashAttribute("manager",manager);
			return "redirect:index";
		}
		model.addAttribute("msg", "账号或密码输入错误！");
		return "adminLogin";
	}
	
	@RequestMapping("/logout")
	public String managerLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index";
	}
}
