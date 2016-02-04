package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.function.Consumer;

public final class Exercise_3_17_ParallelRunnables {

	private Exercise_3_17_ParallelRunnables() {
	}

	public static void doInParallelAsync(Runnable first, Runnable second,
										Consumer<Throwable> consumer) {
		Thread t = new Thread() {
			public void run() {
				try {
					first.run();
					second.run();
				} catch (Throwable t) {
					consumer.accept(t);
				}
			}
		};
		t.start();
	}

}
