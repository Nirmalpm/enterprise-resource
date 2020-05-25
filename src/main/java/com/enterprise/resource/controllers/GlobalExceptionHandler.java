package com.enterprise.resource.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MultipartException.class)
	public String handleError(MultipartException ex, RedirectAttributes attributes) {
		attributes.addFlashAttribute("message", ex.getCause().getMessage());
		return "redirect:/upload/uploadStatus";
	}
}
