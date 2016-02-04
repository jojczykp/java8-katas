package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class Exercise_3_20_MapListTransformingWithFunctionTest {

	@Test
	public void shouldMapListTranformingWithFunction() {
		List<Integer> list = asList(1, 2, 3);

		List<String> result = Exercise_3_20_MapListTransformingWithFunction.map(list, Object::toString);

		assertThat(result, contains("1", "2", "3"));
	}

}
