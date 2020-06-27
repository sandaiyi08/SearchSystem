package com.mlxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mlxt.pojo.Manager;
import com.mlxt.pojo.Policeman;
import com.mlxt.pojo.User;

/**
 * Filename: LoginInterceptor.java
 * 
 * ·登录拦截器
 * 
 * @author Luor
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求URL
		String url = request.getRequestURI();
		// 获取Session
		HttpSession session = request.getSession();
		if (url.indexOf("manage/") >= 0) {
			session.setAttribute("usertype", 1);
		} else {
			session.setAttribute("usertype", 0);
		}
		// 除login外，拦截所有控制
		if (url.indexOf("login") >= 0 || url.indexOf("register") >= 0 || url.indexOf("about") >= 0) {
			return true;
		}

		if (session.getAttribute("usertype") == null) {
			request.getRequestDispatcher("/index").forward(request, response);
			return false;
		}
		int usertype = (int) session.getAttribute("usertype");
		Manager manager = (Manager) session.getAttribute("Manager_SESSION");
		if (usertype == 1) {
			if (manager != null) {
				return true;
			}
			request.setAttribute("msg", "您还没有登录，请登录！");
			request.getRequestDispatcher("/WEB-INF/view/adminLogin.jsp").forward(request, response);
			return false;
		}
		User user = (User) session.getAttribute("USER_SESSION");
		Policeman policeman = (Policeman) session.getAttribute("POLICE_SESSION");
		if (user != null || policeman != null) {
			return true;
		}
		// 不符合条件，添加提示信息，并页面转向
		request.setAttribute("msg", "您还没有登录，请登录！");
		// Servlet页面转向
		request.getRequestDispatcher("/WEB-INF/view/systemIndex.jsp").forward(request, response);
		return false;
	}
}
