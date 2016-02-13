package pl.jojczykp.java8_katas.test_tools;

import java.time.Duration;
import java.time.Instant;

public final class DurationTools {

	private DurationTools() {
	}

	public static Duration durationOf(Runnable action) {
		Instant beg = Instant.now();
		action.run();
		Instant end = Instant.now();

		return Duration.between(beg, end);
	}

}
