package pl.jojczykp.java8_katas.ch2_streams;

import java.util.stream.Stream;

public final class Exercise_2_7_CountClosesStream {

	private Exercise_2_7_CountClosesStream() {
	}

	/**
	 * Side effect: closes stream
	 */
	public static <T> boolean isFinite(Stream<T> stream) {
		stream.count();
		return true;
	}
}
