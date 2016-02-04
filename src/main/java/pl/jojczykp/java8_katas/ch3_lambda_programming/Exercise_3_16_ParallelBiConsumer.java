package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public final class Exercise_3_16_ParallelBiConsumer {

	private Exercise_3_16_ParallelBiConsumer() {
	}

	public static <T> void doInOrderAsync(Supplier<T> supplier, BiConsumer<T, Throwable> consumer) {
		Thread t = new Thread() {
			public void run() {
				try {
					T result = supplier.get();
					consumer.accept(result, null);
				} catch (Throwable t) {
					consumer.accept(null, t);
				}
			}
		};
		t.start();
	}

}
