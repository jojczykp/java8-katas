package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.util.concurrent.locks.Lock;

public class Exercise_3_2_LockWrapper {

	public void withLock(Lock myLock, Runnable action) {
		myLock.lock();
		try {
			action.run();
		} finally {
			myLock.unlock();
		}
	}

}
