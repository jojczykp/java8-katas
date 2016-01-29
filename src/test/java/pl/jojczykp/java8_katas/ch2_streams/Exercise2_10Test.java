package pl.jojczykp.java8_katas.ch2_streams;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise2_10Test {

	//CHECKSTYLE.OFF: MagicNumber

	@Test
	public void shouldComputeAverage() {
		Stream<Double> stream = Stream.of(2.8, 4.6, 6.4, 8.2);

		double average = Exercise2_10.averageOf(stream);

		assertThat(average, is(equalTo(5.5)));
	}

	//CHECKSTYLE.ON: MagicNumber

}
