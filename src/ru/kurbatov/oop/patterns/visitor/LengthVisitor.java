package ru.kurbatov.oop.patterns.visitor;

import ru.kurbatov.oop.any.geometry.figures.LengthCalculable;

public interface LengthVisitor {
    
    void getValue(String str);
    void getValue(LengthCalculable lenCul);
}
