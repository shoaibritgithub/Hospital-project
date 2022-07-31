package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@ApiOperation(value = "save the Item",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "item is saved"),
		@ApiResponse(code = 405, message = "bad request,not proper Item data")
	})
	@PostMapping("/medorder/{medorderid}/item")
	public Item saveItem(@PathVariable(name = "medorderid") int mid, @RequestBody Item item) {
		return itemService.saveItemByMedOrderId(mid, item);
	}

	@ApiOperation(value = "get the item by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got the item"),
		@ApiResponse(code = 405, message = "bad request,invalid item id")
	})
	@GetMapping("/item")
	public Item getItemById(@RequestParam int id) {
		return itemService.getItemById(id);
	}

	@ApiOperation(value = "get All the Item my MedorderId",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "got all the item"),
		@ApiResponse(code = 405, message = "bad request,invalid medorder id")
	})
	@GetMapping("/item/medorder")
	public List<Item> getAllItemByMedorderId(int medorderid) {
		return itemService.getAllItemByMedOrderId(medorderid);
	}

	@ApiOperation(value = "update the item by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "item is updated"),
		@ApiResponse(code = 405, message = "bad request,invalid item id,not proper Item data")
	})
	@PutMapping("/item")
	public Item updateItem(@RequestParam int id, @RequestBody Item item) {
		return itemService.updateItemById(id, item);
	}
	
	@ApiOperation(value = "Delete the Item by ID",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "item is Deleted"),
		@ApiResponse(code = 405, message = "bad request,invalid item id")
	})
	@DeleteMapping("/item")
	public void deleteItemById(@RequestParam int id) {
		itemService.deleteItemById(id);
	}
}