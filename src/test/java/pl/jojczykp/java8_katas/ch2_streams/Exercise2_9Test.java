package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise2_9Test {

	private Exercise2_9<String> testee = new Exercise2_9<>();

	private static final List<String> LIST_1 = asList("a", "b", "c");
	private static final List<String> LIST_2 = asList("d", "e", "f");
	private static final String[] EXPECTED_RESULT = {"a", "b", "c", "d", "e", "f"};

	@Test
	public void shouldSeriallyJoinListsToNewInstance() {
		Stream<List<String>> listStream = Stream.of(LIST_1, LIST_2);

		List<String> joined = testee.joinSeriallyListsToNewInstance(listStream);

		assertThat(joined, contains(EXPECTED_RESULT));
	}

	@Test
	public void shouldJoinListsToNewInstanceWithCombining() {
		Stream<List<String>> listStream = Stream.of(LIST_1, LIST_2).parallel();

		List<String> joined = testee.joinInParallelListsToNewInstanceWithCombining(listStream);

		assertThat(joined, contains(EXPECTED_RESULT));
	}

	@Test
	public void shouldJoinListsMutatingFirstOptionally() {
		Stream<List<String>> listStream = Stream.of(cloneList(LIST_1), LIST_2);

		Optional<List<String>> joined = testee.joinSeriallyListsMutatingFirstOptionally(listStream);

		assertThat(joined.isPresent(), is(true));
		assertThat(joined.get(), contains(EXPECTED_RESULT));
	}

	@Test
	public void shouldBeNotPresent() {
		Stream<List<String>> listStream = Stream.empty();

		Optional<List<String>> joined = testee.joinSeriallyListsMutatingFirstOptionally(listStream);

		assertThat(joined.isPresent(), is(false));
	}

	private <T> List<T> cloneList(List<T> list) {
		List<T> result = new ArrayList<>();
		result.addAll(list);

		return result;
	}

}
