package pl.jojczykp.java8_katas.ch6_concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.completedFuture;
import static java.util.concurrent.CompletableFuture.supplyAsync;


public final class Exercise_6_11_CompletableFutureWithThenCompose {

	private Exercise_6_11_CompletableFutureWithThenCompose() {
	}

	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		return supplyAsync(action).thenCompose(t ->
				until.test(t) ?
						completedFuture(t) :
						repeat(action, until));
	}

}
