package ru.kurbatov.oop.patterns.visitor;

public class StringWrapperForSum implements SumVisitable {
    private String str;

    public StringWrapperForSum(String str) {
        this.str = str;
    }

    @Override
    public void setInVisitor(SumVisitor visitor) {
        visitor.getValue(str);
    }
}
