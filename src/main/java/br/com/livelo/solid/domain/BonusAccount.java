package br.com.livelo.solid.domain;

import java.math.BigDecimal;

import br.com.livelo.solid.exceptions.InvalidBalanceException;
import br.com.livelo.solid.utils.OperatorUtils;
import lombok.Data;

@Data
public class BonusAccount implements Debit{

	private final String accountNumber;
	private BigDecimal balance;
	
	
	private BonusAccount(String accountNumber, BigDecimal balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	@Override
	public void debit(BigDecimal amount) throws InvalidBalanceException {
		if (OperatorUtils.isGreatherThan(this.balance, amount)) {
			throw new InvalidBalanceException();
		}
		this.balance = balance.subtract(amount);
	}
}
