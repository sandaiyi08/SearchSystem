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
 * ����¼������
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
		// ��ȡ����URL
		String url = request.getRequestURI();
		// ��ȡSession
		HttpSession session = request.getSession();
		if (url.indexOf("manage/") >= 0) {
			session.setAttribute("usertype", 1);
		} else {
			session.setAttribute("usertype", 0);
		}
		// ��login�⣬�������п���
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
			request.setAttribute("msg", "����û�е�¼�����¼��");
			request.getRequestDispatcher("/WEB-INF/view/adminLogin.jsp").forward(request, response);
			return false;
		}
		User user = (User) session.getAttribute("USER_SESSION");
		Policeman policeman = (Policeman) session.getAttribute("POLICE_SESSION");
		if (user != null || policeman != null) {
			return true;
		}
		// �����������������ʾ��Ϣ����ҳ��ת��
		request.setAttribute("msg", "����û�е�¼�����¼��");
		// Servletҳ��ת��
		request.getRequestDispatcher("/WEB-INF/view/systemIndex.jsp").forward(request, response);
		return false;
	}
}
