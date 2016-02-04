package pl.jojczykp.java8_katas.ch2_streams;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Exercise_2_05_CreateAndReadUnlimitedStream {

	private static final long A = 25214903917L;
	private static final long C = 11L;
	private static final long M = (long) Math.pow(2, 48);

	public List<Long> getPseudoRandomLongs(long seed, int count) {
		return Stream.iterate(seed, x -> (A * x + C) % M)
				.limit(count)
				.collect(toList());
	}

}
