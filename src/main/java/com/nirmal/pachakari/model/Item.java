package com.nirmal.pachakari.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Item {
	private int itemId;
	private String itemName;
	private String itemDescription;
	private Double itemPrice;
	private int itemQuantity;
	private String itemUnit="";
	private MultipartFile file;
	private String imageName;
	private Timestamp createdDate;
}
