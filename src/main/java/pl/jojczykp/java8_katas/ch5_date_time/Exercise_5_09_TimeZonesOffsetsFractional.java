package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public final class Exercise_5_09_TimeZonesOffsetsFractional {

	private static final int SECONDS_PER_HOUR = 3600;

	private Exercise_5_09_TimeZonesOffsetsFractional() {
	}

	public static Set<String> zonesWithFractionalOffsetsFor(LocalDateTime dateTime) {
		return ZoneId.getAvailableZoneIds()
				.stream()
				.filter(z -> ZoneId.of(z).getRules().getOffset(dateTime)
								.getTotalSeconds() % SECONDS_PER_HOUR != 0)
				.collect(toSet());
	}

}
