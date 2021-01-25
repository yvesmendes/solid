package br.com.livelo.solid.strategy;

import java.math.BigDecimal;

public class DefaultMultiplier implements Multiplier {

	@Override
	public BigDecimal getMultiplierValue() {
		return BigDecimal.ONE;
	}

}
