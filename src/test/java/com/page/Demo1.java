package com.page;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicacontextUtil;
import com.blake.entiyi.Info;
import com.blake.service.InfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Demo1 {
	private ApplicationContext ctx = ApplicacontextUtil.getContext();
	private InfoService infoService = ctx.getBean(InfoService.class);
	private SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);

	@Test
	public void isit() {
		SqlSession session = sqlSessionFactory.openSession();
		PageHelper.startPage(1, 10);
	}
	
	@Test
	public void isTest(){
		List<Info> infos = infoService.findObjects();
		PageInfo<Info> page = new PageInfo<Info>(infos);
		page.setPageNum(2);//第二页
		page.setPageSize(5);//每页数量
		page.setSize(5);
		page.setTotal(infos.size());
		List<Info> infos2 = page.getList();
		System.out.println(page.getTotal());
		System.out.println(page.getPages());
	}
}
