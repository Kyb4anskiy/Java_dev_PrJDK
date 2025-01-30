package ru.kurbatov.oop.patterns.visitor;

import ru.kurbatov.oop.any.geometry.figures.LengthCalculable;

public class LengthSummatorVisitor implements LengthVisitor {
    private double sum = 0;

    public double getSum() {
        return sum;
    }

    @Override
    public void getValue(String str) {
        sum+=str.length();
    }

    @Override
    public void getValue(LengthCalculable lenCul) {
        sum+=lenCul.getLength();
    }


}
