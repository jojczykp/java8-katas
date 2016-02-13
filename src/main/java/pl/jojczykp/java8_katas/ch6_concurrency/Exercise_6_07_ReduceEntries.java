package pl.jojczykp.java8_katas.ch6_concurrency;

import java.util.concurrent.ConcurrentHashMap;


public class Exercise_6_07_ReduceEntries {

	private static final long PARALLELISM_THRESHOLD = 100L;

	public String findKeyOfMax(ConcurrentHashMap<String, Long> map) {
		return map.reduceEntries(PARALLELISM_THRESHOLD,
				(e1, e2) -> (e1.getValue() > e2.getValue() ? e1 : e2))
				.getKey();
	}

}
