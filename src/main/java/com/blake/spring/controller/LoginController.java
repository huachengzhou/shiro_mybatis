package com.blake.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blake.common.Session_User;
import com.blake.entiyi.User;
import com.blake.service.UserService;

@Controller
public class LoginController {
	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	SecurityManager securityManager;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value={"/login_forward"})
	public String login_forward(Model model){
		log.info("login_forward()");
		model.addAttribute("user",new User());
		return "login";
	}
	
	@RequestMapping(value={"/login"},method={RequestMethod.POST})
	public String loginUser(@ModelAttribute User user,HttpServletRequest request,@RequestParam(defaultValue="true") boolean rememberMe){
		log.info("loginUser()"+user);
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
//		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword(),rememberMe);
		
		String path = "";
//		User sUser = null;
		try {
			subject.login(token);//登陆成功
			Session session = subject.getSession();
			session.setAttribute(Session_User.User_sessionName,userService.loginUser(user.getUsername()));
			session.setAttribute("info", "session的数据");
			path = "main";
//			sUser = userService.loginUser(user.getUsername());
//			if (sUser!=null) {
//				log.info("login success!");
//				request.getSession().setAttribute(Session_User.User_sessionName,sUser);
//				path = "main";
//			}
		} catch (Exception e) {
			log.error(e.getMessage());
			path = "login";
			request.setAttribute(Session_User.User_sessionName,new User());
			request.setAttribute("errorMsg","用户名或密码错误");
			request.setAttribute("error",e.getMessage());
		}
		return path;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		request.setAttribute(Session_User.User_sessionName,new User());
		Subject subject = SecurityUtils.getSubject();
		subject.logout();//清空数据
		log.info("退出登录");
		return "login";
	}
}
