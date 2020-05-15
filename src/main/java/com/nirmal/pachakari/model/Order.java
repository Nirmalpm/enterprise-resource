package com.nirmal.pachakari.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	private String orderName;
	private int userId;
	private Timestamp purchaseDate;
	private List<PurchaseItem> items;
}
