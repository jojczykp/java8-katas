package pl.jojczykp.java8_katas.ch5_date_time;

public class Exercise_5_07_TimeInterval {

	private static final int MINS_PER_HOUR = 60;

	private int beg;
	private int end;

	public Exercise_5_07_TimeInterval(int startHour, int startMinute, int endHour, int endMinute) {
		beg = toMinutes(startHour, startMinute);
		end = toMinutes(endHour, endMinute);
	}

	public static Exercise_5_07_TimeInterval anIntervalOf(
										int startHour, int startMinute, int endHour, int endMinute) {
		return new Exercise_5_07_TimeInterval(startHour, startMinute, endHour, endMinute);
	}

	public boolean overlaps(Exercise_5_07_TimeInterval that) {
		return this.contains(that.beg) || this.contains(that.end) ||
				that.contains(this.beg) || that.contains(this.end);
	}

	private int toMinutes(int startHour, int startMinute) {
		return startHour * MINS_PER_HOUR + startMinute;
	}

	private boolean contains(int moment) {
		return beg <= moment && moment < end;
	}

}
