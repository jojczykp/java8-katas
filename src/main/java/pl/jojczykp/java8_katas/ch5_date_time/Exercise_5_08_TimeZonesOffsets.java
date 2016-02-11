package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public final class Exercise_5_08_TimeZonesOffsets {

	private Exercise_5_08_TimeZonesOffsets() {
	}

	public static Map<String, ZoneOffset> offsetsOf(LocalDateTime dateTime) {
		return ZoneId.getAvailableZoneIds()
				.stream().collect(toMap(
						identity(),
					zone -> dateTime.atZone(ZoneId.of(zone)).getOffset()));
	}

}
