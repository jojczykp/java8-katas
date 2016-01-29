package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class Exercise2_12Test {

	private Exercise2_12 testee = new Exercise2_12();

	@Test
	public void shouldCountShortWords() {
		String[] source = {"abc", "b", "ac", "asd_fgh_jkl", "xyz", "", "q", "", "stu", "qwerty"};

		List<Integer> shortWordsCounters = testee.countShortWords(Stream.of(source), 3);

		assertThat(shortWordsCounters, contains(2, 2, 1, 3));
	}

}
