package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise2Test {

	private Exercise2 testee = new Exercise2();

	@Test
	public void shouldSumLengths() {
		final String[] words = {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing"};
		final int minLength = 5;
		final int limit = 4;
		final int filters = 6;
		final AtomicInteger filterCounter = new AtomicInteger(0);

		Set<String> filtered = testee.takeFirstLongWords(words, minLength, limit, filterCounter);

		assertThat(filtered, containsInAnyOrder("Lorem", "ipsum", "dolor", "consectetur"));
		assertThat(filterCounter.get(), is(equalTo(filters)));
	}

}
