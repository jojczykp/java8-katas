package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Set;

import static pl.jojczykp.java8_katas.ch6_concurrency.Exercise_6_05_ConcurrentHashMapWithMergeTest.getRoot;
import static pl.jojczykp.java8_katas.ch6_concurrency.Exercise_6_05_ConcurrentHashMapWithMergeTest
																			.assertThatWordsMappedToFiles;

public class Exercise_6_06_ConcurrentHashMapWithComputeIfAbsentTest {

	private Exercise_6_06_ConcurrentHashMapWithComputeIfAbsent testee =
							new Exercise_6_06_ConcurrentHashMapWithComputeIfAbsent();

	@Test
	public void shouldMapWordsToFileSets() {
		File root = getRoot();

		Map<String, Set<File>> result = testee.mapWordsToFileSetsWithComputeIfAbsent(root);

		assertThatWordsMappedToFiles(root, result);
	}

}
