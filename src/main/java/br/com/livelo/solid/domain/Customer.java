package br.com.livelo.solid.domain;

import java.math.BigDecimal;

import br.com.livelo.solid.exceptions.InvalidBalanceException;
import br.com.livelo.solid.utils.OperatorUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends AbstractAccount {

	private final static BigDecimal MULTIPLIER_CHILD = new BigDecimal(0.5);
	private final static BigDecimal MULTIPLIER_CLUB = new BigDecimal(2);
	private final static BigDecimal MULTIPLIER_ADULT = new BigDecimal(1.5);

	private final String id;
	private String name;
	private int age;
	private final String accountNumber;
	private BigDecimal balance;
	private boolean club;

	public Customer(String id, String name, int age, String accountNumber, BigDecimal balance) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	@Override
	public void credit(BigDecimal amount) {

		BigDecimal multiplier = BigDecimal.ONE;

		if (club) {
			multiplier = MULTIPLIER_CHILD;
		} else if (age < 18) {
			multiplier = MULTIPLIER_CLUB;
		} else if (age > 30) {
			multiplier = MULTIPLIER_ADULT;
		}

		this.balance = balance.add(amount.multiply(multiplier));
	}

	@Override
	public void debit(BigDecimal amount) throws InvalidBalanceException {
		if (OperatorUtils.isGreatherThan(this.balance, amount)) {
			throw new InvalidBalanceException();
		}
		this.balance = balance.subtract(amount);
	}
}
