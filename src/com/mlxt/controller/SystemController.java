package com.mlxt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlxt.pojo.Family;
import com.mlxt.pojo.Manager;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;
import com.mlxt.pojo.User;
import com.mlxt.service.ManagerService;
import com.mlxt.service.PolicemanService;
import com.mlxt.service.UserService;

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
	
	@Autowired
	private UserService userService;
	@Autowired
	private PolicemanService policemanService;
	@Autowired
	private ManagerService managerService;
	
	/**
	 * ·主页
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
	 * ·关于我们
	 * @param session
	 * @param model
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
	
	@RequestMapping("/aboutSys")
	public void PressureTest() {
		long sleepTime = 1000;
		int count = 0;
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			int rows = 0;
			User user = null;
			OldMan oldMan = null;
			List<Family> familyList = null;
			Policeman policeman = null;
			Manager manager = null;

			// Run
			rows = this.userService.insertUser(new User("1234567","1234567"));
			if (rows > 0) {
				rows = this.managerService.updateOnlyUser(new User("123456789","1234567"));
			}
			if (rows > 0) {
				user = this.userService.findUser("1234567", "123456789");
			}
			if (user != null) {
				rows = this.managerService.deleteUser("1234567");
			}
			if (rows > 0) {
				System.out.println(count + ": User OK");
			}
			
			rows = this.userService.insertOldMan(new OldMan("address", 9, "imgPath", "name"));
			if (rows > 0) {
				rows = this.userService.updateOldMan(new OldMan("address fix", 9, "imgPath fix", "name fix"));
			}
			if (rows > 0) {
				oldMan = this.userService.findOldMan(9);
			}
			if (oldMan != null) {
				rows = this.userService.insertFamily(new Family("123456", "123456", 9));
			}
			if (rows > 0) {
				rows = this.userService.updateFamily(new Family("123456", "123456789", 9));
			}
			if (rows > 0) {
				familyList = this.userService.selectFamilyList("123456");
			}
			if (!familyList.isEmpty()) {
				rows = this.managerService.deleteOldMan(9);
			}
			if (rows > 0) {
				rows = this.userService.delFamily(new Family("123456", "123456789", 9));
			}
			if (rows > 0) {
				System.out.println(count + ": OldMan & Family OK");
			}
			
			rows = this.managerService.insertPoliceman(new Policeman("123456", "123456"));
			if (rows > 0) {
				rows = this.managerService.updatePolice(new Policeman("123456", "123456789"));
			}
			if (rows > 0) {
				policeman = this.policemanService.findPolice("123456", "123456789");
			}
			if (policeman != null) {
				rows = this.managerService.deletePolice("123456");
			}
			if (rows > 0) {
				System.out.println(count + ": Police OK");
			}
			
			rows = this.managerService.insertManager(new Manager("123456", "123456"));
			if (rows > 0) {
				manager = this.managerService.findManager("123456", "123456");
			}
			if (manager != null) {
				rows = this.managerService.deleteManager("123456");
			}
			if (rows > 0) {
				System.out.println(count + ": Manager OK");
			}
			count++;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
