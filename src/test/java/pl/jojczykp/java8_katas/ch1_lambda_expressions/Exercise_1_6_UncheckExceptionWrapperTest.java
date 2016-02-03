package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import org.junit.Test;

import static pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper.uncheck;

public class Exercise_1_6_UncheckExceptionWrapperTest {

	@Test
	public void shouldRepackCheckedExceptionToUnchecked() {
		new Thread(uncheck(() ->
				codeThrowingCheckedExceptionConditionally(true)
		)).start();
	}

	@Test
	public void shouldProcessIfNoException() {
		new Thread(uncheck(() ->
				codeThrowingCheckedExceptionConditionally(false)
		)).start();
	}

	private void codeThrowingCheckedExceptionConditionally(boolean shouldThrow) throws SomeCheckedException {
		if (shouldThrow) {
			throw new SomeCheckedException("Ooops!");
		}
	}

	private class SomeCheckedException extends Exception {
		SomeCheckedException(String message) {
			super(message);
		}
	}

}
