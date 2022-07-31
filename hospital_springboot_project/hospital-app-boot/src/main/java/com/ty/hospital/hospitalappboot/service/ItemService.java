package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.ItemDao;
import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.exception.IdNotFoundException;
@Service
public class ItemService {

	@Autowired
	private ItemDao itemdao;

	public Item saveItemByMedOrderId(int id, Item item) {
		Item item1 = itemdao.saveItem(id, item);
		if (item1 == null) {
			throw new IdNotFoundException();
		}
		return item1;
	}

	public Item getItemById(int id) {
		Item item = itemdao.getItemById(id);
		if (item == null) {
			throw new IdNotFoundException();
		}
		return item;
	}

	public List<Item> getAllItemByMedOrderId(int id) {
		List<Item> items = itemdao.getAllItemByMedorderId(id);
		if (items.isEmpty()) {
			throw new IdNotFoundException();
		}
		return items;
	}

	public Item updateItemById(int id, Item item) {
		Item item1 = itemdao.updateItem(id, item);
		if (item1 == null) {
			throw new IdNotFoundException();
		}
		return item1;
	}

	public boolean deleteItemById(int id) {
		boolean item = itemdao.deleteItemById(id);
		if (item == false) {
			throw new IdNotFoundException();
		}
		return true;
	}

}
