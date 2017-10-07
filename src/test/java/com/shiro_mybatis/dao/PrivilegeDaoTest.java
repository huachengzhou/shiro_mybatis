package com.shiro_mybatis.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicacontextUtil;
import com.blake.dao.PrivilegeDao;
import com.blake.entiyi.Privilege;

public class PrivilegeDaoTest {
	private ApplicationContext ctx = ApplicacontextUtil.getContext();
	private PrivilegeDao privilegeDao = ctx.getBean(PrivilegeDao.class);
	
	@Test
	public void addPrivilege(){
		Privilege privilege = new Privilege();
		privilege.setDescription("user:xxx");
		privilegeDao.addPrivilege(privilege);
	}
	
	@Test
	public void findPrivilege(){
		Privilege privilege = privilegeDao.getPrivilege(2);
		System.out.println(privilege);
	}
	
	@Test
	public void getPrivilege(){
		Privilege privilege = privilegeDao.findPrivilege(1);
		System.out.println(privilege);
		System.out.println(privilege.getRoles().size());
	}
	
	@Test
	public void countPrivilege(){
		Long count = privilegeDao.getLongNumber();
		System.out.println(count);
	}
	
	@Test
	public void updatePrivilege(){
		Privilege privilege = privilegeDao.getPrivilege(7);
		System.out.println(privilege);
		privilege.setDescription("user:yyy");
		System.out.println(privilege);
		privilegeDao.updatePrivilege(privilege);
	}
	
	@Test
	public void removePrivilege(){
		privilegeDao.removePrivilege(7);
	}
}
