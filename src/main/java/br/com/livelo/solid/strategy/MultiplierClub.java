package br.com.livelo.solid.strategy;

import java.math.BigDecimal;

public class MultiplierClub implements Multiplier {

	@Override
	public BigDecimal getMultiplierValue() {
		return new BigDecimal(2);
	}

}
