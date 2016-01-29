package pl.jojczykp.java8_katas.ch1_lambdas;

import org.junit.Test;

import static pl.jojczykp.java8_katas.ch1_lambdas.Exercise1_6.uncheck;

public class Exercise1_6Test {

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
