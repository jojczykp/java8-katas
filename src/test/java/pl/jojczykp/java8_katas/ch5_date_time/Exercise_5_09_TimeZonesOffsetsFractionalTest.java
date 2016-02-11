package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Exercise_5_09_TimeZonesOffsetsFractionalTest {

	private static final LocalDateTime TODAY = LocalDateTime.of(2016, 2, 11, 14, 10, 0);

	@Test
	public void shouldOverlapIfOnlyBeginningInside() {
		Set<String> fractionalZones = Exercise_5_09_TimeZonesOffsetsFractional
				.zonesWithFractionalOffsetsFor(TODAY);
		
		assertThat(fractionalZones, containsInAnyOrder(
				"America/St_Johns", "NZ-CHAT", "Pacific/Chatham", "Australia/Eucla", "Australia/North",
				"Australia/Yancowinna", "Australia/Adelaide", "Asia/Pyongyang", "Canada/Newfoundland",
				"Asia/Kolkata", "Australia/Broken_Hill", "Pacific/Marquesas", "Pacific/Norfolk",
				"Australia/South", "Asia/Kathmandu", "Asia/Colombo", "Iran", "Asia/Tehran", "Asia/Katmandu",
				"Australia/Darwin", "Asia/Rangoon", "Asia/Calcutta", "Asia/Kabul", "Indian/Cocos",
				"America/Caracas"));
	}

}
