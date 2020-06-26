package com.mlxt.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mlxt.pojo.Manager;
import com.mlxt.pojo.Policeman;
import com.mlxt.pojo.User;
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
	
	@Autowired
	private ManagerService managerService;
	
	private String indexPath;
	private String managePath;
	
	/**
	 * ·管理员主页
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public String manageIndex(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "adminIndex";
	}
	
	/**
	 * ·管理员登录界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String manageLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "adminLogin";
	}
	
	/**
	 * ·管理员登录方法
	 * @param account
	 * @param password
	 * @param model
	 * @param modelMap
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping("/login.do")
	public String managerLogin(@Param("account")String account, @Param("password")String password, 
			Model model, RedirectAttributesModelMap modelMap, HttpSession session, HttpServletResponse response) {
		indexPath = (String) session.getAttribute("indexPath");
		managePath = (String) session.getAttribute("managePath");
		Manager manager = null;
		if(account != null && account !="" && password != null && password != "") {
			manager = (Manager) this.managerService.findManager(account, password);
		}else {
			return "adminLogin";
		}
		if(manager != null) {
			session.setAttribute("Manager_SESSION", manager);
			modelMap.addFlashAttribute("manager",manager);
			return "redirect:" + managePath + "index";
		}
		model.addAttribute("msg", "账号或密码输入错误！");
		return "adminLogin";
	}
	
	/**
	 * ·管理员登出
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String managerLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index";
	}
	
	/**
	 * ·用户管理界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/manageUser")
	public String managePeople(User user, @RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="5")Integer rows, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		model.addAttribute("page", this.managerService.findUserPage(user, page, rows));
		return "adminPeople";
	}
	
	/**
	 * ·警察管理界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/managePolice")
	public String managePolice(Policeman policeman, @RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="5")Integer rows, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		model.addAttribute("page", this.managerService.findPolicePage(policeman, page, rows));
		return "adminPolice";
	}
	
	/**
	 * ·用户信息界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/peopleMessage")
	public String peopleMessage(User user, @RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="5")Integer rows, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		model.addAttribute("page", this.managerService.findUserPage(user, page, rows));
		return "peopleMessage";
	}
	
	/**
	 * ·警察信息界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/policeMessage")
	public String policeMessage(Policeman policeman, @RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="5")Integer rows, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		model.addAttribute("page", this.managerService.findPolicePage(policeman, page, rows));
		return "policeMessage";
	}
	
	@RequestMapping("/modifyUser.do")
	@ResponseBody
	public String userModify(User user, Model model, RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		Integer rows = 0;
		if (user != null) {
			rows = this.managerService.updateUser(user);
		} else {
			model.addAttribute("msg", "用户信息数据不能全为空！");
			return "Fail";
		}
		if (rows > 0) {
			
			return "OK";
		}
		model.addAttribute("msg", "用户信息修改失败！");
		return "Fail";
	}
	
	@RequestMapping("/addPolice.do")
	@ResponseBody
	public String addPoliceman(Policeman policeman, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		Integer rows = 0;
		if (policeman != null && policeman.getAccount() != null && policeman.getAccount() != "" 
				&& policeman.getPassword() != null && policeman.getPassword() != "") {
			rows = this.managerService.insertPoliceman(policeman);
		} else {
			model.addAttribute("msg", "警察数据不能为空！");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "警察账号添加错误！");
		return "Fail";
	}
	
	@RequestMapping("/delPolice.do")
	@ResponseBody
	public String delPoliceman(String account, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		Integer rows = 0;
		if (account != null && account != "") {
			rows = this.managerService.deletePolice(account);
		} else {
			model.addAttribute("msg", "警察账号数据错误！");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "警察账号数据错误！");
		return "Fail";
	}
}
