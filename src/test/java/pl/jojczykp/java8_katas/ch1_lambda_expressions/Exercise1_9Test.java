package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import org.junit.Test;
import pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise1_9.Collection2;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.internal.util.collections.Sets.newSet;

public class Exercise1_9Test {

	private Collection2<String> testee = new Exercise1_9.Collection2<>();

	@Test
	public void shouldApplyActionForFilteredElementsOnly() {
		testee.addAll(newSet("aCar", "car", "aHouse", "house"));
		Set<String> output = newSet();

		testee.forEachIf(output::add, s -> s.startsWith("a"));

		assertThat(output, is(equalTo(newSet("aCar", "aHouse"))));
	}

}
