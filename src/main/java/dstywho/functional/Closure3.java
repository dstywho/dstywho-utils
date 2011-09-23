package dstywho.functional;

public abstract class Closure3<T, V, E> {
	public T perform(V param, E param2) {
		return act(param,param2);
	}

	public T call(V param, E param2) {
		return act(param,param2);
	}

	public T execute(V param, E param2) {
		return act(param,param2);
	}

	public abstract T act(V param, E param2);
}
