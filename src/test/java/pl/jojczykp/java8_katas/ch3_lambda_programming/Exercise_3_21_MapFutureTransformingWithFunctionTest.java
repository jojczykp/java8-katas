package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.concurrent.Executors.newSingleThreadExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_21_MapFutureTransformingWithFunction.map;

public class Exercise_3_21_MapFutureTransformingWithFunctionTest {

	private static final Integer SAMPLE_VALUE = 2;

	@Test
	public void shouldMapFutureTranformingWithFunctionUnparametrizedGet() throws Exception {
		Future<Integer> future = evaluateTask(() -> SAMPLE_VALUE);

		String result = map(future, Object::toString).get();

		assertThat(result, is(equalTo(SAMPLE_VALUE.toString())));
	}

	@Test
	public void shouldMapFutureTranformingWithFunctionParametrizedGet() throws Exception {
		Future<Integer> future = evaluateTask(() -> SAMPLE_VALUE);

		String result = map(future, Object::toString).get(1, SECONDS);

		assertThat(result, is(equalTo(SAMPLE_VALUE.toString())));
	}

	private Future<Integer> evaluateTask(Callable<Integer> task) throws InterruptedException {
		ExecutorService executorService = newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(task);
		executorService.shutdown();
		executorService.awaitTermination(1, SECONDS);

		return future;
	}

	@Test
	public void shouldReturnedFutureDelegateNonGetMethods() {
		final AtomicBoolean invokedCancel = new AtomicBoolean();
		final AtomicBoolean invokedIsCancelled = new AtomicBoolean();
		final AtomicBoolean invokedIsDone = new AtomicBoolean();
		final Future<Integer> delegateFuture = new Future<Integer>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				invokedCancel.set(true);
				return false;
			}

			@Override
			public boolean isCancelled() {
				invokedIsCancelled.set(true);
				return false;
			}

			@Override
			public boolean isDone() {
				invokedIsDone.set(true);
				return false;
			}

			@Override
			public Integer get() throws InterruptedException, ExecutionException {
				return null;
			}

			@Override
			public Integer get(long timeout, TimeUnit unit) throws InterruptedException,
																ExecutionException, TimeoutException {
				return null;
			}
		};
		Future<String> mappedFuture = map(delegateFuture, Object::toString);

		mappedFuture.cancel(true);
		mappedFuture.isCancelled();
		mappedFuture.isDone();

		assertThat(invokedCancel.get(), is(true));
		assertThat(invokedIsCancelled.get(), is(true));
		assertThat(invokedIsDone.get(), is(true));
	}

}
