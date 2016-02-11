package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Exercise_5_11_DurationWithTimeZoneChange {

	public Duration calculateFlightDuration(ZoneId srcZone, LocalDateTime startDateTime,
											ZoneId dstZone, LocalDateTime landingDateTime) {
		return Duration.between(
				ZonedDateTime.of(startDateTime, srcZone),
				ZonedDateTime.of(landingDateTime, dstZone)
		);
	}

}
