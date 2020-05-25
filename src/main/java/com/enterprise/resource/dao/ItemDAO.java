package com.enterprise.resource.dao;

import java.util.List;

public interface ItemDAO<Item> extends BaseDAO{
	public Item addItem(Item item);
	public List<Item> getItems(Integer enterpriseId);
}
