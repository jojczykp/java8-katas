package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Exercise_5_06_IncrementByUnitTest {

	private static final int CENTURY = 20;
	private static final int EXPECTED_RESULT = 173;

	private Exercise_5_06_IncrementByUnit testee = new Exercise_5_06_IncrementByUnit();

	@Test
	public void shouldTellHowManyFridays13WasIn20thCentury() {
		int result = testee.getNumberOfFridays13In(CENTURY);

		assertThat(result, is(equalTo(EXPECTED_RESULT)));
	}

}
