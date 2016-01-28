package pl.jojczykp.java8_katas.ch1_lambdas;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("PMD.MissingStaticMethodInNonInstantiatableClass")
public final class Exercise9 {

	private Exercise9() {
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
