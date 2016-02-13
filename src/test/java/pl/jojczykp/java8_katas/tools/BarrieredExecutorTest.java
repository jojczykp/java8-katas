package pl.jojczykp.java8_katas.tools;

import org.junit.Test;
import pl.jojczykp.java8_katas.tools.BarrieredExecutor.RunnableEx;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BarrieredExecutorTest {

	private BarrieredExecutor testee = new BarrieredExecutor(3);

	@Test
	public void shouldExecuteTaskIfStarted() {
		AtomicBoolean wasExecuted = new AtomicBoolean(false);
		RunnableEx task = () -> wasExecuted.set(true);

		testee.addTask(task);
		testee.execute();

		assertThat(wasExecuted.get(), is(true));
	}

	@Test
	public void shouldNotExecuteTaskIfNotStarted() {
		AtomicBoolean wasExecuted = new AtomicBoolean(false);
		RunnableEx task = () -> wasExecuted.set(true);

		testee.addTask(task);

		assertThat(wasExecuted.get(), is(false));
	}

}
