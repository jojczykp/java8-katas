package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise_5_01_LocalDateAddition {

	private static final int PROGRAMMERS_DAY_NUM = 256;

	public LocalDate calculateProgrammersDayIn(int year) {
		return LocalDate.of(year, 1, 1).plus(PROGRAMMERS_DAY_NUM, ChronoUnit.DAYS);
	}

}
