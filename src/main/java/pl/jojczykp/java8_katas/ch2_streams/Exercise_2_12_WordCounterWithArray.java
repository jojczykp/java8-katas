package pl.jojczykp.java8_katas.ch2_streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;

public class Exercise_2_12_WordCounterWithArray {

	public List<Integer> countShortWordsUsingArray(Stream<String> words, int maxLength) {
		AtomicInteger[] shortWords = generate(AtomicInteger::new)
				.limit(maxLength + 1).toArray(AtomicInteger[]::new);

		words.parallel()
				.forEach(s -> {
					if (s.length() <= maxLength) {
						shortWords[s.length()].getAndIncrement();
					}
				});

		return Stream.of(shortWords).map(AtomicInteger::get).collect(toList());
	}

}
