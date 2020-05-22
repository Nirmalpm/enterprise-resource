package com.nirmal.pachakari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nirmal.pachakari.model.PurchaseItem;

@SpringBootApplication
@EnableResourceServer
public class PachakariApplication {
	
	@Bean 
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean 
	public RedisTemplate<String, PurchaseItem> redisTemplate(){
		RedisTemplate<String, PurchaseItem> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PachakariApplication.class);
		app.run(args);
	}	
}
