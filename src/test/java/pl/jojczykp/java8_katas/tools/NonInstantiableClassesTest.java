package pl.jojczykp.java8_katas.tools;

import org.junit.Test;
import pl.jojczykp.java8_katas.ch1_lambdas.Exercise1_6;
import pl.jojczykp.java8_katas.ch1_lambdas.Exercise1_7;
import pl.jojczykp.java8_katas.ch1_lambdas.Exercise1_9;
import pl.jojczykp.java8_katas.ch2_streams.Exercise2_10;
import pl.jojczykp.java8_katas.ch2_streams.Exercise2_6;
import pl.jojczykp.java8_katas.ch2_streams.Exercise2_7;
import pl.jojczykp.java8_katas.ch2_streams.Exercise2_8;
import pl.jojczykp.java8_katas.ch2_streams.Exercise2_9;

import java.lang.reflect.Constructor;

import static java.lang.reflect.Modifier.isPrivate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NonInstantiableClassesTest {

	@Test
	public void shouldHavePrivateSoleConstructor() throws Exception {
		shouldHavePrivateSoleConstructor(Exercise1_6.class);
		shouldHavePrivateSoleConstructor(Exercise1_7.class);
		shouldHavePrivateSoleConstructor(Exercise1_9.class);
		shouldHavePrivateSoleConstructor(Exercise2_6.class);
		shouldHavePrivateSoleConstructor(Exercise2_7.class);
		shouldHavePrivateSoleConstructor(Exercise2_8.class);
		shouldHavePrivateSoleConstructor(Exercise2_9.class);
		shouldHavePrivateSoleConstructor(Exercise2_10.class);
	}

	private <T> void shouldHavePrivateSoleConstructor(Class<T> clazz) throws Exception {
		Constructor<T> constructor = clazz.getDeclaredConstructor();
		assertThat(isPrivate(constructor.getModifiers()), is(true));
		constructor.setAccessible(true);
		constructor.newInstance();
	}
}
