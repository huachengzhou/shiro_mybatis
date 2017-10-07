package com.shiro_mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicacontextUtil;
import com.blake.common.PinyinTool;
import com.blake.dao.RoleDao;
import com.blake.entiyi.Privilege;
import com.blake.entiyi.Role;
import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_Role;
import com.blake.service.RoleService;
import com.blake.service.UserService;

import words.WordSt;

public class RoleServiceTest {
	private ApplicationContext ctx = ApplicacontextUtil.getContext();
	RoleService roleService = ctx.getBean(RoleService.class);
	UserService userService = (UserService) ctx.getBean("userService");
	RoleDao roleDao = ctx.getBean(RoleDao.class);
	
	@Test
	public void addRole(){
		Role role = new Role();
		role.setAvailable(true);
		role.setDescription("教师");
		role.setRole_name("teacher");
		
		String str = WordSt.getC();
		role.setDescription(str);
		str = new PinyinTool().toPringYin_LOWERCASE(str);
		role.setRole_name(str);
		roleService.add(role);
	}
	
	@Test
	public void updateRole(){
		Role role = roleService.findObjectById(3);
		System.out.println(role);
		System.out.println(role.getUsers().size());
		role.setDescription("教师");
		roleService.update(role);
	}
	
	@Test
	public void addRole_User(){
		Integer uid = 2;
		Integer rid = 1;
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("uid",uid);
		params.put("rid",rid);
		roleDao.addRole_User(params);
	}
	
	@Test
	public void findRole(){
		Role role = roleService.findObjectById(1);
		System.out.println(role.getUsers().size());
		System.out.println(role.getPrivileges().size());
		System.out.println(role);
	}
	
	@Test
	public void findRoles(){
		List<Role> roles = roleService.findObjects();
		for (Role role : roles) {
			Set<User> users = role.getUsers();
			Set<Privilege> privileges = role.getPrivileges();
			System.out.println(role);
			System.out.println(users.size()+""+users);
			System.out.println(privileges.size()+""+privileges);
		}
	}
	
	@Test
	public void getPage(){
		PageResult_Role page = roleService.getPage(1);
		List<Role> roles = page.getItems();
		for (Role role : roles) {
			System.out.println(role);
		}
	}
}
