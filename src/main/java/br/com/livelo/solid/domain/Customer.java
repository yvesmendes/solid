package br.com.livelo.solid.domain;

import lombok.Data;

@Data
public class Customer{
	private final String id;
	private String name;
	private int age;
	
	private Account account;

	public Customer(String id, String name, int age, Account account) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.account = account;
	}
}
