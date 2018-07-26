package mystore.dao;
 
import org.springframework.orm.hibernate4.HibernateTemplate;

import mystore.model.ItemData;

import java.util.*; 

public class ItemDataDao {

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	//method to save ItemData  
	public void saveItemData(ItemData itemData){  
		template.setCheckWriteOperations(false);
	    template.save(itemData); 
	    System.out.println("Item added");
	}  
	
	//method to return all ItemData
	public List<ItemData> getItemData(){  
	    List<ItemData> list=new ArrayList<ItemData>();  
	    list=template.loadAll(ItemData.class);  
	    return list;  
	}  
	
	public ItemData getItem(String itemName)
	{
		ItemData item =new ItemData();
		item = template.get(ItemData.class,itemName);
		return item;
	}
	
}
