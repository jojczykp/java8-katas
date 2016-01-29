package pl.jojczykp.java8_katas.ch2_streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Exercise2_11 {

	public void shouldPopulateConcurrently(Stream<String> stream, String[] destination) {
		AtomicInteger idx = new AtomicInteger(0);

		stream
				.parallel().unordered()
				.forEach(s -> destination[idx.getAndIncrement()] = s);
	}

}
