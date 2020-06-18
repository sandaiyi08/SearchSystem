package com.mlxt.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mlxt.pojo.Policeman;
import com.mlxt.service.PolicemanService;

/**
 * Filename: PolicemanController.java
 * 
 * ·警察控制层
 * 
 * @author Luor
 * @version 1.0
 */

@Controller
@RequestMapping("/mlxt/police")
public class PolicemanController {
	
	@Autowired
	private PolicemanService policemanService;
	
	private String indexPath;
	private String policePath;
	
	/**
	 * ·警察登录界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String policeLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "policeLogin";
	}
	
	/**
	 * ·警察登录方法
	 * @param account
	 * @param password
	 * @param radio
	 * @param model
	 * @param modelMap
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping("/login.do")
	public String policeLogin(@Param("account") String account, @Param("password") String password, String radio,
			Model model, RedirectAttributesModelMap modelMap, HttpSession session, HttpServletResponse response) {
		indexPath = (String) session.getAttribute("indexPath");
		policePath = (String) session.getAttribute("policePath");
		Policeman policeman = null;
		if (account != null && account != "" && password != null && password != "") {
			policeman = (Policeman) this.policemanService.findPolice(account, password);
		} else {
			return "policeLogin";
		}
		if (policeman != null) {
			session.setAttribute("Police_SESSION", policeman);
			modelMap.addFlashAttribute("police", policeman);
			return "redirect:" + policePath + "find";
		}
		model.addAttribute("msg", "账号或密码输入错误！");
		return "policeLogin";
	}

	/**
	 * ·警察登出
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String policeLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index.jsp";
	}
	
	/**
	 * ·上传老人图像界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/find")
	public String policeFind(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "findOldMan";
	}
	
	/**
	 * ·返回查询结果界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/findResult")
	public String policeResult(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "findOldManInfo";
	}
	
	/**
	 * ·警察信息界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/message")
	public String policeMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "policeMessage";
	}
}
