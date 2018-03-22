package mystore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mystore.model.ItemData;
import mystore.service.ItemManagement;

@RestController("/item")
//@RequestMapping("/item")
public class ItemManagementController {

	@Autowired
	private ItemManagement itemManagement;
	public ItemManagement getItemManagement() {
		return itemManagement;
	}
	public void setItemManagement(ItemManagement itemManagement) {
		this.itemManagement = itemManagement;
	}
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody  List<ItemData> GetItems()
	{  List<ItemData> items =new ArrayList<ItemData>();
	try
	{
		items =itemManagement.GetAllItems();
	}

	catch(Exception e)
	{
		e.printStackTrace();	
	}
	return items;
	}
}
