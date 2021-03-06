package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise_2_07_CountClosesStreamTest {

	// No test for infinite stream

	@Test
	public void shouldRecognizeFiniteStream() {
		final Stream<String> stream = Stream.of("a", "b");

		boolean isFinite = Exercise_2_07_CountClosesStream.isFinite(stream);

		assertThat(isFinite, is(true));
	}

}
