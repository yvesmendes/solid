package br.com.livelo.solid.service;

import br.com.livelo.solid.domain.Customer;

public class PrintServiceDefaultImpl implements PrintService {

	@Override
	public String format(Customer customer) {
		return new StringBuilder("Customer: ")
				.append(customer.getName())
				.append(System.lineSeparator())
				.append("Age: ")
				.append(customer.getAge()).toString();
	}
}
