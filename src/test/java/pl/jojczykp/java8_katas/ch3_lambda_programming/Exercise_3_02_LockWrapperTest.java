package pl.jojczykp.java8_katas.ch3_lambda_programming;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.locks.Lock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class Exercise_3_02_LockWrapperTest {

	private static final RuntimeException MY_RUNTIME_EXCEPTION = new RuntimeException();
	private Exercise_3_02_LockWrapper testee = new Exercise_3_02_LockWrapper();

	@Mock private Lock myLock;
	@Mock private Runnable myAction;
	private InOrder inOrder;

	@Before public void prepareInOrder() {
		inOrder = Mockito.inOrder(myLock, myAction);
	}

	@Test
	public void shouldProcessAction() {
		testee.withLock(myLock, () -> myAction.run());

		inOrder.verify(myLock).lock();
		inOrder.verify(myAction).run();
		inOrder.verify(myLock).unlock();
		verifyNoMoreInteractions(myLock, myAction);
	}

	@Test
	public void shouldUnlockAfterException() {
		RuntimeException caught = null;
		doThrow(MY_RUNTIME_EXCEPTION).when(myAction).run();

		try {
			testee.withLock(myLock, () -> myAction.run());
		} catch (RuntimeException e) {
			caught = e;
		}

		assertThat(caught, is(sameInstance(MY_RUNTIME_EXCEPTION)));
		inOrder.verify(myLock).lock();
		inOrder.verify(myAction).run();
		inOrder.verify(myLock).unlock();
		verifyNoMoreInteractions(myLock, myAction);
	}

}
