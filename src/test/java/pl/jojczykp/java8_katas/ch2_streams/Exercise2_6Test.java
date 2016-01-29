package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class Exercise2_6Test {

	private Exercise2_6 testee = new Exercise2_6();

	@Test
	public void shouldGenerateStreamOfCharsFromString() {
		final String string = "test";

		Stream<Character> stream = testee.characterStream(string);

		assertThat(stream.collect(toList()), contains('t', 'e', 's', 't'));
	}

}
