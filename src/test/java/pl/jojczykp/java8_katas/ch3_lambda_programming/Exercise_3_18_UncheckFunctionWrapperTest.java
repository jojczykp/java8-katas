package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Test;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_18_UncheckFunctionWrapper.PackedCheckedException;

import java.util.function.Function;

import static pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_18_UncheckFunctionWrapper.uncheck;

public class Exercise_3_18_UncheckFunctionWrapperTest {

	@Test(expected = PackedCheckedException.class)
	public void shouldRepackCheckedExceptionToUnchecked() {
		Function<Boolean, Boolean> f = uncheck(p -> {
			throw new SomeCheckedException("OOoopss...");
		});

		f.apply(true);
	}

	@Test
	public void shouldProcessIfNoException() {
		Function<Boolean, Boolean> f = uncheck(p -> true);

		f.apply(false);
	}

	private class SomeCheckedException extends Exception {
		SomeCheckedException(String message) {
			super(message);
		}
	}

}
