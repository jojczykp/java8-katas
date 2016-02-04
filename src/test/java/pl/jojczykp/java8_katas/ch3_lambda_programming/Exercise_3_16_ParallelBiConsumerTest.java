package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_16_ParallelBiConsumer.doInOrderAsync;
import static pl.jojczykp.java8_katas.tools.ParallelTools.obtained;

public class Exercise_3_16_ParallelBiConsumerTest {

	@Test
	public void shouldReturnResultOnCorrectCalculation() {
		final int counter = 6;
		final int denominator = 2;

		AtomicReference<Integer> value = new AtomicReference<>();
		AtomicReference<Exception> exception = new AtomicReference<>();

		doInOrderAsync(
				() -> counter / denominator,
				(v, t) -> {
					value.set(v);
					exception.set(t);
				});

		assertThat(obtained(value), is(counter / denominator));
		assertThat(exception.get(), is(nullValue()));
	}

	@Test
	public void shouldThrowExceptionOnArithmeticError()  {
		final int counter = 7;
		final int denominator = 0;

		AtomicReference<Integer> value = new AtomicReference<>();
		AtomicReference<Exception> exception = new AtomicReference<>();

		doInOrderAsync(
				() -> counter / denominator,
				(v, t) -> {
					value.set(v);
					exception.set(t);
				});

		assertThat(obtained(exception), is(instanceOf(ArithmeticException.class)));
		assertThat(value.get(), is(nullValue()));
	}

}
