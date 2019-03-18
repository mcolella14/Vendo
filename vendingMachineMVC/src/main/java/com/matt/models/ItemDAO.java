package com.matt.models;

import java.util.List;

public interface ItemDAO {
	public List<Item> getAllItems();
	
	public String getItemName(String slotNum);
	
	public double getItemPrice(String slotNum);
	
	public int getQuantity(String slotNum);
	
	public void decreaseQuantity(String slotNum);
	
	

}
