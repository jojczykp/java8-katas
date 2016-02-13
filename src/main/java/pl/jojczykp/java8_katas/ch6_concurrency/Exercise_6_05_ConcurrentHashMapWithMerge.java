package pl.jojczykp.java8_katas.ch6_concurrency;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

import static java.util.Collections.singleton;
import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.TimeUnit.MINUTES;
import static pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper.uncheck;


public class Exercise_6_05_ConcurrentHashMapWithMerge {

	private static final String WORDS_SEPARATOR = "\\W+";
	private static final int N_THREADS = 10;


	public Map<String, Set<File>> mapWordsToFileSets(File root) {
		Map<String, Set<File>> result = new ConcurrentHashMap<>();
		ExecutorService pool = newFixedThreadPool(N_THREADS);

		Stream.of(root.listFiles()).forEach(file ->
				runAsync(uncheck(() ->
						Files.lines(Paths.get(file.toURI()))
								.flatMap(line -> Stream.of(line.split(WORDS_SEPARATOR)))
								.forEach(word -> result.merge(word, singleton(file), this::union))),
						pool));

		awaitFor(pool);

		return result;
	}

	private Set<File> union(Set<File> files1, Set<File> files2) {
		Set<File> res = new HashSet<>(files1);
		res.addAll(files2);

		return res;
	}

	private static void awaitFor(ExecutorService pool) {
		pool.shutdown();
		uncheck(() -> pool.awaitTermination(1, MINUTES)).run();
	}

}
