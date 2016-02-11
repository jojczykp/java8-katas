package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Exercise_5_12_TimeZoneAgnosticAlerts {

	public List<String> getIncomingEvents(Map<ZonedDateTime, String> messages,
										ZoneId localZone, LocalDateTime localDateTime, Duration duration) {
		ZonedDateTime base = ZonedDateTime.of(localDateTime, localZone);
		ZonedDateTime deadline = ZonedDateTime.of(localDateTime, localZone).plus(duration);

		return messages.entrySet().stream()
				.filter(e -> e.getKey().isAfter(base) &&
							e.getKey().isBefore(deadline))
				.map(Map.Entry::getValue)
				.collect(toList());
	}

}
