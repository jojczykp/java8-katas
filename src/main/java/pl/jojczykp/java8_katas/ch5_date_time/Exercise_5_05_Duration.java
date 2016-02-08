package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Exercise_5_05_Duration {

	private static final int YEAR = 1960;
	private static final int MONTH = 7;
	private static final int DAY = 20;

	public long daysSinceApolloMoonLanding(Instant now) {
		return Duration
				.between(Instant.from(
						ZonedDateTime.of(YEAR, MONTH, DAY, 0, 0, 0, 0, ZoneId.systemDefault())),
						now)
				.toDays();
	}

}
