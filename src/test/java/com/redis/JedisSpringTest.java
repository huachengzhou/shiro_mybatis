package com.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisSpringTest {
private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		String configLocation = "classpath:spring-config.xml";
		applicationContext = new ClassPathXmlApplicationContext(configLocation);
	}
	
	@Test
	public void testJedisSpring() throws Exception{
		//��ȡ���ӳ�
		JedisPool jedisPool = (JedisPool)applicationContext.getBean("jedisPool");
		//��ȡ����
		Jedis jedis = jedisPool.getResource();
		//����
		jedis.set("key4", "bbb");
		//ȡ��
		System.out.println(jedis.get("key4"));
		
	}
}
