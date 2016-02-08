package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_5_04_CalTest {

	private static final int YEAR = 1983;
	private static final int MONTH = 12;

	private Exercise_5_04_Cal testee = new Exercise_5_04_Cal();

	@Test
	public void shouldGenerateCalOutput() {
		String output = testee.cal(MONTH, YEAR);

		assertThat(output, is(equalTo(
				"             1  2  3\n" +
				" 4  5  6  7  8  9 10\n" +
				"11 12 13 14 15 16 17\n" +
				"18 19 20 21 22 23 24\n" +
				"25 26 27 28 29 30 31\n")));
	}

}
