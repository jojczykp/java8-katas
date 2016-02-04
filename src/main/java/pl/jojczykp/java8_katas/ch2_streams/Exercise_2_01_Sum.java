package pl.jojczykp.java8_katas.ch2_streams;

import static java.util.Arrays.stream;

public class Exercise_2_01_Sum {

	public int sumLengthsInParallel(String[] words) {
		return stream(words)
				.parallel().unordered()
				.mapToInt(String::length)
				.sum();
	}

}
