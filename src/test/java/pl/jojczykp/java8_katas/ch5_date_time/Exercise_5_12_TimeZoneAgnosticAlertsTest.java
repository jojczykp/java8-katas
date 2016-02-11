package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Exercise_5_12_TimeZoneAgnosticAlertsTest {

	private Exercise_5_12_TimeZoneAgnosticAlerts testee = new Exercise_5_12_TimeZoneAgnosticAlerts();

	@Test
	public void shouldAlertWithIncomingEvents() {
		final ZoneId localZone = ZoneId.of("Europe/Warsaw");
		final LocalDateTime localDateTime = LocalDateTime.of(2016, 2, 11, 16, 5);
		final Duration duration = Duration.ofHours(1);
		final Map<ZonedDateTime, String> messages = new HashMap<>();
		messages.put(ZonedDateTime.parse("2016-02-11T16:09:30+01:00[Europe/Warsaw]"), "Event in Warsaw");
		messages.put(ZonedDateTime.parse("2016-02-11T16:09:30+10:00[Australia/Sydney]"), "Event in Sydney");
		messages.put(ZonedDateTime.parse("2016-02-11T07:45:00-08:00[America/Los_Angeles]"), "Event in Los Angeles");
		messages.put(ZonedDateTime.parse("2016-02-11T17:10:11+01:00[Europe/Madrid]"), "Event in Madrid");

		List<String> result = testee.getIncomingEvents(messages, localZone, localDateTime, duration);

		assertThat(result, containsInAnyOrder("Event in Warsaw", "Event in Los Angeles"));
	}

}
