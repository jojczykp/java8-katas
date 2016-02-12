package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import java.util.concurrent.atomic.LongAccumulator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_6_04_LongAccumulatorTest {

	private static final long MAX = 1000;

	@Test
	public void shouldComputeMaximumUsingLongAccumulator() {
		LongAccumulator accumulator = new LongAccumulator(Long::max, 0L);

		accumulator.accumulate(MAX - 1);
		accumulator.accumulate(MAX);
		accumulator.accumulate(MAX - 2);

		assertThat(accumulator.get(), is(equalTo(MAX)));
	}

}
