package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.temporal.ChronoUnit.MINUTES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_5_10_IncrementWithTimeZoneChangeTest {

	private Exercise_5_10_IncrementWithTimeZoneChange testee = new Exercise_5_10_IncrementWithTimeZoneChange();

	@Test
	public void shouldCalculateLocalDateTimeAtFlightDestination() {
		final ZoneId srcZone = ZoneId.of("America/Los_Angeles");
		final LocalDateTime startDateTime = LocalDateTime.of(2016, 2, 11, 15, 1);
		final Duration duration = Duration.of(10 * 60 + 50, MINUTES);
		final ZoneId dstZone = ZoneId.of("Europe/Berlin");
		final LocalDateTime expectedLanding = LocalDateTime.of(2016, 2, 12, 1, 51);

		LocalDateTime result = testee.calculateLocalFlightDestinationTime(
									srcZone, startDateTime, duration, dstZone);

		assertThat(result, is(equalTo(expectedLanding)));
	}

}
