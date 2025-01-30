package ru.kurbatov.oop.patterns.stream;

public interface Reducer<T>{
    T reduce(T x, T y);
}
