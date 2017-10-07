package com.blake.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicacontextUtil {
	public static ApplicationContext getContext(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		return ctx;
	}
}
