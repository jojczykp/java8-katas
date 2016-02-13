package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;

import static pl.jojczykp.java8_katas.test_tools.DurationTools.durationOf;
import static pl.jojczykp.java8_katas.test_tools.StreamTools.longRangeRandomly;

public class Exercise_6_08_ArraySortSerialVsParallelTest {

	private static final long SIZE = 20_000;

	@Test
	public void showSerialAndParallelSortDuration() {
		long[] array = longRangeRandomly(0, SIZE).mapToLong(Long::longValue).toArray();

		Duration serialDuration = durationOf(() -> Arrays.sort(array));
		Duration parallelDuration = durationOf(() -> Arrays.parallelSort(array));

		System.out.println("Size: " + SIZE);
		System.out.println("Serial sort:   " + serialDuration);
		System.out.println("Parallel sort: " + parallelDuration);
	}

}
