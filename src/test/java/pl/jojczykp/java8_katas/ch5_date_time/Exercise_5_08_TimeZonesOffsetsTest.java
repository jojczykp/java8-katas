package pl.jojczykp.java8_katas.ch5_date_time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_5_08_TimeZonesOffsetsTest {

	private static final int ONE_HOUR = 3600;
	private static final LocalDateTime TODAY = LocalDateTime.of(2016, 2, 11, 14, 10, 0);

	@Test
	public void shouldOverlapIfOnlyBeginningInside() {
		Map<String, ZoneOffset> idToOffset = Exercise_5_08_TimeZonesOffsets.offsetsOf(TODAY);

		assertThat(idToOffset.get("Poland").getTotalSeconds(), is(equalTo(ONE_HOUR)));
		// Putting now more here seems to be waste... :)
	}

}
