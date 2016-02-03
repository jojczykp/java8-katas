package pl.jojczykp.java8_katas.ch1_lambda_expressions;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("PMD.MissingStaticMethodInNonInstantiatableClass")
public final class Exercise_1_9_ForEachIf {

	private Exercise_1_9_ForEachIf() {
	}

	public static class Collection2<T> extends HashSet<T> {
		public void forEachIf(Consumer<T> consumer, Predicate<T> predicate) {
			forEach(s -> {
				if (predicate.test(s)) {
					consumer.accept(s);
				}
			});
		}
	}

}
