package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Exercise_5_06_IncrementByUnit {

	private static final int YEARS_IN_CENTURY = 100;
	private static final int DESIRED_DAY_OF_MONTH = 13;

	public int getNumberOfFridays13In(int century) {
		int counter = 0;

		LocalDate d = LocalDate.of((century - 1) * YEARS_IN_CENTURY, 1, DESIRED_DAY_OF_MONTH);
		do {
			if (d.getDayOfWeek() == DayOfWeek.FRIDAY) {
				counter++;
			}
			d = d.plusMonths(1);
		} while (belongsTo(century, d));

		return counter;
	}

	private boolean belongsTo(int century, LocalDate d) {
		return d.getYear() <= century * YEARS_IN_CENTURY;
	}
}
