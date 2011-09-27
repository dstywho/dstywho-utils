package dstywho.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import dstywho.functional.Closure;
import dstywho.functional.Predicate2;

public class Execution<T> {
	private final Long timeout;
	private final TimeUnit unit;
	private final Closure<T> toDo;

	public Execution(Long timeout, TimeUnit unit, Closure<T> toDo) {
		super();
		this.timeout = timeout;
		this.unit = unit;
		this.toDo = toDo;
	}

	private T execute(Closure<T> c) throws TimeoutException {
		FutureTask<T> task = new FutureTask<T>(c);
		new Thread(task).start();
		T result = null;

		try {
			result = task.get(timeout, unit);
		} catch (InterruptedException e) {
			throw new TimeoutException("Execution timedout after " + timeout
					+ unit);
		} catch (ExecutionException e) {
			throw new RuntimeException("problem running your block of code", e);
		}

		return result;

	}

	public T once() throws TimeoutException {
		return execute(toDo);
	}

	public T until(final Predicate2<T> condition) throws TimeoutException {
		Closure<T> until = new Closure<T>() {
			@Override
			public T act() {
				T lastExecution = null;
				while (true) {
					lastExecution = toDo.call();
					if (condition.act(lastExecution)) {
						break;
					}
					Timeout.TIMEOUT_ONE_SECOND.sleep();
				}
				return lastExecution;
			}
		};
		return execute(until);

	}

}
