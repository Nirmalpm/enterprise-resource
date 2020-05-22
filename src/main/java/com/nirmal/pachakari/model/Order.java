package com.nirmal.pachakari.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private String orderName;
	private String userId;
	private Timestamp purchaseDate;
	private List<PurchaseItem> items;
	private int totalQuantity;
	private BigDecimal totalPrice;
}
