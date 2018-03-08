package mystore.service;

import javax.jws.WebService;
import mystore.model.StoreDetails;

@WebService
public interface ItemManagementInterface {

	int getPriceOfItem(String itemName);
	String getMeasurementOfItem(String itemName);
}
