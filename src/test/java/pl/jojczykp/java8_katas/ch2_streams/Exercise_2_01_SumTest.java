package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_2_01_SumTest {

	private Exercise_2_01_Sum testee = new Exercise_2_01_Sum();

	@Test
	public void shouldSumLengths() {
		final String[] words = {"once", "upon", "a", "time"};
		final int sumLength = 13;

		int sum = testee.sumLengthsInParallel(words);

		assertThat(sum, is(equalTo(sumLength)));
	}

}
