package com.nirmal.pachakari.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseItem {
	private int itemId;
	private BigDecimal itemPurchasedPrice;
	private int quantity;
}
