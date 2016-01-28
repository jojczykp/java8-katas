package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static org.junit.Assert.assertTrue;

public class Exercise3Test {

	private static final String LONG_WORD = "LongWordLongWordLongWordLongWordLongWordLongWordLongWord";

	private Exercise3 testee = new Exercise3();

	@Test
	public void shouldSimpleOperationInParallelBeSlowerThanSequential() {
		final int size = 5_000_000;
		final List<String> words = createWordsListOf(size);

		long sequentialDuration = testee.timeOfCountingWordsSequential(words);
		long parallelDuration = testee.timeOfCountingWordsParallel(words);

		System.out.println("Counting " + size + " words sequentially: " + sequentialDuration + "ms");
		System.out.println("Counting " + size + " words in parallel: " + parallelDuration + "ms");
		if (multicoreSystem()) {
			assertTrue(parallelDuration > sequentialDuration);
		}
	}

	@Test
	public void shouldComplexOperationInParallelBeFasterThanSequential() {
		final int size = 1_000_000;
		final List<String> words = createWordsListOf(size);

		long sequentialDuration = testee.timeOfUpperCasingWordsSequential(words);
		long parallelDuration = testee.timeOfUpperCasingWordsParallel(words);

		System.out.println("UpperCasing of " + size + " words sequentially: " + sequentialDuration + "ms");
		System.out.println("UpperCasing of " + size + " words in parallel: " + parallelDuration + "ms");
		if (multicoreSystem()) {
			assertTrue(parallelDuration < sequentialDuration);
		}
	}

	private List<String> createWordsListOf(int size) {
		return rangeClosed(1, size).mapToObj(i -> LONG_WORD + i).collect(toList());
	}

	private boolean multicoreSystem() {
		return Runtime.getRuntime().availableProcessors() > 1;
	}


}
