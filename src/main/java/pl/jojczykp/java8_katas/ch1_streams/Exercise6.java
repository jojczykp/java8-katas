package pl.jojczykp.java8_katas.ch1_streams;

public final class Exercise6 {

	private Exercise6() {}

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
