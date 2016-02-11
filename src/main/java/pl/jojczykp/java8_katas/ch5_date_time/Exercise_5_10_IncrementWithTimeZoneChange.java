package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Exercise_5_10_IncrementWithTimeZoneChange {

	public LocalDateTime calculateLocalFlightDestinationTime(
			ZoneId srcZone, LocalDateTime startDateTime, long tripMinutes, ZoneId dstZone) {
		return ZonedDateTime.of(startDateTime, srcZone)
				.plusMinutes(tripMinutes).withZoneSameLocal(dstZone).toLocalDateTime();
	}

}
