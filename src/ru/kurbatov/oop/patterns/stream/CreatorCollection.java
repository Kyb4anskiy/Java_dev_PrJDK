package ru.kurbatov.oop.patterns.stream;

import java.util.Collection;

public interface CreatorCollection<T extends Collection<?>> {
    T create();
}
