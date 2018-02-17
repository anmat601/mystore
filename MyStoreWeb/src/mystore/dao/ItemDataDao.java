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
	    template.save(itemData);  
	}  
	
	//method to return all ItemData
	public List<ItemData> getItemData(){  
	    List<ItemData> list=new ArrayList<ItemData>();  
	    list=template.loadAll(ItemData.class);  
	    return list;  
	}  
}
