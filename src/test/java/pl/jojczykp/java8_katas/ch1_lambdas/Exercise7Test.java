package pl.jojczykp.java8_katas.ch1_lambdas;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.reflect.Modifier.isPrivate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static pl.jojczykp.java8_katas.ch1_lambdas.Exercise7.andThen;

public class Exercise7Test {

	@Test
	public void shouldRunBoth() {
		AtomicBoolean executedFirst = new AtomicBoolean(false);
		AtomicBoolean executedSecond = new AtomicBoolean(false);

		andThen(() -> executedFirst.set(true),
				() -> executedSecond.set(true))
				.run();

		assertThat(executedFirst.get(), is(true));
		assertThat(executedSecond.get(), is(true));
	}

	@Test
	public void shouldHavePrivateSoleConstructor() throws Exception {
		Constructor<Exercise7> constructor = Exercise7.class.getDeclaredConstructor();
		assertThat(isPrivate(constructor.getModifiers()), is(true));
		constructor.setAccessible(true);
		constructor.newInstance();
	}

}
