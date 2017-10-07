package com.blake.spring.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blake.base.BController;
import com.blake.common.Session_User;
import com.blake.entiyi.Info;
import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_Info;
import com.blake.service.InfoService;

@Controller
public class InfoController extends BController {
	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	SecurityManager securityManager;
	
	@Autowired
	private InfoService infoService;
	
	@RequiresPermissions(value = { "user:select"})
	@RequestMapping(value={"/showListInfo"})
	public String showList(@RequestParam(defaultValue="1") Integer pageNumber,Model model) {
		PageResult_Info page = infoService.getPage(pageNumber);
		model.addAttribute("page",page);
		log.info("showListInfo");
		return "info/showInfoList";
	}
	
	@RequiresPermissions(value = { "user:remove"})
	@RequestMapping("/removeInfo")
	public String remove(@RequestParam Integer info_id) {
		infoService.remove(info_id);
		log.info("removeInfo "+info_id);
		return "redirect:/showListInfo";
	}


	@RequiresPermissions(value = { "user:save"})
	@RequestMapping("/save_ForWardInfo")
	public String save_ForWard(Model model) {
		model.addAttribute("info",new Info());
		log.info("save_ForWardInfo");
		return "info/save_ForWardInfo";
	}

	@RequiresPermissions(value = { "user:save"})
	@RequestMapping("/saveInfo")
	public String save(@ModelAttribute Info info) {
		log.info("saveInfo");
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		User user = (User) session.getAttribute(Session_User.User_sessionName);
		infoService.add(user.getUid(), info);
		return "redirect:/showListInfo";
	}
	
}
