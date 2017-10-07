package com.shiro_mybatis.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicacontextUtil;
import com.blake.dao.InfoDao;
import com.blake.entiyi.Info;
import com.blake.entiyi.vo.InfoVo;
import com.blake.service.InfoService;

import words.WordSt;

public class InfoServiceTest {
	
	private ApplicationContext ctx = ApplicacontextUtil.getContext();
	private InfoService infoService = ctx.getBean(InfoService.class);
	private InfoDao infoDao = ctx.getBean(InfoDao.class);
	
	@Test
	public void findNumbersInfos(){
		InfoVo infoVo = new InfoVo();
		List<Integer> ids = new ArrayList<Integer>(Arrays.asList(1,2,4));
		infoVo.setIds(ids);
		List<Info> infos = infoDao.findNumbersInfos(infoVo);
		for (Info info : infos) {
			System.out.println(info);
		}
	}
	@Test
	public void init(){
		System.out.println(infoService.hashCode());
	}
	
	@Test
	public void addInfo(){
		for (int i = 0; i < 100; i++) {
			Info info = new Info();
			info.setDescription("你好!"+WordSt.getC()+"");
			infoService.add(90, info);
		}
	}
	
	@Test
	public void getInfo(){
		Info info = infoService.findObjectById(1);
		System.out.println(info.getUser());
	}
	
	@Test
	public void getInfoVo(){
		InfoVo infoVo = infoService.getInfoVo(1);
		System.out.println(infoVo);
	}
	
	@Test
	public void  updateInfo() {
		Info info = infoService.findObjectById(4);
		System.out.println(info);
		info.setDescription("乒乒乓乓乒乒乓乓批批批批批批批");
		System.out.println(info);
		infoService.update(info);
	}
	
	@Test
	public void   removeInfo() {
		infoService.remove(3);
	}
	
	@Test
	public void findList(){
		List<Info> infos = infoService.findObjects();
		for (Info info : infos) {
			System.out.println(info.getUser());
		}
	}
}
