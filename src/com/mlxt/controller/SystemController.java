package com.mlxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Filename: SystemController.java
 * 
 * ·系统控制层
 * 
 * @author Luor
 * @version 1.0
 */

@Controller
@RequestMapping("/mlxt")
public class SystemController {
	
	/**
	 * ·主页
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public String systemIndex(HttpSession session) {
		return "systemIndex";
	}
	
	/**
	 * ·关于我们
	 * @param session
	 * @return
	 */
	@RequestMapping("/about")
	public String systemAbout(HttpSession session) {
		return "about";
	}
}
