package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toConcurrentMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.test_tools.StreamTools.longRangeRandomly;
import static pl.jojczykp.java8_katas.test_tools.StreamTools.throwingMerger;

public class Exercise_6_07_ReduceEntriesTest {

	private static final long MAX_VALUE = 1_000_000L;

	private Exercise_6_07_ReduceEntries testee = new Exercise_6_07_ReduceEntries();


	@Test
	public void shouldFindKeyOfMaxValue() {
		ConcurrentHashMap<String, Long> map = longRangeRandomly(0, MAX_VALUE).collect(
				toConcurrentMap(Object::toString, identity(), throwingMerger(), ConcurrentHashMap::new));

		String key = testee.findKeyOfMax(map);

		assertThat(key, is(equalTo(Long.toString(MAX_VALUE))));
	}

}
