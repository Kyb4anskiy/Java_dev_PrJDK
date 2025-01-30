package ru.kurbatov.oop.patterns.visitor;

public class NumberWrapperForSum implements SumVisitable {
    private Number num;

    public NumberWrapperForSum(Number num) {
        this.num = num;
    }

    @Override
    public void setInVisitor(SumVisitor visitor) {
        visitor.getValue(num);
    }
}
