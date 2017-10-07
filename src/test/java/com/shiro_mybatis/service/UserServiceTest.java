package com.shiro_mybatis.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicacontextUtil;
import com.blake.entiyi.User;
import com.blake.service.UserService;

import words.WordSt;

public class UserServiceTest {
	private ApplicationContext ctx = ApplicacontextUtil.getContext();
	UserService userService = (UserService) ctx.getBean("userService");

	@Test
	public void updateUser() {
		User user = userService.findObjectById(90);
		System.out.println(user);
		user.setPassword("666666");
		userService.update(user);
	}
	
	@Test
	public void removeUser(){
		userService.remove(93);
	}

	@Test
	public void addUser() {
		User user = new User();
		user.setOrganizationid("ÖÐÊ¯»¯");
		user.setPassword("123456");
		user.setUsername(WordSt.getE());
		user.setTime(new Date());
		user.setSalt(UUID.randomUUID().toString());
		user.setLock_User(true);
		System.err.println("user:" + user);
		userService.add(user);
	}

	@Test
	public void getUser() {
		User user = userService.findObjectById(90);
		System.out.println(user);
	}
	
	@Test
	public void findLists(){
		List<User> users =userService.findObjects();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void findUsers_Number(){
		List<Integer> integers = new ArrayList<Integer>(Arrays.asList(2,3,4));
		List<User> users = userService.findUsers_Number(integers);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void removeUser_Number(){
		List<Integer> integers = new ArrayList<Integer>(Arrays.asList(5,3,4));
		Serializable[] ids = new Serializable[integers.size()];
		int i = 0;
		for (Integer integer : integers) {
			ids[i] = integer;
			i++;
		}
		userService.removes(ids);
	}
	
	@Test
	public void loginUser(){
		User user = userService.loginUser("root");
		System.out.println(user);
	}

}
