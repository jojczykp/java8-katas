package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_17_ParallelRunnables.doInParallelAsync;
import static pl.jojczykp.java8_katas.test_tools.ParallelTools.obtained;

public final class Exercise_3_17_ParallelRunnablesTest {

	@Test
	public void shouldConsumeExceptionIfThrownByFirst() {
		AtomicReference<Boolean> gotException = new AtomicReference<>();

		doInParallelAsync(
				() -> { throw new RuntimeException(); },
				() -> { },
				t -> gotException.set(true));

		assertThat(obtained(gotException), is(true));
	}

	@Test
	public void shouldConsumeExceptionIfThrownBySecond()  {
		AtomicReference<Boolean> gotException = new AtomicReference<>();

		doInParallelAsync(
				() -> { },
				() -> { throw new RuntimeException(); },
				t -> gotException.set(true));

		assertThat(obtained(gotException), is(true));
	}

	@Test
	public void shouldCompleteIfNoException()  {
		AtomicReference<Boolean> firstCompleted = new AtomicReference<>();
		AtomicReference<Boolean> secondCompleted = new AtomicReference<>();
		AtomicReference<Boolean> gotException = new AtomicReference<>(false);

		doInParallelAsync(
				() -> firstCompleted.set(true),
				() -> secondCompleted.set(true),
				t -> gotException.set(true));

		assertThat(obtained(firstCompleted), is(true));
		assertThat(obtained(secondCompleted), is(true));
		assertThat(gotException.get(), is(false));
	}

}
