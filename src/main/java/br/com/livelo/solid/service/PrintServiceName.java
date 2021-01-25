package br.com.livelo.solid.service;

import br.com.livelo.solid.domain.Customer;

public class PrintServiceName implements PrintService{


	@Override
	public String format(Customer customer) {
		return new StringBuilder("Name: ")
				.append(customer.getName())
				.append(System.lineSeparator())
				.append("Age: ")
				.append(customer.getAge())
				.append(System.lineSeparator())
				.append("Club: ")
				.append(customer.getAccount().isClub() ? "yes" : "no").toString();
	}
}
