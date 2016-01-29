package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise2_13Test {

	private Exercise2_13 testee = new Exercise2_13();

	@Test
	public void shouldCountShortWordsUsingArray() {
		String[] source = {"abc", "b", "ac", "asd_fgh_jkl", "xyz", "", "q", "", "stu", "qwerty"};

		Map<Integer, Long> shortWordsCounters = testee.countShortWordsUsingCollectors(Stream.of(source), 3);

		assertThat(shortWordsCounters.get(0), is(2L));
		assertThat(shortWordsCounters.get(1), is(2L));
		assertThat(shortWordsCounters.get(2), is(1L));
		assertThat(shortWordsCounters.get(3), is(3L));
	}

}
