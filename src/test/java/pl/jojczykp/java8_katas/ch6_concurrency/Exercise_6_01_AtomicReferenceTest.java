package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;

public class Exercise_6_01_AtomicReferenceTest {

	private static final int STRINGS_CNT = 1000;
	private static final int THREADS_CNT = 20;

	private StringsGenerator generator = new StringsGenerator(STRINGS_CNT);
	private Exercise_6_01_AtomicReference testee = new Exercise_6_01_AtomicReference();


	@Test
	public void shouldTrackLongestWord() throws InterruptedException {
		for (int i = 0; i < THREADS_CNT; i++) {
			testee.addThreadWith(generator.getShuffledCopy());
		}

		testee.executeLooking();

		assertThat(testee.getLongest(), is(sameInstance(generator.getLongest())));
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
