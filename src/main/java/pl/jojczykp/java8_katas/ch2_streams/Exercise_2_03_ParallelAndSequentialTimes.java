package pl.jojczykp.java8_katas.ch2_streams;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.function.Supplier;

import static java.time.Instant.now;

public class Exercise_2_03_ParallelAndSequentialTimes {

	public long timeOfCountingWordsSequential(Collection<String> collection) {
		return durationOf(() -> collection
						.stream()
						.count());
	}

	public long timeOfCountingWordsParallel(Collection<String> collection) {
		return durationOf(() -> collection
						.parallelStream()
						.count());
	}

	public long timeOfUpperCasingWordsSequential(Collection<String> collection) {
		return durationOf(() -> collection
						.stream()
						.map(String::toUpperCase)
						.count());
	}

	public long timeOfUpperCasingWordsParallel(Collection<String> collection) {
		return durationOf(() -> collection
						.parallelStream()
						.map(String::toUpperCase)
						.count());
	}

	private <T> long durationOf(Supplier<T> block) {
		Instant beg = now();
		block.get();
		Instant end = now();

		return Duration.between(beg, end).toMillis();
	}

}
