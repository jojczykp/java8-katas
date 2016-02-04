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
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_14_LazyCompositionWithHistoryInt;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_15_LazyParallel;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_16_ParallelBiConsumer;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_17_ParallelRunnables;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_18_UncheckFunctionWrapper;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_20_MapListTransformingWithFunction;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_21_MapFutureTransformingWithFunction;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_5_PassingFunctions;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_6_PassingParametrizedFunction;
import pl.jojczykp.java8_katas.ch3_lambda_programming.Exercise_3_8_PassingGeneralizingFunctions;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.reflect.Modifier.isPrivate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NonInstantiableClassesCoverageTest {

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
		shouldHavePrivateSoleConstructor(Exercise_3_14_LazyCompositionWithHistoryInt.class);
		shouldHavePrivateSoleConstructor(Exercise_3_15_LazyParallel.class);
		shouldHavePrivateSoleConstructor(Exercise_3_16_ParallelBiConsumer.class);
		shouldHavePrivateSoleConstructor(Exercise_3_17_ParallelRunnables.class);
		shouldHavePrivateSoleConstructor(Exercise_3_18_UncheckFunctionWrapper.class);
		shouldHavePrivateSoleConstructor(Exercise_3_20_MapListTransformingWithFunction.class);
		shouldHavePrivateSoleConstructor(Exercise_3_21_MapFutureTransformingWithFunction.class);
	}

	private <T> void shouldHavePrivateSoleConstructor(Class<T> clazz) throws Exception {
		Constructor<T> constructor = clazz.getDeclaredConstructor();
		assertThat(isPrivate(constructor.getModifiers()), is(true));
		constructor.setAccessible(true);
		constructor.newInstance();
	}

	@Test
	public void shouldReturnedFutureDelegateNonGetMethods() {
		final AtomicBoolean invokedCancel = new AtomicBoolean();
		final AtomicBoolean invokedIsCancelled = new AtomicBoolean();
		final AtomicBoolean invokedIsDone = new AtomicBoolean();
		final Future<Integer> delegateFuture = new Future<Integer>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				invokedCancel.set(true);
				return false;
			}

			@Override
			public boolean isCancelled() {
				invokedIsCancelled.set(true);
				return false;
			}

			@Override
			public boolean isDone() {
				invokedIsDone.set(true);
				return false;
			}

			@Override
			public Integer get() throws InterruptedException, ExecutionException {
				return null;
			}

			@Override
			public Integer get(long timeout, TimeUnit unit) throws InterruptedException,
					ExecutionException, TimeoutException {
				return null;
			}
		};
		Future<String> mappedFuture = Exercise_3_21_MapFutureTransformingWithFunction
				.map(delegateFuture, Object::toString);

		mappedFuture.cancel(true);
		mappedFuture.isCancelled();
		mappedFuture.isDone();

		assertThat(invokedCancel.get(), is(true));
		assertThat(invokedIsCancelled.get(), is(true));
		assertThat(invokedIsDone.get(), is(true));
	}

}
