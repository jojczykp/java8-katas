package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class Exercise2_11Test {

	private Exercise2_11 testee = new Exercise2_11();

	@Test
	public void shouldPopulateSingleArrayListConcurrently() {
		String[] source = {"a", "b", "c", "d", "e"};
		String[] destination = new String[source.length];

		testee.populateConcurrently(Stream.of(source), destination);

		assertThat(asList(destination), containsInAnyOrder(source));
	}

}
