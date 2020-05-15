package com.nirmal.pachakari.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmal.pachakari.dao.impl.ItemDAOImpl;
import com.nirmal.pachakari.model.Item;
import com.nirmal.pachakari.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDAOImpl itemDAO;

	@Override
	public Item addItem(Item item) {		
		return itemDAO.addItem(item) ;
	}

	@Override
	public List<Item> getItems() {
		return itemDAO.getItems() ;
	}

}
