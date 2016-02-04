package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_23_MapPair.Pair;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Exercise_3_23_MapPairTest {

	private static final Integer A = 1;
	private static final Integer B = 2;

	@Test
	public void shouldMapPair() {
		Pair<Integer> pair = Pair.of(A, B);
		Function<Integer, String> f = Object::toString;

		Pair<String> mapped = pair.map(f);

		assertThat(mapped.getA(), is(equalTo(A.toString())));
		assertThat(mapped.getB(), is(equalTo(B.toString())));
	}

}
