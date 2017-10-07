package com.blake.spring.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

@Configuration
@EnableCaching
public class CacaingConfig {
	
	@Bean
	public EhCacheCacheManager cacheCacheManager(CacheManager cm){
		return new EhCacheCacheManager(cm);
	}
	
	public EhCacheManagerFactoryBean ehcache(){
		EhCacheManagerFactoryBean ehCacheFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheFactoryBean.setConfigLocation(new ClassPathResource("ehcache/springCache.xml"));
		return ehCacheFactoryBean;
	}
}
