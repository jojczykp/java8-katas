package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

import static java.util.logging.Level.FINEST;
import static java.util.logging.Level.OFF;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Exercise_3_1_LoggingTest {

	private Exercise_3_1_Logging testee = new Exercise_3_1_Logging();

	@Test
	public void shouldLogWithGivenLevelIfConditionIsTrue() {
		final AtomicReference<Level> levelPassedToAction = new AtomicReference<>(OFF);

		testee.logIf(FINEST, () -> true, levelPassedToAction::set);

		assertThat(levelPassedToAction.get(), is(FINEST));
	}

	@Test
	public void shouldNotLogIfPredicateFalse() {
		final AtomicReference<Level> levelPassedToAction = new AtomicReference<>(OFF);

		testee.logIf(FINEST, () -> false, levelPassedToAction::set);

		assertThat(levelPassedToAction.get(), is(OFF));
	}

}
