package com.enterprise.resource.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.enterprise.resource.model.Order;

@Component
public class EmailServiceImpl implements EmailService{
	
	private final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Autowired
	public JavaMailSender javaMailSender;
	@Autowired
	TemplateEngine templateEngine;
	
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
		return new SimpleMailMessage(); 
	}

	@Override
	public void sendMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		try {
			javaMailSender.send(message);
		}catch(MailSendException mex) {
			log.error(mex.getMessage());
		}
	}

	@Override
	public void sendMessageWithAttach(String to, String subject, String text, String filePath) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeHelper = new MimeMessageHelper(message,true);
			mimeHelper.setTo(to);
			mimeHelper.setSubject(subject);
			mimeHelper.setText(text);
			FileSystemResource resource = new FileSystemResource(new File(filePath));
			mimeHelper.addAttachment("Attachment",resource);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			log.error(e.getMessage());
		}		
	}
	@Override
	public void sendOrderMessage(String to, String subject, String text, Order order) {		
		final Context ctx = new Context(LocaleContextHolder.getLocale());
		ctx.setVariable("email", to);
		ctx.setVariable("order", order);
		ctx.setVariable("imageResourceName", "imageResourceName");
		
		final String htmlContent = this.templateEngine.process("orderemail.html", ctx);
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeHelper = new MimeMessageHelper(message,true);
			mimeHelper.setTo(to);
			mimeHelper.setSubject(subject);
			mimeHelper.setText(htmlContent, true);	
			mimeHelper.addInline("imageResourceName", new ClassPathResource("veg-thmb.jpg"), "image/gif");
			javaMailSender.send(message);
		}catch(MessagingException ex) {
			log.error(ex.getMessage());
		}
	}	
	
	@Override
	public void sendOrderMessage(String to, String subject, String text, String filePath, Order order) {		
		final Context ctx = new Context(LocaleContextHolder.getLocale());
		ctx.setVariable("email", to);
		ctx.setVariable("order", order);
		ctx.setVariable("imageResourceName", "imageResourceName");
		
		final String htmlContent = this.templateEngine.process("order-email.html", ctx);
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeHelper = new MimeMessageHelper(message,true,"UTF-18");
			mimeHelper.setTo(to);
			mimeHelper.setSubject(subject);
			mimeHelper.setText(htmlContent, true);	
			FileSystemResource resource = new FileSystemResource(new File(filePath));
			mimeHelper.addAttachment("Attachment",resource);
			mimeHelper.addInline("imageResourceName", new ClassPathResource("veg-thmb.gif"), "image/gif");
			javaMailSender.send(message);
		}catch(MessagingException ex) {
			log.error(ex.getMessage());
		}
	}	
}
