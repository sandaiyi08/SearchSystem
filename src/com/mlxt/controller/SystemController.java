package com.mlxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String systemIndex(HttpSession session) {
		return "systemIndex";
	}
	
	/**
	 * ����������
	 * @param session
	 * @return
	 */
	@RequestMapping("/about")
	public String systemAbout(HttpSession session) {
		return "about";
	}
}
