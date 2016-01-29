package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise2_10Test {

	//CHECKSTYLE.OFF: MagicNumber

	@Test
	public void shouldComputeAverage() {
		Stream<Double> stream = Stream.of(2.8, 4.6, 6.4, 8.2);

		Optional<Double> optionalAverage = Exercise2_10.averageUsingReduceOf(stream);

		assertThat(optionalAverage.isPresent(), is(true));
		assertThat(optionalAverage.get(), is(equalTo(5.5)));
	}

	//CHECKSTYLE.ON: MagicNumber

	@Test
	public void shouldReturnEmptyOptionalForEmptyStream() {
		Stream<Double> stream = Stream.empty();

		Optional<Double> optionalAverage = Exercise2_10.averageUsingReduceOf(stream);

		assertThat(optionalAverage.isPresent(), is(false));
	}

}
