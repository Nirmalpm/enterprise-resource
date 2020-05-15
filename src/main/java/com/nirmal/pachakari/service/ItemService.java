package com.nirmal.pachakari.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nirmal.pachakari.model.Item;

@Service("item1")
public interface ItemService {
	Item addItem(Item item);
	List<Item> getItems();
}
