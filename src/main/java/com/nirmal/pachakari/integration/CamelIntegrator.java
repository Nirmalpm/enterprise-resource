package com.nirmal.pachakari.integration;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class CamelIntegrator {
	public void processImage() {
		ImageRouteBuilder routeBuilder = new ImageRouteBuilder();
		CamelContext ctxt = new DefaultCamelContext();
		try {
			ctxt.addRoutes(routeBuilder);
			ctxt.start();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				ctxt.stop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
