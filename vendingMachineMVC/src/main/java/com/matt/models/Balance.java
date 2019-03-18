package com.matt.models;

import java.text.NumberFormat;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component
public class Balance {
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	@Min(value=0, message="Balance too low")
	private static Double balance = 0.00;
	

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
