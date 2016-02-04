package pl.jojczykp.java8_katas.ch1_lambda_expressions;

public final class Exercise_1_6_UncheckExceptionWrapper {

	private Exercise_1_6_UncheckExceptionWrapper() {}

	public static Runnable uncheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				throw new PackedCheckedException(e);
			}
		};
	}

	public interface RunnableEx {
		void run() throws Exception;
	}

	public static class PackedCheckedException extends RuntimeException {
		public PackedCheckedException(Exception cause) {
			super(cause);
		}
	}

}
