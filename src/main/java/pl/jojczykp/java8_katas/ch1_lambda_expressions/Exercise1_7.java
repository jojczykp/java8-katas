package pl.jojczykp.java8_katas.ch1_lambda_expressions;

public final class Exercise1_7 {

	private Exercise1_7() {}

	public static Runnable andThen(Runnable first, Runnable second) {
		return () -> {
			first.run();
			second.run();
		};
	}

}
