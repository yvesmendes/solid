package br.com.livelo.solid.domain;

import java.math.BigDecimal;

import br.com.livelo.solid.exceptions.InvalidBalanceException;
import br.com.livelo.solid.exceptions.InvalidOperation;
import br.com.livelo.solid.utils.OperatorUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerPJ extends AbstractAccount{

	private final String id;
	private String name;
	private final String accountNumber;
	private BigDecimal balance;
	
	public CustomerPJ(String id, String name, String accountNumber, BigDecimal balance) {
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	@Override
	public void credit(BigDecimal amount) {
		throw new InvalidOperation();
	}
	
	@Override
	public void debit(BigDecimal amount) throws InvalidBalanceException {
		if(OperatorUtils.isGreatherThan(this.balance, amount)) {
			throw new InvalidBalanceException();
		}
		this.balance = balance.subtract(amount);
	}
}
