package com.nirmal.pachakari.dao;

import java.util.List;

public interface ItemDAO<Item> extends BaseDAO{
	public Item addItem(Item item);
	public List<Item> getItems();
}
