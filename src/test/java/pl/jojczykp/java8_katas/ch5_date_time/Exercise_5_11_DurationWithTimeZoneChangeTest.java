package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.temporal.ChronoUnit.MINUTES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_5_11_DurationWithTimeZoneChangeTest {

	private Exercise_5_11_DurationWithTimeZoneChange testee = new Exercise_5_11_DurationWithTimeZoneChange();

	@Test
	public void shouldCalculateLocalDateTimeAtFlightDestination() {
		final ZoneId srcZone = ZoneId.of("America/Los_Angeles");
		final LocalDateTime startDateTime = LocalDateTime.of(2016, 2, 11, 15, 1);
		final ZoneId dstZone = ZoneId.of("Europe/Berlin");
		final LocalDateTime landingDateTime = LocalDateTime.of(2016, 2, 12, 8, 51);
		final Duration expectedDuration = Duration.of(8 * 60 + 50, MINUTES);

		Duration result = testee.calculateFlightDuration(
									srcZone, startDateTime, dstZone, landingDateTime);

		assertThat(result, is(equalTo(expectedDuration)));
	}

}
