package com.shiro_mybatis.dao;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicacontextUtil;
import com.blake.common.Base64Util;
import com.blake.dao.UserDao;
import com.blake.entiyi.Privilege;
import com.blake.entiyi.Role;
import com.blake.entiyi.User;

public class UserDaoTest {
	
	private ApplicationContext ctx = ApplicacontextUtil.getContext();
	UserDao userDao = ctx.getBean(UserDao.class);
	
	@Test
	public void isit() throws UnsupportedEncodingException{
		User user = new User();
		user.setUsername("blake");
		user.setLock_User(true);
		user.setOrganizationid("中石油");
		user.setTime(new Date());
		user.setPassword("123456");
		String salt = UUID.randomUUID().toString();
		System.out.println(salt);
		System.out.println(user.getPassword());
		user.setSalt("0:"+salt);
		String password = user.getPassword().concat(salt);
		System.out.println("1:"+password);
		password = Base64Util.setString(password);
		System.out.println("2:"+password);
		user.setPassword(password);
		System.err.println("4:"+user);
	}
	
	@Test
	public void addUser(){
		User user = new User();
		user.setUsername("blake");
		user.setLock_User(true);
		user.setOrganizationid("中石油");
		user.setTime(new Date());
		user.setPassword("123456");
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);
		String password = user.getPassword() + "" + salt;
		password = Base64Util.getString(password);
		user.setPassword(password);
		
		userDao.addUser(user);
		
		System.out.println(user);
	}
	
	@Test
	public void shiro_Test(){
		User user = userDao.findUsersRolePrivilege(92);
		System.out.println(user);
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println(role);
			Set<Privilege> privileges = role.getPrivileges();
			for (Privilege privilege : privileges) {
				System.out.println(privilege);
			}
		}
	}
}
