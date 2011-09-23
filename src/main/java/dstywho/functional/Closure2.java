package dstywho.functional;

public abstract class Closure2<T, V> {
	public T perform(V param) {
		return act(param);
	}

	public T call(V param) {
		return act(param);
	}

	public T execute(V param) {
		return act(param);
	}

	public abstract T act(V param);
}
