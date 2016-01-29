package pl.jojczykp.java8_katas.ch2_streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;

public class Exercise2_12 {

	public List<Integer> countShortWords(Stream<String> words, int maxLength) {
		AtomicInteger[] shortWords = generate(() -> new AtomicInteger(0))
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
