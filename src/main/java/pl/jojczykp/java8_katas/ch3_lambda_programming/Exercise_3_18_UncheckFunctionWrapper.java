package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.function.Function;

public final class Exercise_3_18_UncheckFunctionWrapper {

	private Exercise_3_18_UncheckFunctionWrapper() {}

	@FunctionalInterface
	@SuppressWarnings("PMD.SignatureDeclareThrowsException")
	public interface FunctionEx<T, U> {
		U apply(T t) throws Exception;
	}

	public static <T, U> Function<T, U> uncheck(FunctionEx<T, U> f) {
		return arg -> {
			try {
				return f.apply(arg);
			} catch (Exception t) {
				throw new PackedCheckedException(t);
			}
		};
	}

	public static class PackedCheckedException extends RuntimeException {
		public PackedCheckedException(Exception cause) {
			super(cause);
		}
	}

}
