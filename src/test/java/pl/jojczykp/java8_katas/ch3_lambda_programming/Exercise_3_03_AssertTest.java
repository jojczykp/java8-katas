package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

public class Exercise_3_03_AssertTest {

	private Exercise_3_03_Assert testee = new Exercise_3_03_Assert();

	@Test
	public void shouldNotThrowExceptionForConditionTrue() {
		testee.assert8(() -> true);
	}

	@Test(expected = AssertionError.class)
	public void shouldThrowExceptionForConditionFalse() {
		testee.assert8(() -> false);
	}

}
