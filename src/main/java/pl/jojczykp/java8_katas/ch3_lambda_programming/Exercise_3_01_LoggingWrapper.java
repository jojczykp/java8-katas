package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.logging.Level;

public class Exercise_3_01_LoggingWrapper {

	public void logIf(Level level, BooleanSupplier condition, Consumer<Level> logAction) {
		if (condition.getAsBoolean()) {
			logAction.accept(level);
		}
	}

}
