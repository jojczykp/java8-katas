package pl.jojczykp.java8_katas.tools;

import org.junit.Test;
import pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_6_UncheckExceptionWrapper;
import pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_7_CombineTwoLambdas;
import pl.jojczykp.java8_katas.ch1_lambda_expressions.Exercise_1_9_ForEachIf;
import pl.jojczykp.java8_katas.ch2_streams.Exercise_2_6_UseRangeToAccessArray;
import pl.jojczykp.java8_katas.ch2_streams.Exercise_2_7_CountClosesStream;
import pl.jojczykp.java8_katas.ch2_streams.Exercise_2_8_Zip;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_12_LazyFunctionalInterfacesComposition;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_13_LazyCompositionWithHistory;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_5_PassingFunctions;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_6_PassingParametrizedFunction;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_8_PassingGeneralizingFunctions;

import java.lang.reflect.Constructor;

import static java.lang.reflect.Modifier.isPrivate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NonInstantiableClassesTest {

	@Test
	public void shouldHavePrivateSoleConstructor() throws Exception {
		shouldHavePrivateSoleConstructor(Exercise_1_6_UncheckExceptionWrapper.class);
		shouldHavePrivateSoleConstructor(Exercise_1_7_CombineTwoLambdas.class);
		shouldHavePrivateSoleConstructor(Exercise_1_9_ForEachIf.class);
		shouldHavePrivateSoleConstructor(Exercise_2_6_UseRangeToAccessArray.class);
		shouldHavePrivateSoleConstructor(Exercise_2_7_CountClosesStream.class);
		shouldHavePrivateSoleConstructor(Exercise_2_8_Zip.class);
		shouldHavePrivateSoleConstructor(Exercise_3_5_PassingFunctions.class);
		shouldHavePrivateSoleConstructor(Exercise_3_6_PassingParametrizedFunction.class);
		shouldHavePrivateSoleConstructor(Exercise_3_8_PassingGeneralizingFunctions.class);
		shouldHavePrivateSoleConstructor(Exercise_3_12_LazyFunctionalInterfacesComposition.class);
		shouldHavePrivateSoleConstructor(Exercise_3_13_LazyCompositionWithHistory.class);
	}

	private <T> void shouldHavePrivateSoleConstructor(Class<T> clazz) throws Exception {
		Constructor<T> constructor = clazz.getDeclaredConstructor();
		assertThat(isPrivate(constructor.getModifiers()), is(true));
		constructor.setAccessible(true);
		constructor.newInstance();
	}

}
