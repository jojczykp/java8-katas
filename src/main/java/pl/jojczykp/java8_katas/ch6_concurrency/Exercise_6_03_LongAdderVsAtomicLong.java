package pl.jojczykp.java8_katas.ch6_concurrency;

import pl.jojczykp.java8_katas.tools.BarrieredExecutor;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;


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
		BarrieredExecutor executor = new BarrieredExecutor(nThreads);

		for (int t = 0 ; t < nThreads ; t++) {
			executor.addTask(() -> {
				for (int i = 0; i < nIncrements; i++) {
					action.run();
				}
			});
		}

		Instant beg = Instant.now();
		executor.execute();
		after.run();
		Instant end = Instant.now();

		return Duration.between(beg, end);
	}

}
