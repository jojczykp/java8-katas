package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_16_ParallelRunnables.doInOrderAsync;

public class Exercise_3_16_ParallelRunnablesTest {

	private static final int MAX_OBTAIN_ATTEMPTS = 10;
	private static final int OBTAINING_TIMEOUT = 100;

	@Test
	public void shouldReturnResultOnCorrectCalculation() {
		final int counter = 6;
		final int denominator = 2;

		AtomicReference<Integer> value = new AtomicReference<>();
		AtomicReference<Throwable> throwable = new AtomicReference<>();

		doInOrderAsync(
				() -> counter / denominator,
				(v, t) -> {
					value.set(v);
					throwable.set(t);
				});

		assertThat(obtained(value), is(counter / denominator));
		assertThat(throwable.get(), is(nullValue()));
	}

	@Test
	public void shouldThrowExceptionOnArithmeticError()  {
		final int counter = 7;
		final int denominator = 0;

		AtomicReference<Integer> value = new AtomicReference<>();
		AtomicReference<Throwable> throwable = new AtomicReference<>();

		doInOrderAsync(
				() -> counter / denominator,
				(v, t) -> {
					value.set(v);
					throwable.set(t);
				});

		assertThat(obtained(throwable), is(instanceOf(ArithmeticException.class)));
		assertThat(value.get(), is(nullValue()));
	}

	private <T> T obtained(AtomicReference<T> ref) {
		try {
			int count = 0;
			T result = ref.get();
			while (result == null && count++ < MAX_OBTAIN_ATTEMPTS - 1) {
				Thread.sleep(OBTAINING_TIMEOUT);
				result = ref.get();
			}
			return result;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
