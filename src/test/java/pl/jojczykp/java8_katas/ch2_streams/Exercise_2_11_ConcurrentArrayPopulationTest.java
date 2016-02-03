package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class Exercise_2_11_ConcurrentArrayPopulationTest {

	private Exercise_2_11_ConcurrentArrayPopulation testee = new Exercise_2_11_ConcurrentArrayPopulation();

	@Test
	public void shouldPopulateSingleArrayListConcurrently() {
		String[] source = {"a", "b", "c", "d", "e"};
		String[] destination = new String[source.length];

		testee.populateConcurrently(Stream.of(source), destination);

		assertThat(asList(destination), containsInAnyOrder(source));
	}

}
