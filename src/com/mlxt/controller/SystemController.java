package com.mlxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlxt.pojo.Policeman;
import com.mlxt.pojo.User;

/**
 * Filename: SystemController.java
 * 
 * ��ϵͳ���Ʋ�
 * 
 * @author Luor
 * @version 1.0
 */

@Controller
@RequestMapping("/mlxt")
public class SystemController {
	
	/**
	 * ����ҳ
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public String systemIndex(HttpSession session, Model model) {
		User user = (User) session.getAttribute("USER_SESSION");
		Policeman policeman = (Policeman) session.getAttribute("POLICE_SESSION");
		if (user != null) {
			model.addAttribute("user", user);
		} else if (policeman != null) {
			model.addAttribute("police", policeman);
		}
		return "systemIndex";
	}
	
	/**
	 * ����������
	 * @param session
	 * @return
	 */
	@RequestMapping("/about")
	public String systemAbout(HttpSession session, Model model) {
		User user = (User) session.getAttribute("USER_SESSION");
		Policeman policeman = (Policeman) session.getAttribute("POLICE_SESSION");
		if (user != null) {
			model.addAttribute("user", user);
		} else if (policeman != null) {
			model.addAttribute("police", policeman);
		}
		return "about";
	}
}
