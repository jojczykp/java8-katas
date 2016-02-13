package pl.jojczykp.java8_katas.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper.uncheck;

public class BarrieredExecutor {

	private CountDownLatch barrier;
	private ExecutorService pool;

	public BarrieredExecutor(int nThreads) {
		pool = newFixedThreadPool(nThreads);
		barrier = new CountDownLatch(1);
	}

	public void addTask(RunnableEx task) {
		runAsync(uncheck(() -> {
			barrier.await(1, TimeUnit.MINUTES);
			task.run();
		}), pool);

	}

	public void execute() {
		barrier.countDown();
		pool.shutdown();
		uncheck(() -> pool.awaitTermination(1, TimeUnit.MINUTES)).run();
	}

	@FunctionalInterface
	@SuppressWarnings("PMD.SignatureDeclareThrowsException")
	public interface RunnableEx {
		void run() throws Exception;
	}
}
