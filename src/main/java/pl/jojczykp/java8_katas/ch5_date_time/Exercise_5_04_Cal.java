package pl.jojczykp.java8_katas.ch5_date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Exercise_5_04_Cal {

	public String cal(int month, int year) {
		LocalDate current = LocalDate.of(year, month, 1);
		String result = gapAtTheBeginningFor(current);
		do {
			result += String.format("%2d", current.getDayOfMonth()) +
					(current.getDayOfWeek() == DayOfWeek.SATURDAY ? "\n" : " ");
			current = current.plusDays(1);
		} while (current.getDayOfMonth() != 1);

		return result;
	}

	private String gapAtTheBeginningFor(LocalDate current) {
		return repeat(current.getDayOfWeek().getValue(), "   ");
	}

	private String repeat(int n, String string) {
		return new String(new char[n]).replace("\0", string);
	}

}
