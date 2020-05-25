package com.enterprise.resource.integration;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.enterprise.resource.utils.ImageUtil;

@Component
public class ImageRouteBuilder extends RouteBuilder {
	
	@Autowired
	ImageUtil imageUtil;
	
	@Value("${image.path}")
	public String filePath;
	
	@Value("${original.path}")
	public String originalPath;
	
	@Value("${thumbnail.path}")
	public String thumbnailPath;
	
	@Value("${overview.path}")
	public String overviewPath;
	
	@Override
	public void configure() throws Exception {
		from("file:"+filePath+"?noop=false").process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				File in = exchange.getIn().getBody(File.class);
				String fileFullName = in.getName();
				String fileName = fileFullName.substring(0,fileFullName.lastIndexOf("."));
				String formatName = fileFullName.substring(fileFullName.lastIndexOf(".") + 1);
				
				String processedFile = filePath+"/"+in.getName(); 				
				String outputThmbFileName = thumbnailPath+"/"+fileName+"-thmb."+formatName;
				String outputOvwFileName = overviewPath+"/"+fileName+"-ovw."+formatName;
				
				imageUtil.resize(processedFile, outputThmbFileName, 200, 200);
				imageUtil.resize(processedFile, outputOvwFileName, 400, 400);
			}}).to("file:"+originalPath);
	}

}
