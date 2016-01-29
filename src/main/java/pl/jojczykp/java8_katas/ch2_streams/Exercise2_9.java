package pl.jojczykp.java8_katas.ch2_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class Exercise2_9 {

	private Exercise2_9() {
	}

	public static <T> List<T> joinSeriallyListsToNewInstance(Stream<List<T>> listStream) {
		return listStream.reduce(
				new ArrayList<>(),
				(current, item) -> {
					current.addAll(item);
					return current;
				}
		);
	}

	public static <T> List<T> joinInParallelListsToNewInstanceWithCombining(Stream<List<T>> listStream) {
		return listStream.reduce(
				new ArrayList<>(),
				(current, item) -> {
					ArrayList<T> result = new ArrayList<>();
					result.addAll(current);
					result.addAll(item);
					return result;
				},
				(left, right) -> {
					ArrayList<T> result = new ArrayList<>();
					result.addAll(left);
					result.addAll(right);
					return result;
				}
		);
	}

	public static <T> Optional<List<T>> joinSeriallyListsMutatingFirstOptionally(Stream<List<T>> listStream) {
		return listStream.reduce(
				(current, item) -> {
					current.addAll(item);
					return current;
				}
		);
	}

}
