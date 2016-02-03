package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_9_YieldingComparator.Person;

public class Exercise_3_8_YieldingComparatorTest {

	private static final Matcher<Integer> FIRST_LOWER = lessThan(0);
	private static final Matcher<Integer> EQUAL = equalTo(0);
	private static final Matcher<Integer> FIRST_GREATER = greaterThan(0);

	private Exercise_3_9_YieldingComparator testee = new Exercise_3_9_YieldingComparator();

	@Test
	public void shouldFindDifferenceOnFirst() {
		final Person person1 = new Person("Andrzej", "Marian", "Kowalski");
		final Person person2 = new Person("Tomasz", "Marian", "Kowalski");

		int result = testee.lexicographicComparator("firstname", "middlename", "lastname")
				.compare(person1, person2);

		assertThat(result, is(FIRST_LOWER));
	}

	@Test
	public void shouldFindDifferenceOnNonFirst() {
		final Person person1 = new Person("Janusz", "Marcin", "Nowak");
		final Person person2 = new Person("Janusz", "Artur", "Nowak");

		int result = testee.lexicographicComparator("firstname", "middlename", "lastname")
				.compare(person1, person2);

		assertThat(result, is(FIRST_GREATER));
	}

	@Test
	public void shouldFindNoDifferenceOnEqual() {
		final Person person1 = new Person("Zbigniew", "Piotr", "Sochacki");
		final Person person2 = new Person("Zbigniew", "Piotr", "Sochacki");

		int result = testee.lexicographicComparator("firstname", "middlename", "lastname")
				.compare(person1, person2);

		assertThat(result, is(EQUAL));
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfFieldDoesNotExist() {
		final Person person = new Person("Edward", "Stefan", "Burczymucha");

		testee.lexicographicComparator("nonExistingField")
				.compare(person, person);
	}

}
