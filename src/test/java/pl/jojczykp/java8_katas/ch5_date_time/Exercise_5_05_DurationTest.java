package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_5_05_DurationTest {

	private static final Instant NOW = Instant.parse("2016-02-08T00:00:00Z");
	private static final long EXPECTED_DURATION = 20291L;

	private Exercise_5_05_Duration testee = new Exercise_5_05_Duration();

	@Test
	public void shouldTellHowManyDaysImAlive() {
		long days = testee.daysSinceApolloMoonLanding(NOW);

		assertThat(days, is(equalTo(EXPECTED_DURATION)));
	}

}
