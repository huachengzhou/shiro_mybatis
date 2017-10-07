package com.blake.spring.ince;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blake.common.Session_User;
import com.blake.entiyi.User;

public class AuthorizedInterceptor implements HandlerInterceptor {
	/** 定义不需要拦截的请求 */
	private static final String[] IGNORE_URI = { "/login_forward", "/login", };
	
	@Autowired
	SecurityManager securityManager;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/** 默认用户没有登录 */
		boolean flag = false;
		/* 定义默认的Servlet path */
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		/** 判断请求是否需要拦截 */
		for (String str : IGNORE_URI) {
			if (uri.contains(str)) {
				flag = true;
				System.out.println("正在登录用户!");
				System.err.println("状态:"+flag+"----------->");
				break;
			}
		}
		
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		/** 拦截请求 */
		if (!flag) {
			/** 1.获取session中的用户 */
			org.apache.shiro.session.Session session2 = subject.getSession();
//			HttpSession session = request.getSession();
//			User user = (User) session.getAttribute(Session_User.User_sessionName);
			User user = (User) session2.getAttribute(Session_User.User_sessionName);
			/** 2:判断用户是否已经登陆 */
			if (user != null) {
				flag = true;
			} else {// 没有登录
				flag = false;
				request.setAttribute("error", "no login");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		}
		return flag;
	}
	
	/**
	 * 这个方法在preHandle方法返回值为true的时候才会执行。 执行时间是在处理器进行处理之
	 * 后，也就是在Controller的方法调用之后执行。
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
	}

	/**
	 * 该方法需要preHandle方法的返回值为true时才会执行。 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("通过拦截!");
	}

}
