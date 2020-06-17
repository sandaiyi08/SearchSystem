package com.mlxt.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mlxt.pojo.User;
import com.mlxt.service.UserService;

/**
 * Filename: UserController.java
 * 
 * ·用户控制层
 * 
 * @author Luor
 * @version 1.0
 */

@Controller
@RequestMapping("/mlxt/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private String indexPath;
	private String userPath;
	
	@RequestMapping("/login")
	public String userLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userLogin";
	}
	
	@RequestMapping("/login.do")
	public String userLogin(@Param("tel") String tel, @Param("password") String password, String radio,
			Model model, RedirectAttributesModelMap modelMap, HttpSession session, HttpServletResponse response) {
		indexPath = (String) session.getAttribute("indexPath");
		userPath = (String) session.getAttribute("userPath");
		User user = null;
		if (tel != null && tel != "" && password != null && password != "") {
			user = (User) this.userService.findUser(tel, password);
		} else {
			return "userLogin";
		}
		if (user != null) {
			session.setAttribute("User_SESSION", user);
			modelMap.addFlashAttribute("user", user);
			return "redirect:" + userPath + "message";
		}
		model.addAttribute("msg", "账号或密码输入错误！");
		return "userLogin";
	}

	@RequestMapping("/logout")
	public String userLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index";
	}
	
	@RequestMapping("/register")
	public String userRegisterPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userRegister";
	}
	
	@RequestMapping("/register.do")
	@ResponseBody
	public String userRegister(User user, Model model, RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		Integer rows = 0;
		if (user != null && user.getTel() != null && user.getTel() != "" && user.getPassword() != null 
				&& user.getPassword() != "") {
			rows = this.userService.insertUser(user);
		} else {
			model.addAttribute("msg", "用户名或密码不能为空！");
			return "Fail";
		}
		if (rows > 0) {
			session.setAttribute("User_SESSION", user);
			modelMap.addFlashAttribute("user", user);
			return "OK";
		}
		model.addAttribute("msg", "注册失败！");
		return "Fail";
	}
	
	@RequestMapping("/message")
	public String userMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userMes";
	}
	
	@RequestMapping("/oldMes")
	public String oldMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "oldMes";
	}
	
	@RequestMapping("/collect")
	public String userInfoCollect(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "infoCollect";
	}
}
