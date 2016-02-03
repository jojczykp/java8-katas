package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class Exercise_2_8_ZipTest {

	@Test
	public void shouldAlternateWithFirstShorter() {
		final Stream<String> first = Stream.of("a", "b");
		final Stream<String> second = Stream.of("p", "q", "r", "s");

		Stream<String> zipped = Exercise_2_8_Zip.zip(first, second);

		assertThat(zipped.collect(toList()), contains("a", "p", "b", "q"));
	}

	@Test
	public void shouldAlternateWithSecondShorter() {
		final Stream<String> first = Stream.of("a", "b", "c", "d");
		final Stream<String> second = Stream.of("p", "q");

		Stream<String> zipped = Exercise_2_8_Zip.zip(first, second);

		assertThat(zipped.collect(toList()), contains("a", "p", "b", "q", "c"));
	}

}
