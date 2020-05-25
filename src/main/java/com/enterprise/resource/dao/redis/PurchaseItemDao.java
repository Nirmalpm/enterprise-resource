package com.enterprise.resource.dao.redis;

import java.util.List;

public interface PurchaseItemDao<PurchaseItem> {
	public List<PurchaseItem> addItem(PurchaseItem item, String user);
	public List<PurchaseItem> removeItem(String user, Integer... itemIds);
	public void removeAll(String user);
	public List<PurchaseItem> getItems(String user);
}
