package br.com.livelo.solid.strategy;

import br.com.livelo.solid.domain.Account;

public class MultiplierFactory {

	private static MultiplierFactory multiplierFactory;

	private MultiplierFactory() {

	}

	public static MultiplierFactory getInstance() {
		if (multiplierFactory == null) {
			multiplierFactory = new MultiplierFactory();
		}
		return multiplierFactory;
	}

	public Multiplier getMultiplier(Account account) {
		if (account.isClub()) {
			return new MultiplierClub();
		} else if (account.getAccountNumber().startsWith("1")) {
			return new MultiplierFirstAccount();
		} else if (account.getAccountNumber().startsWith("2")) {
			return new MultiplierSecondAccount();
		}
		
		return new DefaultMultiplier();
	}
}
