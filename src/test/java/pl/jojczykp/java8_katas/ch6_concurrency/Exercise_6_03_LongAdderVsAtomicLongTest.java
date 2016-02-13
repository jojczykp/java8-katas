package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class Exercise_6_03_LongAdderVsAtomicLongTest {

	private static final int N_THREADS = 1000;
	private static final int N_INCREMENTS = 100_000;

	private Exercise_6_03_LongAdderVsAtomicLong testee = new Exercise_6_03_LongAdderVsAtomicLong();

	@Test
	public void shouldLongAdderBeMoreEfficientThanAtomicLong() {
		Duration atomicLongDuration = testee.getAtomicLongIncrementDuration(N_THREADS, N_INCREMENTS);
		Duration longAdderDuration = testee.getLongAdderIncrementDuration(N_THREADS, N_INCREMENTS);

		System.out.println(N_INCREMENTS + " increments in " + N_THREADS + " using AtomicLong: " + atomicLongDuration);
		System.out.println(N_INCREMENTS + " increments in " + N_THREADS + " using LongAdder: " + longAdderDuration);

		assertThat(atomicLongDuration, is(greaterThan(longAdderDuration)));
	}

}
