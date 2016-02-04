package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class Exercise_3_07_ComparatorsCompositionTest {

	private static final boolean REVERSED = true;
	private static final boolean CASE_INSENSITIVE = true;
	private static final boolean SPACE_INSENSITIVE = true;

	private static final Matcher<Integer> FIRST_LOWER = lessThan(0);
	private static final Matcher<Integer> EQUAL = equalTo(0);
	private static final Matcher<Integer> FIRST_GREATER = greaterThan(0);

	private Exercise_3_07_ComparatorsComposition testee = new Exercise_3_07_ComparatorsComposition();

	@Test
	public void shouldCompareNatural() {
		int result = testee.getComposedStringComparator(false, false, false)
				.compare("abc", "xyz");

		assertThat(result, is(FIRST_LOWER));
	}

	@Test
	public void shouldCompareReversed() {
		int result = testee.getComposedStringComparator(REVERSED, false, false)
				.compare("abc", "xyz");

		assertThat(result, is(FIRST_GREATER));
	}
	@Test

	public void shouldCompareCaseInsensitive() {
		int result = testee.getComposedStringComparator(false, CASE_INSENSITIVE, false)
				.compare("pqr", "PQR");

		assertThat(result, is(EQUAL));
	}

	@Test
	public void shouldCompareSpaceInsensitive() {
		int result = testee.getComposedStringComparator(false, false, SPACE_INSENSITIVE)
				.compare("pqr", "p q r");

		assertThat(result, is(EQUAL));
	}

	@Test
	public void shouldCompareReversedCaseAndSpaceInsensitive() {
		int result = testee.getComposedStringComparator(REVERSED, CASE_INSENSITIVE, SPACE_INSENSITIVE)
				.compare("stu", "X Y Z");

		assertThat(result, is(FIRST_GREATER));
	}

}
