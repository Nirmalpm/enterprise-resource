package com.nirmal.pachakari.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nirmal.pachakari.model.Item;
import com.nirmal.pachakari.model.PurchaseItem;

@Service("item1")
public interface ItemService {
	Item addItem(Item item);
	List<Item> getItems();
	List<PurchaseItem> addToCart(PurchaseItem item, String user);
	List<PurchaseItem> removeFromCart(Integer itemId, String user);
	List<PurchaseItem> getAllCartItems(String user);
	void removeAllFromCart(String user);
}
