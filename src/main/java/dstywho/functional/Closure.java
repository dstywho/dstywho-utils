package dstywho.functional;

public abstract class Closure<T> {
  public T perform() {
    return act();
  }

  public T call() {
    return act();
  }
  
  public T execute() {
    return act();
  }

  public abstract T act();
}
