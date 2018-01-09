package mystore.model;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class StoreDetails
{

	
	//ItemDataJaxb[] itemArray =new ItemDataJaxb[];

	private List<ItemData> itemList =null;
	//private ItemDataJaxb[] itemList=null;

	public List<ItemData> getItemList(){

		return itemList;
	}

	public void setItemList(List<ItemData> itemList)
	{
		this.itemList=itemList;
	
	}
}







