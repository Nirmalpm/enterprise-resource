package com.nirmal.pachakari.errors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nirmal.pachakari.controllers.ItemController;
import com.nirmal.pachakari.model.PachakariError;

@ControllerAdvice(basePackageClasses=ItemController.class)
public class ItemControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex){
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(new PachakariError(status.value(),ex.getMessage()),status);
	}
	
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if(statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return HttpStatus.valueOf(statusCode);
	}
}
