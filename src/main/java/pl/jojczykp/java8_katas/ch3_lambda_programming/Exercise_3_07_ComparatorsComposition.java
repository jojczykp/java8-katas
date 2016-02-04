package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.Comparator;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

public class Exercise_3_07_ComparatorsComposition {

	public Comparator<String> getComposedStringComparator(
			boolean reversed, boolean caseInsensitive, boolean spaceInsensitive) {
		Function<String, String> withModification = Function.identity();

		if (caseInsensitive) {
			withModification = withModification.andThen(String::toUpperCase);
		}

		if (spaceInsensitive) {
			withModification = withModification.andThen(s -> s.replaceAll(" ", ""));
		}

		return comparing(withModification, reversed ? reverseOrder() : naturalOrder());

	}

}
