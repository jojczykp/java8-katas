package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise1Test {

	private static final String[] WORDS = {"once", "upon", "a", "time"};
	private static final int SUM_LENGTH = 13;

	private Exercise1 testee = new Exercise1();

	@Test
	public void shouldSumLengths() {
		int sum = testee.sumLengthsInParallel(WORDS);

		assertThat(sum, is(equalTo(SUM_LENGTH)));
	}

}
