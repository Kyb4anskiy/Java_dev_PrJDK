package ru.kurbatov.oop.patterns.visitor;


import ru.kurbatov.oop.any.geometry.figures.LengthCalculable;

public interface SumVisitor {
    void getValue(Number num);
    void getValue(String str);
}
