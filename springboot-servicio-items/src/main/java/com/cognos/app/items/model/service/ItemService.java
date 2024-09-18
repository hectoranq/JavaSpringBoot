package com.cognos.app.items.model.service;

import java.util.List;

import com.cognos.app.items.model.Item;

public interface ItemService {
	public List<Item> findAll();
	public Item findbyId(Long id, Integer cantidad);

}
