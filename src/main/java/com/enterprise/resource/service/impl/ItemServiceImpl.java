package com.enterprise.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.resource.dao.impl.ItemDAOImpl;
import com.enterprise.resource.dao.redis.PurchaseItemDao;
import com.enterprise.resource.model.Item;
import com.enterprise.resource.model.PurchaseItem;
import com.enterprise.resource.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDAOImpl itemDAO;
	
	@Autowired
	PurchaseItemDao purchaseItemDao; 

	@Override
	public Item addItem(Item item) {		
		return itemDAO.addItem(item) ;
	}

	@Override
	public List<Item> getItems(Integer enterpriseId) {
		return itemDAO.getItems(enterpriseId) ;
	}

	@Override
	public List<PurchaseItem> addToCart(PurchaseItem item, String user) {
		return purchaseItemDao.addItem(item,user);
	}

	@Override
	public List<PurchaseItem> removeFromCart(Integer itemId, String user) {
		return purchaseItemDao.removeItem(user,itemId);
	}
	
	@Override
	public List<PurchaseItem> getAllCartItems(String user) {
		return purchaseItemDao.getItems(user);
	}

	@Override
	public void removeAllFromCart(String user) {
		purchaseItemDao.removeAll(user);
		
	}

}
