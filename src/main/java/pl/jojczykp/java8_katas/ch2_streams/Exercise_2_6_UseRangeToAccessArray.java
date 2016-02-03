package pl.jojczykp.java8_katas.ch2_streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Exercise_2_6_UseRangeToAccessArray {

	private Exercise_2_6_UseRangeToAccessArray() {
	}

	public static Stream<Character> characterStream(String s) {
		return IntStream.range(0, s.length()).mapToObj(s::charAt);
	}

}
