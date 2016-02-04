package pl.jojczykp.java8_katas.tools.coverage;

import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;

import static java.util.Arrays.stream;

public class NonExecutedMethodsCoverageTest {

	@Test
	public void shouldHaveUnsupportedMethodsInPixelReaderCache() {
		shouldHaveUnsupportedMethodInPixelReaderCache("getPixelFormat");
		shouldHaveUnsupportedMethodInPixelReaderCache("getArgb", int.class, int.class);
		shouldHaveUnsupportedMethodInPixelReaderCache("getPixels", int.class, int.class,
				int.class, int.class, WritablePixelFormat.class, Buffer.class, int.class);
		shouldHaveUnsupportedMethodInPixelReaderCache("getPixels", int.class, int.class,
				int.class, int.class, WritablePixelFormat.class, byte[].class, int.class, int.class);
		shouldHaveUnsupportedMethodInPixelReaderCache("getPixels", int.class, int.class,
				int.class, int.class, WritablePixelFormat.class, int[].class, int.class, int.class);
	}

	private void shouldHaveUnsupportedMethodInPixelReaderCache(String methodName, Class<?>... parameterTypes) {
		try {
			invokeInPixelReaderCache(methodName, parameterTypes);
		} catch (UnsupportedOperationException e) {
			return;
		}
		throw new AssertionError(UnsupportedOperationException.class.getSimpleName() + " not thrown!");
	}

	private void invokeInPixelReaderCache(String methodName, Class<?>... parameterTypes) {
		invokeNotAccessible("pl.jojczykp.java8_katas.ch3_lambda_programming" +
				".Exercise_3_14_LazyCompositionWithHistoryInt$PixelReaderCache",
				methodName, parameterTypes);
	}

	private void invokeNotAccessible(String className, String methodName, Class<?>... parameterTypes) {
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> ctor = clazz.getDeclaredConstructor(PixelReader.class, int.class, int.class);
			ctor.setAccessible(true);
			Object o = ctor.newInstance(null, 0, 0);
			Method m = o.getClass().getDeclaredMethod(methodName, parameterTypes);
			m.setAccessible(true);
			m.invoke(o, emptyValuesFor(parameterTypes));
		} catch (InvocationTargetException e) {
			throw (UnsupportedOperationException) e.getTargetException();
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

	private Object[] emptyValuesFor(Class<?>[] parameterTypes) {
		return stream(parameterTypes)
				.map(t -> t.isPrimitive() ? 0 : null)
				.toArray();
	}

}
