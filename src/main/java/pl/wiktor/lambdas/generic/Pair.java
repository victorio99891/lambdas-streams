package pl.wiktor.lambdas.generic;

import lombok.extern.slf4j.Slf4j;
import pl.wiktor.lambdas.exceptions.FirstOrSecondIsNullException;

import java.util.Objects;

@Slf4j
public class Pair<T, E> {

    private T first;
    private E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    public boolean checkIfFirstAndSecondAreTheSame() {

        if (this.first == null || this.second == null) {
            throw new FirstOrSecondIsNullException("First or Second member of pair is null. " + this.toString());
        }

        if (!this.first.getClass().isInstance(this.second)) {
            log.error(ClassCastException.class.getName() + ": Cannot cast first and second: " + this.toString());
            throw new ClassCastException("Cannot cast first and second: " + this.toString());
        }

        return this.first.equals(this.second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        if (this.first == null || this.second == null) {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        } else {
            return "Pair{" +
                    "first<" + this.first.getClass().getName() + ">=" + first +
                    ", second<" + this.second.getClass().getName() + ">=" + second +
                    '}';
        }
    }
}
