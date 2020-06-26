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
	public String managePeople(User user, @RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="5")Integer rows, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		model.addAttribute("page", this.managerService.findUserPage(user, page, rows));
		return "adminPeople";
	}
	
	/**
	 * ������������
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
	 * ���û���Ϣ����
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
	 * ��������Ϣ����
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
			model.addAttribute("msg", "�û���Ϣ���ݲ���ȫΪ�գ�");
			return "Fail";
		}
		if (rows > 0) {
			
			return "OK";
		}
		model.addAttribute("msg", "�û���Ϣ�޸�ʧ�ܣ�");
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
			model.addAttribute("msg", "�������ݲ���Ϊ�գ�");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "�����˺���Ӵ���");
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
			model.addAttribute("msg", "�����˺����ݴ���");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "�����˺����ݴ���");
		return "Fail";
	}
}
