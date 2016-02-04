package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public final class Exercise_3_20_MapListTransformingWithFunction {

	private Exercise_3_20_MapListTransformingWithFunction() {}

	public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
		return list.stream().map(function).collect(toList());
	}

}
