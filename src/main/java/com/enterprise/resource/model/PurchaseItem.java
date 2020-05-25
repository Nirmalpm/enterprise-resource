package com.enterprise.resource.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItem implements Serializable{
	private Integer enterpriseId;
	private Integer itemId;
	private String itemName;
	private BigDecimal itemPurchasedPrice;
	private int quantity;
	private String user;
	private String image;
}
