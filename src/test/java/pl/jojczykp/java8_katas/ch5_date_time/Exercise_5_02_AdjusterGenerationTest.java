package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch5_date_time.Exercise_5_02_AdjusterGeneration.next;

public class Exercise_5_02_AdjusterGenerationTest {

	private static final int CURRENT_YEAR = 2016;
	private static final int CURRENT_MONTH = 2;
	private static final int CURRENT_DAY = 8;

	private static final int NUM_OF_SAT = 6;

	@Test
	public void shouldGenerateAdjuster() {
		LocalDate today = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, CURRENT_DAY);

		LocalDate calculatedNext = today.with(next(w -> w.getDayOfWeek().getValue() < NUM_OF_SAT));

		assertThat(calculatedNext, is(equalTo(LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, CURRENT_DAY + 1))));
	}

	@Test
	public void shouldReturnNextEvenIfCurrentFulfillsPredicate() {
		LocalDate today = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, CURRENT_DAY);

		LocalDate calculatedNext = today.with(next(w -> w.getDayOfMonth() == CURRENT_DAY));

		assertThat(calculatedNext, is(equalTo(LocalDate.of(CURRENT_YEAR, CURRENT_MONTH + 1, CURRENT_DAY))));
	}

}
