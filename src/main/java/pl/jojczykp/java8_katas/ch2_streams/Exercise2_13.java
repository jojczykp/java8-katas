package pl.jojczykp.java8_katas.ch2_streams;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Exercise2_13 {

	public Map<Integer, Long> countShortWordsUsingCollectors(Stream<String> words, int maxLength) {
		return words
				.filter(w -> w.length() <= maxLength)
				.collect(
						groupingBy(String::length,
						counting()));
	}

}
