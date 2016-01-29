package pl.jojczykp.java8_katas.ch1_lambdas;

public final class Exercise1_6 {

	private Exercise1_6() {}

	public static Runnable uncheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				throw new PackedCheckedException(e);
			}
		};
	}

	@SuppressWarnings("PMD.SignatureDeclareThrowsException")
	public interface RunnableEx {
		void run() throws Exception;
	}

	public static class PackedCheckedException extends RuntimeException {
		public PackedCheckedException(Exception cause) {
			super(cause);
		}
	}

}
