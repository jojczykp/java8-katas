package pl.jojczykp.java8_katas.ch1_lambdas;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch1_lambdas.Exercise1_7.andThen;

public class Exercise1_7Test {

	@Test
	public void shouldRunBoth() {
		AtomicBoolean executedFirst = new AtomicBoolean(false);
		AtomicBoolean executedSecond = new AtomicBoolean(false);

		andThen(() -> executedFirst.set(true),
				() -> executedSecond.set(true))
				.run();

		assertThat(executedFirst.get(), is(true));
		assertThat(executedSecond.get(), is(true));
	}


}
