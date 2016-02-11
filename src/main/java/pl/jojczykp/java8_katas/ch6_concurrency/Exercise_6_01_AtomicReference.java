package pl.jojczykp.java8_katas.ch6_concurrency;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.Executors.newCachedThreadPool;
import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;
import static pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper.uncheck;


public class Exercise_6_01_AtomicReference {

	private CountDownLatch barrier = new CountDownLatch(1);
	private ExecutorService pool = newCachedThreadPool();
	private AtomicReference<String> currentLongest = new AtomicReference<>("");

	public void addThreadWith(List<String> strings) {
		runAsync(() -> {
			awaitFor(barrier);
			for (String string : strings) {
				currentLongest.getAndUpdate(s -> longerOf(s, string));
			}
		}, pool);
	}

	public void executeLooking() throws InterruptedException {
		barrier.countDown();
		pool.shutdown();
		pool.awaitTermination(1, MINUTES);
	}

	public String getLongest() {
		return currentLongest.get();
	}

	private void awaitFor(CountDownLatch barrier) {
		uncheck(() -> barrier.await(1, SECONDS)).run();
	}

	private static String longerOf(String s1, String s2) {
		return s1.length() >= s2.length() ? s1 : s2;
	}

}
