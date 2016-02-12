package pl.jojczykp.java8_katas.ch6_concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;
import static pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper.uncheck;


public class Exercise_6_03_LongAdderVsAtomicLong {

	public Duration getAtomicLongIncrementDuration(int nThreads, int nIncrements) {
		AtomicLong atomicLong = new AtomicLong(0);
		return getExecutionDuration(nThreads, nIncrements, atomicLong::incrementAndGet, () -> {});
	}

	public Duration getLongAdderIncrementDuration(int nThreads, int nIncrements) {
		LongAdder longAdder = new LongAdder();
		return getExecutionDuration(nThreads, nIncrements, longAdder::increment, longAdder::sum);
	}

	public Duration getExecutionDuration(int nThreads, int nIncrements, Runnable action, Runnable after) {
		CountDownLatch barrier = new CountDownLatch(1);
		ExecutorService pool = newFixedThreadPool(nThreads);

		for (int t = 0 ; t < nThreads ; t++) {
			runAsync(() -> {
				awaitFor(barrier);
				for (int i = 0; i < nIncrements; i++) {
					action.run();
				}
			}, pool);
		}

		Instant beg = Instant.now();
		barrier.countDown();
		awaitFor(pool);
		after.run();
		Instant end = Instant.now();

		return Duration.between(beg, end);
	}

	private void awaitFor(CountDownLatch barrier) {
		uncheck(() -> barrier.await(1, SECONDS)).run();
	}

	private void awaitFor(ExecutorService pool) {
		pool.shutdown();
		uncheck(() -> pool.awaitTermination(1, MINUTES)).run();
	}

}
