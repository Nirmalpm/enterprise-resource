package com.enterprise.resource.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PachakariError {
	private int statusCode;
	private String message;
}
