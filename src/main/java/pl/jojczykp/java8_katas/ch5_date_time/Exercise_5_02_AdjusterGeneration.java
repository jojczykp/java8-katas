package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public final class Exercise_5_02_AdjusterGeneration {

	private Exercise_5_02_AdjusterGeneration() {
	}

	public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
		return w -> {
			LocalDate result = (LocalDate) w;
			do {
				result = result.plusDays(1);
			}
			while (!predicate.test(result));

			return result;
		};
	}

}
