package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;
import pl.jojczykp.java8_katas.tools.BarrieredExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Collections.shuffle;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Exercise_6_01_AtomicReferenceTest {

	private static final int STRINGS_CNT = 1000;
	private static final int THREADS_CNT = 20;

	private StringsGenerator generator = new StringsGenerator(STRINGS_CNT);
	private BarrieredExecutor executor = new BarrieredExecutor(THREADS_CNT);
	private AtomicReference<String> currentLongest = new AtomicReference<>("");


	@Test
	public void shouldTrackLongestWord() {
		for (int i = 0; i < THREADS_CNT; i++) {
			executor.addTask(() -> {
				for (String string : generator.getShuffledCopy()) {
					currentLongest.getAndUpdate(s -> longerOf(s, string));
				}
			});
		}

		executor.execute();

		assertThat(currentLongest.get(), is(generator.getLongest()));
	}

	private static String longerOf(String s1, String s2) {
		return s1.length() >= s2.length() ? s1 : s2;
	}


	private static class StringsGenerator {
		private List<String> strings;
		private String longest;

		StringsGenerator(int stringsCnt) {
			strings = unmodifiableList(range(0, stringsCnt).mapToObj(this::aStringOfLength).collect(toList()));
			longest = strings.get(stringsCnt - 1);
		}

		public String getLongest() {
			return longest;
		}

		public List<String> getShuffledCopy() {
			List<String> copy = new ArrayList<>(strings);
			shuffle(copy);
			return copy;
		}

		private String aStringOfLength(int length) {
			return range(0, length).mapToObj(i -> "x").reduce("", (acc, s) -> acc += s);
		}

	}

}
