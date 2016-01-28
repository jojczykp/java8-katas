package pl.jojczykp.java8_katas.ch2_streams;

import java.util.Collection;
import java.util.function.Supplier;

public class Exercise3 {

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
		long beg = System.currentTimeMillis();
		block.get();
		long end = System.currentTimeMillis();

		return (end - beg);
	}
}
