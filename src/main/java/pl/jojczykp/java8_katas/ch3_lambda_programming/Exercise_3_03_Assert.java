package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.function.BooleanSupplier;

public class Exercise_3_03_Assert {

	public void assert8(BooleanSupplier condition) {
		if (!condition.getAsBoolean()) {
			throw new AssertionError();
		}
	}

}
