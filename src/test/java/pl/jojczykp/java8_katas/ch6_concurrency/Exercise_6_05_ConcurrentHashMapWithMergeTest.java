package pl.jojczykp.java8_katas.ch6_concurrency;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Exercise_6_05_ConcurrentHashMapWithMergeTest {

	private Exercise_6_05_ConcurrentHashMapWithMerge testee = new Exercise_6_05_ConcurrentHashMapWithMerge();

	@Test
	public void shouldMapWordsToFileSets() {
		File root = getRoot();

		Map<String, Set<File>> result = testee.mapWordsToFileSetsWithMerge(root);

		assertThatWordsMappedToFiles(root, result);
	}

	static File getRoot() {
		try {
			return new File(Exercise_6_05_ConcurrentHashMapWithMergeTest.class
							.getClassLoader().getResource("ch6_concurrency").toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	static void assertThatWordsMappedToFiles(File root, Map<String, Set<File>> result) {
		assertThat(result.keySet(), containsInAnyOrder("Alice", "has", "a", "cat", "1", "2", "3"));
		assertThat(result.get("Alice"), occursInAllFiles(root));
		assertThat(result.get("has"), occursInAllFiles(root));
		assertThat(result.get("a"), occursInAllFiles(root));
		assertThat(result.get("cat"), occursInAllFiles(root));
		assertThat(result.get("1"), occursOnlyInFile(root, "WordsFile1.txt"));
		assertThat(result.get("2"), occursOnlyInFile(root, "WordsFile2.txt"));
		assertThat(result.get("3"), occursOnlyInFile(root, "WordsFile3.txt"));
	}

	private static Matcher<Iterable<? extends File>> occursInAllFiles(File root) {
		return containsInAnyOrder(
				new File(root, "WordsFile1.txt"),
				new File(root, "WordsFile2.txt"),
				new File(root, "WordsFile3.txt")
		);
	}

	private static Matcher<? super Set<File>> occursOnlyInFile(File root, String name) {
		return contains(new File(root, name));
	}

}
