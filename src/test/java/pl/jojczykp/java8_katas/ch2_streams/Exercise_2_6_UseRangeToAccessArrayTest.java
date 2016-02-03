package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class Exercise_2_6_UseRangeToAccessArrayTest {

	@Test
	public void shouldGenerateStreamOfCharsFromString() {
		final String string = "test";

		Stream<Character> stream = Exercise_2_6_UseRangeToAccessArray.characterStream(string);

		assertThat(stream.collect(toList()), contains('t', 'e', 's', 't'));
	}

}
