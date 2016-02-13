package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_6_09_ParallelPrefixTest {

	private Exercise_6_09_ParallelPrefix testee = new Exercise_6_09_ParallelPrefix();

	@Test
	public void shouldGenerateFibonacciNumbersByMatrixMultiplication() {
		final int[] expected = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

		int[] result = testee.getFirstFibonacciNumbers(expected.length);

		assertThat(result, is(equalTo(expected)));
	}

}
