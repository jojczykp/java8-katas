package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_7_CombineTwoLambdas.andThen;

public class Exercise_1_7_CombineTwoLambdasTest {

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
