package com.enterprise.resource.dao.impl.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.enterprise.resource.dao.redis.PurchaseItemDao;
import com.enterprise.resource.model.PurchaseItem;

@Repository
public class PurchaseItemDaoImpl implements PurchaseItemDao<PurchaseItem> {
	
	RedisTemplate<String, PurchaseItem> redisTemplate;
	private HashOperations hashOperations;
	
	public PurchaseItemDaoImpl(RedisTemplate<String, PurchaseItem> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public List<PurchaseItem> addItem(PurchaseItem item,String user) {
		hashOperations.put(user, item.getItemId(), item);
		Map <String, PurchaseItem> itemsMap = hashOperations.entries(user);
		List<PurchaseItem> itemList = new ArrayList<PurchaseItem>(itemsMap.values());		
		return itemList;
	}

	@Override
	public List<PurchaseItem> removeItem(String user,Integer... itemIds) {
		hashOperations.delete(user, itemIds);
		Map <String, PurchaseItem> itemsMap = hashOperations.entries(user);
		List<PurchaseItem> itemList = new ArrayList<PurchaseItem>(itemsMap.values());		
		return itemList;
	}
	
	@Override
	public void removeAll(String user) {
		
		Set keys = hashOperations.keys(user);
		keys.stream().forEach((key) -> {
			hashOperations.delete(user, key);
		});
		
	}

	@Override
	public List<PurchaseItem> getItems(String user) {
		Map <String, PurchaseItem> itemsMap = hashOperations.entries(user);
		List<PurchaseItem> itemList = new ArrayList<PurchaseItem>(itemsMap.values());		
		return itemList;
	}

}
