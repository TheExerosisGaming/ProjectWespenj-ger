package me.exerosis.wespe.engine;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public interface Holder<T> extends Predicate<T>, Iterable<T> {
    Collection<T> getContents();

    @Override
    default boolean test(T object) {
        return getContents().contains(object);
    }

    @Override
    default Iterator<T> iterator() {
        return getContents().iterator();
    }
}
