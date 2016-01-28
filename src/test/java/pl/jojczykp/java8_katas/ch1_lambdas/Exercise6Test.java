package pl.jojczykp.java8_katas.ch1_lambdas;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static java.lang.reflect.Modifier.isPrivate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch1_lambdas.Exercise6.uncheck;

public class Exercise6Test {

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

	@Test
	public void shouldHavePrivateSoleConstructor() throws Exception {
		Constructor<Exercise6> constructor = Exercise6.class.getDeclaredConstructor();
		assertThat(isPrivate(constructor.getModifiers()), is(true));
		constructor.setAccessible(true);
		constructor.newInstance();
	}
}
