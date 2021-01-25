package br.com.livelo.solid.strategy;

import java.math.BigDecimal;

public class MultiplierFirstAccount implements Multiplier {

	@Override
	public BigDecimal getMultiplierValue() {
		return new BigDecimal(1.2);
	}

}
