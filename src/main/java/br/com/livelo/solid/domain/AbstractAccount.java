package br.com.livelo.solid.domain;

import java.math.BigDecimal;

import br.com.livelo.solid.exceptions.InvalidBalanceException;


public abstract class AbstractAccount {

	public abstract void credit(BigDecimal amount);
	public abstract void debit(BigDecimal amount) throws InvalidBalanceException;
}
