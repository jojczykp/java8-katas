package pl.jojczykp.java8_katas.ch1_lambdas;

public final class Exercise7 {

	private Exercise7() {}

	public static Runnable andThen(Runnable first, Runnable second) {
		return () -> {
			first.run();
			second.run();
		};
	}

}
