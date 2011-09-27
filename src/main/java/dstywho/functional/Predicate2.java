package dstywho.functional;

public abstract class Predicate2<T> extends Closure2<Boolean, T> {

	public abstract Boolean act(T param);

}
