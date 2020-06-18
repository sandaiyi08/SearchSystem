package com.mlxt.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mlxt.pojo.Manager;
import com.mlxt.service.ManagerService;

/**
 * Filename: ManagerController.java
 * 
 * ������Ա���Ʋ�
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
	 * ������Ա��ҳ
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public String manageIndex(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "adminIndex";
	}
	
	/**
	 * ������Ա��¼����
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String manageLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "adminLogin";
	}
	
	/**
	 * ������Ա��¼����
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
		model.addAttribute("msg", "�˺Ż������������");
		return "adminLogin";
	}
	
	/**
	 * ������Ա�ǳ�
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
	 * ���û��������
	 * @param session
	 * @return
	 */
	@RequestMapping("/manageUser")
	public String managePeople(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "adminPeople";
	}
	
	/**
	 * ������������
	 * @param session
	 * @return
	 */
	@RequestMapping("/managePolice")
	public String managePolice(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "adminPolice";
	}
	
	/**
	 * ���û���Ϣ����
	 * @param session
	 * @return
	 */
	@RequestMapping("/peopleMessage")
	public String peopleMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "peopleMessage";
	}
	
	/**
	 * ��������Ϣ����
	 * @param session
	 * @return
	 */
	@RequestMapping("/policeMessage")
	public String policeMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "policeMessage";
	}
}
