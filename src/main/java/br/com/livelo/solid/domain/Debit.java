package br.com.livelo.solid.domain;

import java.math.BigDecimal;

import br.com.livelo.solid.exceptions.InvalidBalanceException;

public interface Debit {
	void debit(BigDecimal amount) throws InvalidBalanceException;
}
