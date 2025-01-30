package ru.kurbatov.oop.patterns.stream;

import java.util.function.Function;

public interface Convertor<T,P> {
    P apply(T x);
}
