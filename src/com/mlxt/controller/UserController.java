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

import com.mlxt.pojo.Family;
import com.mlxt.pojo.OldMan;
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
	
	/**
	 * ·用户登录界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String userLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userLogin";
	}
	
	/**
	 * ·用户登录方法
	 * @param tel
	 * @param password
	 * @param radio
	 * @param model
	 * @param modelMap
	 * @param session
	 * @param response
	 * @return
	 */
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
			Family family = new Family();
			family.setFamilyTel(tel);
			Integer oldManId = this.userService.findOldManIdByFamily(family);
			System.out.println(oldManId);
			session.setAttribute("OLDMAN_ID_SESSION", oldManId);
			modelMap.addFlashAttribute("oldManId", oldManId);
			
			return "redirect:" + userPath + "message";
		}
		model.addAttribute("msg", "账号或密码输入错误！");
		return "userLogin";
	}

	/**
	 * ·用户登出
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String userLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index.jsp";
	}
	
	/**
	 * ·用户注册界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/register")
	public String userRegisterPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userRegister";
	}
	
	/**
	 * ·用户注册方法
	 * @param user
	 * @param model
	 * @param modelMap
	 * @param session
	 * @return
	 */
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
	
	/**
	 * ·用户信息主界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/message")
	public String userMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userMes";
	}
	
	/**
	 * ·老人信息子界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/oldManMes")
	public String oldManMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "oldManMes";
	}
	
	/**
	 * ·家庭信息子界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/familyMes")
	public String familyMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "familyMes";
	}
	
	/**
	 * ·老人信息修改子界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/modifyOldMan")
	public String modifyOldMan(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "modifyOldMan";
	}
	
	/**
	 * ·家庭信息修改子界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/modifyFamily")
	public String modifyFamily(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "modifyFamily";
	}
	
	/**
	 * ·添加家庭信息子界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/addFamily")
	public String addFamilyMember(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "familyAdd";
	}
	
	/**
	 * ·删除家庭信息子界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/delFamily")
	public String delFamilyMember(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "familyDelete";
	}
	
	/**
	 * ·用户初始信息录入界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/collect")
	public String userInfoCollectPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "infoCollect";
	}
	
	/**
	 * ·用户初始信息录入方法-老人信息
	 * @param oldMan
	 * @param family
	 * @param model
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping("/collect.do")
	public String userInfoCollect(OldMan oldMan, Family family, Model model, RedirectAttributesModelMap modelMap,
			HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		userPath = (String) session.getAttribute("userPath");
		User user = (User) session.getAttribute("User_SESSION");
		Integer rows = 0;
		if (oldMan != null && oldMan.getName() != null && oldMan.getName() != "" && oldMan.getAddress() != null
				&& oldMan.getAddress() != "" && oldMan.getImgPath() != null && oldMan.getAddress() != "") {
			rows = this.userService.insertOldMan(oldMan);
		} else {
			model.addAttribute("msg", "老人信息数据不能为空！");
			return "redirect:" + userPath + "collect";
		}
		if (rows > 0) {
			oldMan.setId(this.userService.findOldManIdByOldMan(oldMan));
			family.setOldManId(oldMan.getId());
			rows = 0;
			if (family != null && family.getFamilyName() != null && family.getFamilyName() != ""
					&& family.getFamilyTel() != null && family.getFamilyTel() != "" && family.getOldManId() != null
					&& family.getOldManId() > 0) {
				rows = this.userService.insertFamily(family);
				if (rows > 0) {
					rows = this.userService.insertFamily(new Family(user.getTel(), user.getTel(), oldMan.getId()));
				}
			} else {
				model.addAttribute("msg", "家庭成员数据不能为空！");
				return "redirect:" + userPath + "collect";
			}
			session.setAttribute("OLDMAN_ID_SESSION", oldMan.getId());
			modelMap.addFlashAttribute("oldManId", oldMan.getId());
			if (rows > 0) {
				return "redirect:" + userPath + "message";
			}
			model.addAttribute("msg", "家庭成员信息错误！");
			return "redirect:" + userPath + "collect";
		}
		model.addAttribute("msg", "添加失败！");
		return "redirect:" + userPath + "collect";
	}
	
	/**
	 * ·用户初始信息录入方法-家庭信息
	 * @param family
	 * @param model
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping("/collectFamily.do")
	@ResponseBody
	public String userFamilyInfoCollect(Family family, Model model, RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		userPath = (String) session.getAttribute("userPath");
		Integer oldManId = (Integer) session.getAttribute("OLDMAN_ID_SESSION");
		if(oldManId != null) {
			family.setOldManId(oldManId);
			Integer rows = 0;
			if (family != null && family.getFamilyName() != null && family.getFamilyName() != "" 
					&& family.getFamilyTel() != null && family.getFamilyTel() != "" && family.getOldManId() != null 
					&& family.getOldManId() > 0) {
				rows = this.userService.insertFamily(family);
			} else {
				model.addAttribute("msg", "家庭成员数据不能为空！");
				return "Fail";
			}
			if (rows > 0) {
				return "OK";
			}
			model.addAttribute("msg", "家庭成员添加失败！");
			return "Fail";
		} else {
			model.addAttribute("msg", "老人信息错误！");
			return "Fail";
		}
	}
	
	
}
