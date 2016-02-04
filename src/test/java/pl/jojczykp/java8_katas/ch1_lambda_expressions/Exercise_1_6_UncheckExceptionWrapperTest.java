package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import org.junit.Test;
import pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper.PackedCheckedException;

import static pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper.uncheck;

public class Exercise_1_6_UncheckExceptionWrapperTest {

	@Test(expected = PackedCheckedException.class)
	public void shouldRepackCheckedExceptionToUnchecked() {
		uncheck(() -> {
				throw new SomeCheckedException("Ooops!");
		}).run();
	}

	@Test
	public void shouldProcessIfNoException() {
		uncheck(() -> {
			/* Some code that does not throw exception */
		}).run();
	}

	private class SomeCheckedException extends Exception {
		SomeCheckedException(String message) {
			super(message);
		}
	}

}
