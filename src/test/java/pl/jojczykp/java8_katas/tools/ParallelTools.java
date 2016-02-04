package pl.jojczykp.java8_katas.tools;

import java.util.concurrent.atomic.AtomicReference;

public final class ParallelTools {

	private static final int MAX_OBTAIN_ATTEMPTS = 10;
	private static final int OBTAINING_TIMEOUT = 100;

	private ParallelTools() {
	}

	public static <T> T obtained(AtomicReference<T> ref) {
		try {
			int count = 0;
			T result = ref.get();
			while (result == null && count++ < MAX_OBTAIN_ATTEMPTS - 1) {
				Thread.sleep(OBTAINING_TIMEOUT);
				result = ref.get();
			}
			return result;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
