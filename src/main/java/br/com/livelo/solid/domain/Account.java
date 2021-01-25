package br.com.livelo.solid.domain;

import java.math.BigDecimal;

import br.com.livelo.solid.exceptions.InvalidBalanceException;
import br.com.livelo.solid.strategy.MultiplierFactory;
import br.com.livelo.solid.utils.OperatorUtils;
import lombok.Data;

@Data
public class Account implements Debit, Credit {

	private final String accountNumber;
	private BigDecimal balance;
	private boolean club;

	private Account(String accountNumber, BigDecimal balance, boolean club) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.club = club;
	}

	@Override
	public void credit(BigDecimal amount) {
		BigDecimal multiplier = getMultiplier();
		this.balance = balance.add(amount.multiply(multiplier));
	}

	private BigDecimal getMultiplier() {
		return MultiplierFactory.getInstance().getMultiplier(this).getMultiplierValue();
	}

	@Override
	public void debit(BigDecimal amount) throws InvalidBalanceException {
		if (OperatorUtils.isGreatherThan(this.balance, amount)) {
			throw new InvalidBalanceException();
		}
		this.balance = balance.subtract(amount);
	}
}
