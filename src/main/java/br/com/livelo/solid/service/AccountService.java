package br.com.livelo.solid.service;

import java.math.BigDecimal;

import br.com.livelo.solid.domain.Credit;

public class AccountService {
	public void credit(Credit accountCredit, BigDecimal amount) {
		accountCredit.credit(amount);
	}
}
