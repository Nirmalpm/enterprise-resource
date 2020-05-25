package com.enterprise.resource;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


public class TestClass implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		System.out.println("Domains-------");
		System.out.println( server.getDomains()[0]);
	}

}
