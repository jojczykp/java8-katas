package pl.jojczykp.java8_katas.ch6_concurrency;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class Exercise_6_11_CompletableFutureWithThenComposeTest {

	private static final long ONE_SECOND_AS_MILLIS = 1000;

	@Test
	public void shouldRepeatActionUntilConditionIsMet() throws Exception {
		Instant beg = Instant.now();

		Instant last = Exercise_6_11_CompletableFutureWithThenCompose
				.repeat(
						Instant::now,
						curr -> Duration.between(beg, curr).toMillis() > ONE_SECOND_AS_MILLIS)
				.get(2, TimeUnit.SECONDS);

		assertThat(Duration.between(beg, last).toMillis(), is(greaterThan(ONE_SECOND_AS_MILLIS)));
	}

}
