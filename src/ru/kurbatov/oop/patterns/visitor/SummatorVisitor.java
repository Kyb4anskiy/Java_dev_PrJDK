package ru.kurbatov.oop.patterns.visitor;

public class SummatorVisitor implements SumVisitor {
    private double sum = 0;

    public double getSum() {
        return sum;
    }

    @Override
    public void getValue(Number num) {
        sum+=num.doubleValue();
    }

    @Override
    public void getValue(String str) {
        sum+=str.length();
    }
}
