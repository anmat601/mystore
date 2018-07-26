package mystore.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import mystore.bean.BeanManager;
import mystore.model.ItemData;
import mystore.service.ItemManagement;

@RestController

public class ItemManagementController
{

	final static Logger logger = LogManager.getLogger(ItemManagementController.class);
	@Autowired
	private ItemManagement itemManagement;

	public ItemManagement getItemManagement() 
	{
		return itemManagement;
	}
	public void setItemManagement(ItemManagement itemManagement)
	{
		this.itemManagement = itemManagement;
	}

	@RequestMapping("/getAllItems")
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


	@RequestMapping("/addItem")	
	public @ResponseBody void AddItem(@RequestBody ItemData item)
	{ 
		logger.debug(item);
		try
		{
			itemManagement.addItem(item);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}

	}

}

