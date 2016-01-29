package pl.jojczykp.java8_katas.ch2_streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.Collectors.toList;

public final class Exercise2_8 {

	private Exercise2_8() {
	}

	@SafeVarargs
	public static <T> Stream<T> zip(Stream<T>... streams) {
		List<Iterator<T>> iterators = Arrays.stream(streams)
				.map(Stream::iterator)
				.collect(toList());

		Iterator<T> zippedIterator = new Iterator<T>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return iterators.get(index).hasNext();
			}

			@Override
			public T next() {
				T result = iterators.get(index).next();
				index = (index + 1) % iterators.size();

				return result;
			}
		};

		return StreamSupport.stream(spliteratorUnknownSize(zippedIterator, ORDERED), false);
	}

}
