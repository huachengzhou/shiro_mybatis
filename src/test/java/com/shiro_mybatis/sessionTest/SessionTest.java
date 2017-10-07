package com.shiro_mybatis.sessionTest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicacontextUtil;

public class SessionTest {
	private ApplicationContext ctx = ApplicacontextUtil.getContext();
	
	@Test
	public void isit(){
		SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);
		System.out.println(sqlSessionFactory);
	}
	
	@Test
	public void isN(){
		System.out.println(ctx.getDisplayName());
	}
}
