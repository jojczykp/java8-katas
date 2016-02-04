package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.function.Function;

public final class Exercise_3_23_MapPair {

	private Exercise_3_23_MapPair() {}

	public static class Pair<T> {
		private T a;
		private T b;

		public Pair(T a, T b) {
			this.a = a;
			this.b = b;
		}

		public static <T> Pair<T> of(T a, T b) {
			return new Pair<>(a, b);
		}

		public <U> Pair<U> map(Function<T, U> f) {
			return Pair.of(f.apply(a), f.apply(b));
		}

		public T getA() {
			return a;
		}

		public T getB() {
			return b;
		}
	}

}
