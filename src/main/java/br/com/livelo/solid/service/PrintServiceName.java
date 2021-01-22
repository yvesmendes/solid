package br.com.livelo.solid.service;

import br.com.livelo.solid.domain.Customer;

public class PrintServiceName {

	public void print(Customer customer) {
		System.out.println(customer);
	}

	public String format(Customer customer) {
		return new StringBuilder("Name: ")
				.append(customer.getName())
				.append(System.lineSeparator())
				.append("Age: ")
				.append(customer.getAge())
				.append(System.lineSeparator())
				.append("Club: ")
				.append(customer.isClub() ? "yes" : "no").toString();
	}
}
