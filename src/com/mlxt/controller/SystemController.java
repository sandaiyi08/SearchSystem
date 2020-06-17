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
	
	@RequestMapping("/index")
	public String systemIndex(HttpSession session) {
		return "index";
	}
}
