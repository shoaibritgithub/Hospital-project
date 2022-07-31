package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.dto.MedOrder;
import com.ty.hospital.hospitalappboot.repository.ItemRepository;
import com.ty.hospital.hospitalappboot.repository.MedOrderRepository;

@Repository
public class ItemDao {
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private MedOrderDao medorderdao;

	public Item saveItem(int medorderid, Item item) {
		MedOrder medorder = medorderdao.getMedOrderById(medorderid);
		if (medorder != null) {
			item.setMedorder(medorder);
			itemRepository.save(item);
			return item;
		}
		return null;
	}

	public Item getItemById(int id) {
		Optional<Item> optional = itemRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Item> getAllItemByMedorderId(int medorderid) {
		return itemRepository.getAllItemByMedorderId(medorderid);
	}

	public Item updateItem(int id, Item item) {
		Item exestingitem = getItemById(id);
		if (exestingitem != null) {
			itemRepository.save(item);
			return exestingitem;
		}
		return null;
	}

	public boolean deleteItemById(int id) {
		Item item = getItemById(id);
		if (item != null) {
			itemRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
