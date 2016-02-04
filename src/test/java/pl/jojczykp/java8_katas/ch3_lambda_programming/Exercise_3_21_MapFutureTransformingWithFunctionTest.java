package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

import java.util.concurrent.Future;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.concurrent.ForkJoinPool.commonPool;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_21_MapFutureTransformingWithFunction.map;

public class Exercise_3_21_MapFutureTransformingWithFunctionTest {

	private static final Integer SAMPLE_VALUE = 2;

	@Test
	public void shouldMapFutureTranformingWithFunctionUnparametrizedGet() throws Exception {
		Supplier<Integer> task = () -> SAMPLE_VALUE;
		Future<Integer> future = supplyAsync(task, commonPool());

		String result = map(future, Object::toString).get();

		assertThat(result, is(equalTo(SAMPLE_VALUE.toString())));
	}

	@Test
	public void shouldMapFutureTranformingWithFunctionParametrizedGet() throws Exception {
		Supplier<Integer> task = () -> SAMPLE_VALUE;
		Future<Integer> future = supplyAsync(task, commonPool());

		String result = map(future, Object::toString).get(1, SECONDS);

		assertThat(result, is(equalTo(SAMPLE_VALUE.toString())));
	}

}
