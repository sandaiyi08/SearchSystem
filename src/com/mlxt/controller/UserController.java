package com.mlxt.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
	
	private Process process;
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
			session.setAttribute("USER_SESSION", user);
			modelMap.addFlashAttribute("user", user);
			
			Family family = new Family();
			family.setFamilyTel(tel);
			Integer oldManId = this.userService.findOldManIdByFamily(family);
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
	public String userLogout(Model model, RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index";
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
			session.setAttribute("USER_SESSION", user);
			modelMap.addFlashAttribute("user", user);
			return "OK";
		}
		model.addAttribute("msg", "注册失败！");
		return "Fail";
	}
	
	/**
	 * ·用户信息主界面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/message")
	public String userMessage(HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		Integer oldManId = (Integer) session.getAttribute("OLDMAN_ID_SESSION");
		OldMan oldMan = this.userService.findOldMan(oldManId);
		model.addAttribute("oldMan", oldMan);
		return "userMes";
	}
	
	/**
	 * ·老人信息子界面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/oldManMes")
	public String oldManMessage(HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		String basePath = (String) session.getAttribute("basePath");
		Integer oldManId = (Integer) session.getAttribute("OLDMAN_ID_SESSION");
		User user = (User) session.getAttribute("USER_SESSION");
		OldMan oldMan = this.userService.findOldMan(oldManId);
		
		String suffixName = FilenameUtils.getExtension(oldMan.getImgPath());
		String imgfilePath;
		if (suffixName.equalsIgnoreCase("png")) {
			imgfilePath = basePath + "/plug-in/person-data/" + user.getTel() + "/oldman.png";
		} else {
			imgfilePath = basePath + "/plug-in/person-data/" + user.getTel() + "/oldman.jpg";
		}
		session.setAttribute("IMG_SESSION", imgfilePath);
		model.addAttribute("oldMan", oldMan);
		return "oldManMes";
	}
	
	/**
	 * ·家庭信息子界面
	 * @param family
	 * @param page
	 * @param rows
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/familyMes")
	public String familyMessage(Family family, @RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="5")Integer rows, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		User user = (User) session.getAttribute("USER_SESSION");
		if (user != null) {
			model.addAttribute("page", this.userService.selectFamilyPage(user.getTel(), family, page, rows));
		}
		return "familyMes";
	}
	
	/**
	 * ·老人信息修改子界面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/modifyOldMan")
	public String modifyOldMan(HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		return "modifyOldMan";
	}
	
	/**
	 * ·家庭信息修改子界面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/modifyUser")
	public String modifyFamily(HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		return "modifyUser";
	}
	
	/**
	 * ·添加家庭信息子界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/addFamily")
	public String addFamilyMemberPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "familyAdd";
	}
	
	/**
	 * ·删除家庭信息子界面
	 * @param family
	 * @param page
	 * @param rows
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/delFamily")
	public String delFamilyMemberPage(Family family, @RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="5")Integer rows, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		User user = (User) session.getAttribute("USER_SESSION");
		if (user != null) {
			model.addAttribute("page", this.userService.selectFamilyPage(user.getTel(), family, page, rows));
		}
		return "familyDelete";
	}
	
	@RequestMapping("/delFamily.do")
	@ResponseBody
	public String delFamilyMember(Family family, HttpSession session, Model model) {
		indexPath = (String) session.getAttribute("indexPath");
		Integer oldManId = (Integer) session.getAttribute("OLDMAN_ID_SESSION");
		Integer rows = 0;
		if (family != null && family.getFamilyName() != null && family.getFamilyName() != ""
				&& family.getFamilyTel() != null && family.getFamilyTel() != "") {
			family.setOldManId(oldManId);
			rows = this.userService.delFamily(family);
		} else {
			model.addAttribute("msg", "家庭信息数据错误！");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "家庭信息数据错误！");
		return "Fail";
	}
	
	/**
	 * ·用户初始信息录入界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/collect")
	public String firstInfoCollectPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "firstInfoCollect";
	}
	
	/**
	 * ·用户初始信息录入方法
	 * @param oldMan
	 * @param family
	 * @param model
	 * @param modelMap
	 * @param session
	 * @param imgFile
	 * @return
	 */
	@RequestMapping("/collect.do")
	@ResponseBody
	public String firstInfoCollect(OldMan oldMan, Family family, Model model, RedirectAttributesModelMap modelMap,
			HttpSession session, @RequestParam("imgFile")CommonsMultipartFile imgFile) {
		indexPath = (String) session.getAttribute("indexPath");
		userPath = (String) session.getAttribute("userPath");
		User user = (User) session.getAttribute("USER_SESSION");
		Integer rows = 0;
		
		// Create imgPath
		if (imgFile != null) {
			// Path
			String suffixName = FilenameUtils.getExtension(imgFile.getOriginalFilename());
			String imgName = "oldman." + suffixName;
			String pyFilePath = session.getServletContext().getRealPath("/plug-in/");
			String imgfilePath = session.getServletContext().getRealPath("/plug-in/person-data/" + user.getTel() + "/");

			File file = new File(imgfilePath, imgName);
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				imgFile.transferTo(file);
			} catch (Exception e) {
				model.addAttribute("msg", "上传图片失败！");
				return "Fail";
			}

			// Python
			String faceLocation = "";
			try {
				String pyCommand = "python " + pyFilePath + "saveFace.py " + imgfilePath + imgName;
				process = Runtime.getRuntime().exec(pyCommand);
				BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				faceLocation = in.readLine();
				//System.out.println(faceLocation);
				in.close();
				process.waitFor();
				if (faceLocation == null || faceLocation == "") {
					model.addAttribute("msg", "图片错误，未检测到人脸！");
					return "Fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "上传图片失败！");
				return "Fail";
			}
			// Set oldMan
			oldMan.setImgPath(imgfilePath + imgName);
			oldMan.setFaceLocation(faceLocation.replaceAll("\\s*", ""));
		}
		
		// Insert info
		if (oldMan != null && oldMan.getName() != null && oldMan.getName() != "" && oldMan.getAddress() != null
				&& oldMan.getAddress() != "" && oldMan.getAddress() != "") {
			rows = this.userService.insertOldMan(oldMan);
		} else {
			model.addAttribute("msg", "老人信息数据不能为空！");
			return "Fail";
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
				return "Fail";
			}
			session.setAttribute("OLDMAN_ID_SESSION", oldMan.getId());
			modelMap.addFlashAttribute("oldManId", oldMan.getId());
			if (rows > 0) {
				return "OK";
			}
			model.addAttribute("msg", "家庭成员信息错误！");
			return "Fail";
		}
		model.addAttribute("msg", "添加失败！");
		return "Fail";
	}
	
	/**
	 * ·家庭信息录入
	 * @param family
	 * @param model
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping("/collectFamily.do")
	@ResponseBody
	public String familyInfoCollect(Family family, Model model, RedirectAttributesModelMap modelMap, HttpSession session) {
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
			model.addAttribute("msg", "信息添加失败！");
			return "Fail";
		}
	}
	
	/**
	 * ·老人信息修改
	 * @param oldMan
	 * @param model
	 * @param modelMap
	 * @param session
	 * @param imgFile
	 * @return
	 */
	@RequestMapping("/modifyOldMan.do")
	@ResponseBody
	public String oldManModify(OldMan oldMan, Model model, RedirectAttributesModelMap modelMap, HttpSession session, 
			@RequestParam("imgFile")CommonsMultipartFile imgFile) {
		indexPath = (String) session.getAttribute("indexPath");
		userPath = (String) session.getAttribute("userPath");
		
		User user = (User) session.getAttribute("USER_SESSION");
		Integer oldManId = (Integer) session.getAttribute("OLDMAN_ID_SESSION");
		Integer rows = 0;
		
		// Create imgPath
		if (imgFile != null && imgFile.getOriginalFilename() != null && imgFile.getOriginalFilename() != "") {
			// Path
			String suffixName = FilenameUtils.getExtension(imgFile.getOriginalFilename());
			String imgName = "oldman." + suffixName;
			String pyFilePath = session.getServletContext().getRealPath("/plug-in/");
			String imgfilePath = session.getServletContext().getRealPath("/plug-in/person-data/" + user.getTel() + "/");
			
			File file = new File(imgfilePath, imgName);
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				imgFile.transferTo(file);
			} catch (Exception e) {
				//model.addAttribute("msg", "上传图片失败！");
				modelMap.addFlashAttribute("msg", "上传图片失败！");
				return "Fail";
			}
			
			// Python
			String faceLocation = "";
			try {
				String pyCommand = "python " + pyFilePath + "saveFace.py " + imgfilePath + imgName;
				process = Runtime.getRuntime().exec(pyCommand);
				BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				faceLocation = in.readLine();
				//System.out.println(faceLocation);
				in.close();
				process.waitFor();
				if (faceLocation == null || faceLocation == "") {
					//model.addAttribute("msg", "图片错误，未检测到人脸！");
					modelMap.addFlashAttribute("msg", "图片错误，未检测到人脸！");
					return "Fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				//model.addAttribute("msg", "上传图片失败！");
				modelMap.addFlashAttribute("msg", "上传图片失败！");
				return "Fail";
			}
			// Set oldMan
			oldMan.setImgPath(imgfilePath+imgName);
			oldMan.setFaceLocation(faceLocation.replaceAll("\\s*", ""));
		}
		
		// Update data
		if (oldMan != null) {
			oldMan.setId(oldManId);
			rows = this.userService.updateOldMan(oldMan);
		} else {
			//model.addAttribute("msg", "老人信息数据不能全为空！");
			modelMap.addFlashAttribute("msg", "老人信息数据不能全为空！");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		//model.addAttribute("msg", "老人信息修改失败！");
		modelMap.addFlashAttribute("msg", "老人信息修改失败！");
		return "Fail";
	}
	
	@RequestMapping("/modifyUser.do")
	@ResponseBody
	public String userModify(Family family, Model model, RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		userPath = (String) session.getAttribute("userPath");
		Integer oldManId = (Integer) session.getAttribute("OLDMAN_ID_SESSION");
		User user = (User) session.getAttribute("USER_SESSION");
		Integer rows = 0;
		if (family != null) {
			family.setFamilyTel(user.getTel());
			family.setOldManId(oldManId);
			rows = this.userService.updateFamily(family);
		} else {
			model.addAttribute("msg", "用户信息数据不能全为空！");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "用户信息修改失败！");
		return "Fail";
	}
	
}
