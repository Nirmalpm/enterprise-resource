package com.enterprise.resource.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Item {
	private Integer enterpriseId;
	private Integer itemId;
	private String itemName;
	private String itemDescription;
	private BigDecimal itemPrice;
	private int itemQuantity;
	private String itemUnit="";
	private MultipartFile file;
	private String imageName;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdUser;
	private String modifiedUser;
}
