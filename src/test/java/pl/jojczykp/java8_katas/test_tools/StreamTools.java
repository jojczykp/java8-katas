package pl.jojczykp.java8_katas.test_tools;

import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class StreamTools {

	private StreamTools() {
	}

	public static Stream<Long> longRangeRandomly(long startInclusively, long endExclusively) {
		List<Long> longs = LongStream.rangeClosed(startInclusively, endExclusively)
				.boxed().collect(toList());
		Collections.shuffle(longs);

		return longs.stream();
	}

	public static <T> BinaryOperator<T> throwingMerger() {
		return (u, v) -> {
			throw new IllegalStateException(String.format("Duplicate key %s", u));
		};
	}

}
