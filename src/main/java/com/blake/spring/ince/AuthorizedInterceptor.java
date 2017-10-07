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
	/** ���岻��Ҫ���ص����� */
	private static final String[] IGNORE_URI = { "/login_forward", "/login", };
	
	@Autowired
	SecurityManager securityManager;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/** Ĭ���û�û�е�¼ */
		boolean flag = false;
		/* ����Ĭ�ϵ�Servlet path */
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		/** �ж������Ƿ���Ҫ���� */
		for (String str : IGNORE_URI) {
			if (uri.contains(str)) {
				flag = true;
				System.out.println("���ڵ�¼�û�!");
				System.err.println("״̬:"+flag+"----------->");
				break;
			}
		}
		
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		/** �������� */
		if (!flag) {
			/** 1.��ȡsession�е��û� */
			org.apache.shiro.session.Session session2 = subject.getSession();
//			HttpSession session = request.getSession();
//			User user = (User) session.getAttribute(Session_User.User_sessionName);
			User user = (User) session2.getAttribute(Session_User.User_sessionName);
			/** 2:�ж��û��Ƿ��Ѿ���½ */
			if (user != null) {
				flag = true;
			} else {// û�е�¼
				flag = false;
				request.setAttribute("error", "no login");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		}
		return flag;
	}
	
	/**
	 * ���������preHandle��������ֵΪtrue��ʱ��Ż�ִ�С� ִ��ʱ�����ڴ��������д���֮
	 * ��Ҳ������Controller�ķ�������֮��ִ�С�
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
	}

	/**
	 * �÷�����ҪpreHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С� �÷������������������֮��ִ�У���Ҫ����������������Դ��
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("ͨ������!");
	}

}
