package pl.jojczykp.java8_katas.ch2_streams;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Exercise2 {

	public Set<String> takeFirstLongWords(String[] words, int minLength, int limit, AtomicInteger filterCounter) {
		return stream(words)
				.filter(s -> {
					filterCounter.incrementAndGet();
					return s.length() >= minLength;})
				.limit(limit)
				.collect(Collectors.toSet());
	}

}
