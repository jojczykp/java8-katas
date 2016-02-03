package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class Exercise_2_12_WordCounterTest {

	private Exercise_2_12_WordCounterWithArray testee = new Exercise_2_12_WordCounterWithArray();

	@Test
	public void shouldCountShortWordsUsingArray() {
		String[] source = {"abc", "b", "ac", "asd_fgh_jkl", "xyz", "", "q", "", "stu", "qwerty"};

		List<Integer> shortWordsCounters = testee.countShortWordsUsingArray(Stream.of(source), 3);

		assertThat(shortWordsCounters, contains(2, 2, 1, 3));
	}

}
