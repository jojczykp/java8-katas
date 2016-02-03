package pl.jojczykp.java8_katas.ch1_lambda_expressions;

public final class Exercise_1_7_CombineTwoLambdas {

	private Exercise_1_7_CombineTwoLambdas() {}

	public static Runnable andThen(Runnable first, Runnable second) {
		return () -> {
			first.run();
			second.run();
		};
	}

}
