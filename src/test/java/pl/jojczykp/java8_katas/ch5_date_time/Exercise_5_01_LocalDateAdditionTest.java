package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_5_01_LocalDateAdditionTest {

	private Exercise_5_01_LocalDateAddition testee = new Exercise_5_01_LocalDateAddition();

	@Test
	public void shouldCalculateProgrammersDayInNonLeapYear() {
		final int year = 2017;
		final int month = 9;
		final int day = 14;

		LocalDate programmersDay = testee.calculateProgrammersDayIn(year);

		assertThat(programmersDay, is(equalTo(LocalDate.of(year, month, day))));
	}

	@Test
	public void shouldCalculateProgrammersDayInLeapYear() {
		final int year = 2016;
		final int month = 9;
		final int day = 13;

		LocalDate programmersDay = testee.calculateProgrammersDayIn(year);

		assertThat(programmersDay, is(equalTo(LocalDate.of(year, month, day))));
	}

}
