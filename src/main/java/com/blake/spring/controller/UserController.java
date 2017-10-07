package com.blake.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blake.base.BController;
import com.blake.common.Base64Util;
import com.blake.entiyi.Role;
import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_User;
import com.blake.service.RoleService;
import com.blake.service.UserService;

@Controller
public class UserController extends  BController{
	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequiresPermissions(value = { "user:select"})
	@RequestMapping("/showListUser")
	public String showList(@RequestParam(defaultValue="1") Integer pageNumber,Model model) {
		PageResult_User page = userService.getPage(pageNumber);
		model.addAttribute("page",page);
		log.info("showListUser");
		return "user/showListUser";
	}

	public String remove() {
		return super.remove();
	}

	@RequiresPermissions(value = { "user:save","user:admin"})
	@RequestMapping(value={"/save_ForWardUser"})
	public String save_ForWard(Model model) {
		log.info("转到新增页面 save_ForWard");
		List<Role> roles = roleService.findObjects();
		model.addAttribute("user",new User());
		model.addAttribute("roles",roles);
		return "user/save_ForWardUser";
	}

	@RequiresPermissions(value = { "user:save","user:admin"})
	@RequestMapping(value={"/saveUser"})
	public String save(@ModelAttribute User user,@RequestParam String rid) {
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);
		String password = user.getPassword().concat(salt);
		password = Base64Util.setString(password);
		user.setPassword(password);
		user.setTime(new Date());
		userService.add(user);
		Integer uid = user.getUid();
		log.info("user:"+user);
		
		String[] rids = rid.split(",");
		for (String string : rids) {
			Integer rid_ = Integer.parseInt(string);
			userService.addRole_User(uid, rid_);//关联表的插入
		}
		return "redirect:/showListUser";
	}
	
}
