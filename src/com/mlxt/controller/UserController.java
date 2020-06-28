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
 * ���û����Ʋ�
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
	 * ���û���¼����
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String userLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userLogin";
	}
	
	/**
	 * ���û���¼����
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
		model.addAttribute("msg", "�˺Ż������������");
		return "userLogin";
	}

	/**
	 * ���û��ǳ�
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
	 * ���û�ע�����
	 * @param session
	 * @return
	 */
	@RequestMapping("/register")
	public String userRegisterPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "userRegister";
	}
	
	/**
	 * ���û�ע�᷽��
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
			model.addAttribute("msg", "�û��������벻��Ϊ�գ�");
			return "Fail";
		}
		if (rows > 0) {
			session.setAttribute("USER_SESSION", user);
			modelMap.addFlashAttribute("user", user);
			return "OK";
		}
		model.addAttribute("msg", "ע��ʧ�ܣ�");
		return "Fail";
	}
	
	/**
	 * ���û���Ϣ������
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
	 * ��������Ϣ�ӽ���
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
	 * ����ͥ��Ϣ�ӽ���
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
	 * ��������Ϣ�޸��ӽ���
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
	 * ����ͥ��Ϣ�޸��ӽ���
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
	 * ����Ӽ�ͥ��Ϣ�ӽ���
	 * @param session
	 * @return
	 */
	@RequestMapping("/addFamily")
	public String addFamilyMemberPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "familyAdd";
	}
	
	/**
	 * ��ɾ����ͥ��Ϣ�ӽ���
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
			model.addAttribute("msg", "��ͥ��Ϣ���ݴ���");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "��ͥ��Ϣ���ݴ���");
		return "Fail";
	}
	
	/**
	 * ���û���ʼ��Ϣ¼�����
	 * @param session
	 * @return
	 */
	@RequestMapping("/collect")
	public String firstInfoCollectPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "firstInfoCollect";
	}
	
	/**
	 * ���û���ʼ��Ϣ¼�뷽��
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
				model.addAttribute("msg", "�ϴ�ͼƬʧ�ܣ�");
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
					model.addAttribute("msg", "ͼƬ����δ��⵽������");
					return "Fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "�ϴ�ͼƬʧ�ܣ�");
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
			model.addAttribute("msg", "������Ϣ���ݲ���Ϊ�գ�");
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
				model.addAttribute("msg", "��ͥ��Ա���ݲ���Ϊ�գ�");
				return "Fail";
			}
			session.setAttribute("OLDMAN_ID_SESSION", oldMan.getId());
			modelMap.addFlashAttribute("oldManId", oldMan.getId());
			if (rows > 0) {
				return "OK";
			}
			model.addAttribute("msg", "��ͥ��Ա��Ϣ����");
			return "Fail";
		}
		model.addAttribute("msg", "���ʧ�ܣ�");
		return "Fail";
	}
	
	/**
	 * ����ͥ��Ϣ¼��
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
				model.addAttribute("msg", "��ͥ��Ա���ݲ���Ϊ�գ�");
				return "Fail";
			}
			if (rows > 0) {
				return "OK";
			}
			model.addAttribute("msg", "��ͥ��Ա���ʧ�ܣ�");
			return "Fail";
		} else {
			model.addAttribute("msg", "��Ϣ���ʧ�ܣ�");
			return "Fail";
		}
	}
	
	/**
	 * ��������Ϣ�޸�
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
				//model.addAttribute("msg", "�ϴ�ͼƬʧ�ܣ�");
				modelMap.addFlashAttribute("msg", "�ϴ�ͼƬʧ�ܣ�");
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
					//model.addAttribute("msg", "ͼƬ����δ��⵽������");
					modelMap.addFlashAttribute("msg", "ͼƬ����δ��⵽������");
					return "Fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				//model.addAttribute("msg", "�ϴ�ͼƬʧ�ܣ�");
				modelMap.addFlashAttribute("msg", "�ϴ�ͼƬʧ�ܣ�");
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
			//model.addAttribute("msg", "������Ϣ���ݲ���ȫΪ�գ�");
			modelMap.addFlashAttribute("msg", "������Ϣ���ݲ���ȫΪ�գ�");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		//model.addAttribute("msg", "������Ϣ�޸�ʧ�ܣ�");
		modelMap.addFlashAttribute("msg", "������Ϣ�޸�ʧ�ܣ�");
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
			model.addAttribute("msg", "�û���Ϣ���ݲ���ȫΪ�գ�");
			return "Fail";
		}
		if (rows > 0) {
			return "OK";
		}
		model.addAttribute("msg", "�û���Ϣ�޸�ʧ�ܣ�");
		return "Fail";
	}
	
}
