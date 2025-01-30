package ru.kurbatov.oop.patterns.stream;

import java.util.Collection;

public interface ConverterCollection<T extends Collection<?>, P> {
    void addTo(T collection, P val);
}
