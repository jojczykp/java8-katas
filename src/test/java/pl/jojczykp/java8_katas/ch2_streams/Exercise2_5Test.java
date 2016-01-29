package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise2_5Test {

	private Exercise2_5 testee = new Exercise2_5();

	@Test
	public void shouldGetPseudoRandomNumbers() {
		final long seed = 7;
		final List<Long> expected = asList(7L, 176504327430L, 33146457173913L, -40864473040336L, 160153793685115L);

		List<Long> pseudoRandoms = testee.getPseudoRandomLongs(seed, expected.size());

		assertThat(pseudoRandoms, is(equalTo(expected)));
	}

}
