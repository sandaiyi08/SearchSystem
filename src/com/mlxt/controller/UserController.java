package com.mlxt.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mlxt.pojo.User;
import com.mlxt.service.UserService;

/**
 * Filename: UserController.java
 * 
 * °§”√ªßøÿ÷∆≤„
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
	
	@RequestMapping("/login")
	public String userLogin(@Param("tel") String tel, @Param("password") String password, String radio,
			Model model, RedirectAttributesModelMap modelMap, HttpSession session, HttpServletResponse response) {
		indexPath = (String) session.getAttribute("indexPath");
		User user = null;
		if (tel != null && tel != "" && password != null && password != "") {
			user = (User) this.userService.findUser(tel, password);
		} else {
			return "userLogin";
		}
		if (user != null) {
			session.setAttribute("User_SESSION", user);
			modelMap.addFlashAttribute("user", user);
			return "redirect:" + indexPath + "index";
		}
		model.addAttribute("msg", "’À∫≈ªÚ√‹¬Î ‰»Î¥ÌŒÛ£°");
		return "userLogin";
	}

	@RequestMapping("/logout")
	public String userLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index";
	}
	
	@RequestMapping("register")
	public String userRegister(@Param("tel") String tel, @Param("password") String password, String radio,
			Model model, RedirectAttributesModelMap modelMap, HttpSession session, HttpServletResponse response) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userRegister";
	}
}
