package com.enterprise.resource.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enterprise.resource.model.Item;
import com.enterprise.resource.model.PurchaseItem;

@Service("item1")
public interface ItemService {
	Item addItem(Item item);
	List<Item> getItems(Integer enterpriseId);
	List<PurchaseItem> addToCart(PurchaseItem item, String user);
	List<PurchaseItem> removeFromCart(Integer itemId, String user);
	List<PurchaseItem> getAllCartItems(String user);
	void removeAllFromCart(String user);
}
