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
 * ��������Ʋ�
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
	
	@RequestMapping("/login")
	public String policeLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "policeLogin";
	}
	
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
			session.setAttribute("Policeman_SESSION", policeman);
			modelMap.addFlashAttribute("policeman", policeman);
			return "redirect:" + policePath + "find";
		}
		model.addAttribute("msg", "�˺Ż������������");
		return "policeLogin";
	}

	@RequestMapping("/logout")
	public String policeLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index";
	}
	
	@RequestMapping("/find")
	public String policeFind(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "findOldMan";
	}
	
	@RequestMapping("/findResult")
	public String policeResult(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "findOldManInfo";
	}
	
	@RequestMapping("/message")
	public String policeMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "policeMessage";
	}
}
