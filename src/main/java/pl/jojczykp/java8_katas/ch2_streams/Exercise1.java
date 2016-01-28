package pl.jojczykp.java8_katas.ch2_streams;

import static java.util.Arrays.stream;

public class Exercise1 {

	public int sumLengthsInParallel(String[] words) {
		return stream(words).parallel()
				.mapToInt(String::length)
				.sum();
	}

}
