package pl.jojczykp.java8_katas.ch2_streams;

import java.util.stream.Stream;

public final class Exercise2_7 {

	private Exercise2_7() {
	}

	/**
	 * Side effect: closes stream
	 */
	public static <T> boolean isFinite(Stream<T> stream) {
		stream.count();
		return true;
	}
}