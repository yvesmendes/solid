package br.com.livelo.solid.domain;

import lombok.Data;

@Data
public class CustomerPJ {

	private final String id;
	private String name;
	private BonusAccount account;

	public CustomerPJ(String id, String name, BonusAccount account) {
		this.id = id;
		this.name = name;
		this.account = account;
	}
}
