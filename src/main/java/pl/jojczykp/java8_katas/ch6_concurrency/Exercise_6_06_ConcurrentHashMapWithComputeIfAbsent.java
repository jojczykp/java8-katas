package pl.jojczykp.java8_katas.ch6_concurrency;

import pl.jojczykp.java8_katas.tools.BarrieredExecutor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;


public class Exercise_6_06_ConcurrentHashMapWithComputeIfAbsent {

	private static final String WORDS_SEPARATOR = "\\W+";
	private static final int N_THREADS = 10;

	public Map<String, Set<File>> mapWordsToFileSetsWithComputeIfAbsent(File root) {
		Map<String, Set<File>> result = new ConcurrentHashMap<>();
		BarrieredExecutor executor = new BarrieredExecutor(N_THREADS);

		Stream.of(root.listFiles()).forEach(file ->
				executor.addTask(() ->
						Files.lines(Paths.get(file.toURI()))
								.flatMap(line -> Stream.of(line.split(WORDS_SEPARATOR)))
								.forEach(word -> result.computeIfAbsent(word, w ->
															ConcurrentHashMap.newKeySet()).add(file)))
						);

		executor.execute();

		return result;
	}

}
