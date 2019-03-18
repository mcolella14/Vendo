package com.matt.controllers;

import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.matt.models.Balance;
import com.matt.models.Item;
import com.matt.models.ItemDAO;


@Controller 
public class HomeController {
	
	 @Autowired
	 ItemDAO itemDao;
	 
	 @Autowired
	 Balance balance;

	 
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
	 
	@RequestMapping(value={"/","/home"})
	public String displayHome(HttpServletRequest request, HttpSession session) {
		request.setAttribute("items", itemDao.getAllItems());
		session.setAttribute("balance", formatter.format(balance.getBalance()));

		return "home";
	}
	
	@RequestMapping(path="/item", method=RequestMethod.GET)
	public String getItemInfo(@RequestParam String slot, HttpServletRequest request) {
		
		String itemName = itemDao.getItemName(slot);
		double itemPrice = itemDao.getItemPrice(slot);
		Item item = new Item();
		item.setName(itemName);
		item.setPrice(itemPrice);
		item.setSlotNumber(slot);
		item.setQuantity(itemDao.getQuantity(slot));
		item.setPriceString(formatter.format(itemPrice));
		request.setAttribute("item", item);
		return "item";
	}
	
	@RequestMapping(path="/confirmation", method=RequestMethod.POST)
	public String purchaseItem(HttpServletRequest request, @RequestParam String amountToSubtract, @RequestParam String slotNumber, HttpSession session){
		double itemCost = Double.parseDouble(amountToSubtract);
		itemDao.decreaseQuantity(slotNumber);

			balance.setBalance(balance.getBalance() - itemCost);
			session.setAttribute("balance", formatter.format(balance.getBalance()));
			session.setAttribute("balanceNum", balance.getBalance());
			
			return "redirect:/confirmation";

	}
	
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String getConfirmation(){
		
		return "confirmation";
	}
	
	@RequestMapping(path="/balance", method=RequestMethod.POST)
	public String addBalance(HttpSession session, @RequestParam String moneyAdded){
		balance.setBalance(balance.getBalance() + Double.parseDouble(moneyAdded));
		session.setAttribute("balance", formatter.format(balance.getBalance()));
		session.setAttribute("balanceNum", balance.getBalance());
		return "redirect:/balance";
	}
	
	@RequestMapping(path="/balance", method=RequestMethod.GET)
	public String showBalance(HttpSession session){
		session.setAttribute("balance", formatter.format(balance.getBalance()));
		session.setAttribute("balanceNum", balance.getBalance());
		return "balance";
	}
}
