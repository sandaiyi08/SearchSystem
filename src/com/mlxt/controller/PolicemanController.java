package com.mlxt.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

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

import com.mlxt.pojo.Image;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;
import com.mlxt.service.PolicemanService;

/**
 * Filename: PolicemanController.java
 * 
 * ·警察控制层
 * 
 * @author Luor
 * @version 1.0
 */

@Controller
@RequestMapping("/mlxt/police")
public class PolicemanController {
	
	@Autowired
	private PolicemanService policemanService;
	
	private Process process;
	private String indexPath;
	private String policePath;
	
	/**
	 * ·警察登录界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String policeLoginPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "policeLogin";
	}
	
	/**
	 * ·警察登录方法
	 * @param account
	 * @param password
	 * @param radio
	 * @param model
	 * @param modelMap
	 * @param session
	 * @param response
	 * @return
	 */
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
			session.setAttribute("POLICE_SESSION", policeman);
			modelMap.addFlashAttribute("police", policeman);
			return "redirect:" + policePath + "find";
		}
		model.addAttribute("msg", "账号或密码输入错误！");
		return "policeLogin";
	}

	/**
	 * ·警察登出
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String policeLogout(RedirectAttributesModelMap modelMap, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		session.invalidate();
		modelMap.clear();
		return "redirect:" + indexPath + "index";
	}
	
	/**
	 * ·上传老人图像界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/find")
	public String policeFindPage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "findOldMan";
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public String policeFind(Model model, RedirectAttributesModelMap modelMap, HttpSession session, 
			@RequestParam("imgFile")CommonsMultipartFile imgFile) {
		indexPath = (String) session.getAttribute("indexPath");
		List<Image> imgList = this.policemanService.findImageList();
		Integer oldManId = -1;
		
		// Create imgPath
		if (imgFile != null) {
			// Path
			String suffixName = FilenameUtils.getExtension(imgFile.getOriginalFilename());
			String imgName = "checked." + suffixName;
			String pyFilePath = session.getServletContext().getRealPath("/plug-in/");
			String imgfilePath = session.getServletContext().getRealPath("/plug-in/person-data/checked/");

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
				String pyCommandEncoding = "python " + pyFilePath + "saveFace.py " + imgfilePath + imgName;
				process = Runtime.getRuntime().exec(pyCommandEncoding);
				BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				faceLocation = in.readLine();
				// System.out.println(faceLocation);
				if (faceLocation == null || faceLocation == "") {
					model.addAttribute("msg", "图片错误，未检测到人脸！");
					return "Fail";
				}
				faceLocation = faceLocation.replaceAll("\\s*", "");
				String result = "";
				String pyCommandCompare = "python " + pyFilePath + "faceCheck.py " + imgfilePath + imgName + " " + faceLocation + " ";
				for (Image img:imgList) {
					process = Runtime.getRuntime().exec(pyCommandCompare + img.getImgPath() + " " + img.getImgLocation());
					in = new BufferedReader(new InputStreamReader(process.getInputStream()));
					result = in.readLine();
					if (result.equalsIgnoreCase("OK")) {
						session.setAttribute("OLDMAN_IMG_PATH", img.getImgPath());
						oldManId = img.getId();
						break;
					}
				}
				in.close();
				process.waitFor();
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "上传图片失败！");
				return "Fail";
			}
		}
		if (oldManId != -1) {
			OldMan oldMan =  (OldMan) this.policemanService.findOldmanById(oldManId);
			session.setAttribute("OLDMAN_SESSON", oldMan);
			return "OK";
		}
		model.addAttribute("msg", "系统错误！");
		return "Fail";
	}
	
	/**
	 * ·返回查询结果界面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/findResult")
	public String policeResultPage(Model model, HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		String basePath = (String) session.getAttribute("basePath");
		OldMan oldMan = (OldMan) session.getAttribute("OLDMAN_SESSON");
		String oldManImgRealPath = (String) session.getAttribute("OLDMAN_IMG_PATH");
		
		if (oldManImgRealPath != null && oldManImgRealPath != "") {
			String sysRealPath = session.getServletContext().getRealPath("");
			String oldManImgPath = basePath + oldManImgRealPath.substring(sysRealPath.length()).replaceAll("\\\\", "/");
			session.setAttribute("IMG_SESSION", oldManImgPath);
		}
		model.addAttribute("oldMan", oldMan);
		return "findOldManInfo";
	}
	
	/**
	 * ·警察信息界面
	 * @param session
	 * @return
	 */
	@RequestMapping("/message")
	public String policeMessage(HttpSession session) {
		indexPath = (String) session.getAttribute("indexPath");
		return "policeMessage";
	}
}
