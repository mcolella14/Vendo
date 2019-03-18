package com.matt.models;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class ItemJDBCDAO implements ItemDAO {
	

	private JdbcTemplate jdbcTemplate;
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Autowired
	public ItemJDBCDAO(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

	
	public List<Item> getAllItems(){
		List<Item> items = new ArrayList<Item>();
		String nameQuery = " SELECT * FROM slots ORDER BY slot_number";
		SqlRowSet results = jdbcTemplate.queryForRowSet(nameQuery);
		while(results.next()) {
		items.add(mapRowToItem(results));
		}
		return items;
	}
	
	private Item mapRowToItem(SqlRowSet row) {
		Item item = new Item();
		item.setName(row.getString("name"));
		item.setType(row.getString("type"));
		item.setSlotNumber(row.getString("slot_number"));
		System.out.println(row.getString("slot_number"));
		item.setQuantity(row.getInt("quantity"));
		item.setPrice(row.getDouble("price"));
		item.setPriceString(formatter.format(row.getDouble("price")));
		return item;
	}


	


	public String getItemName(String slotNum) {
		String itemName = "";
		String nameQuery = " SELECT name FROM slots WHERE slot_number = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(nameQuery, slotNum);
		if(results.next()) {
		itemName = results.getString("name");
		}
		return itemName;
	}

	
	public double getItemPrice(String slotNum) {
		double itemPrice = 0.0;
		String nameQuery = " SELECT price FROM slots WHERE slot_number = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(nameQuery, slotNum);
		if(results.next()) {
		itemPrice = results.getDouble("price");
		}
		return itemPrice;
	}
	


	public int getQuantity(String slotNum) {
		int itemQuantity = 0;
		String nameQuery = " SELECT quantity FROM slots WHERE slot_number = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(nameQuery, slotNum);
		if (results.next()){
		itemQuantity = results.getInt("quantity");
		}
		return itemQuantity;
	}


	public void decreaseQuantity(String slotNum) {
		String number = slotNum.toUpperCase();
		String nameQuery = " UPDATE slots SET quantity = (quantity - 1) WHERE slot_number = ? ";
		jdbcTemplate.update(nameQuery, number);
		System.out.println(number);
	}

}
