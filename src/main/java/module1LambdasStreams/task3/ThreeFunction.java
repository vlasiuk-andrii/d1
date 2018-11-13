package module1LambdasStreams.task3;

@FunctionalInterface
public interface ThreeFunction<T> {

    T act(T a, T b, T c);
}
