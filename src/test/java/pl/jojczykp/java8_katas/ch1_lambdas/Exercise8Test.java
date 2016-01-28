package pl.jojczykp.java8_katas.ch1_lambdas;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class Exercise8Test {

	@Test
	public void shouldExecuteLambdaRunnablesInLoop() {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new LinkedList<>();
		List<String> messages = new LinkedList<>();

		for (String name : names) {
			runners.add(() -> messages.add(name));
		}
		runners.forEach(Runnable::run);

		assertThat(messages, contains(names));
	}

}
