package ru.kurbatov.oop.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Fraction extends Number implements Cloneable{

    private final int numerator;
    private final int denominator;

    private Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static class FractionPull{
        private static FractionPull pull;
        private static Map<String, Fraction> pullMap = new HashMap<>();

        private FractionPull(){

        }

        public Fraction createFraction(int numerator, int denominator){
            String key = numerator + "/" + denominator;
            if (!pullMap.containsKey(key))
                pullMap.put(key, new Fraction(numerator,denominator));
            return pullMap.get(key);
        }

        public static FractionPull getPull() {
            if (pull == null)
                pull = new FractionPull();
            return pull;
        }
    }

    public Fraction sum(Fraction fraction){
        return new Fraction(this.numerator * fraction.denominator + fraction.numerator * this.denominator, this.denominator * fraction.denominator);
    }

    public Fraction sum(int num){
        return sum(new Fraction(num,1));
    }

    public Fraction minus(Fraction fraction){
        return new Fraction(this.numerator * fraction.denominator - fraction.numerator * this.denominator, this.denominator * fraction.denominator);
    }

    public Fraction minus(int num){
        return minus(new Fraction(num,1));
    }

    public Fraction multi(Fraction fraction){
        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction multi(int num){
        return multi(new Fraction(num,1));
    }

    public Fraction div(Fraction fraction){
        return new Fraction(this.numerator * fraction.denominator, this.denominator * fraction.numerator);
    }

    public Fraction div(int num){
        return div(new Fraction(num,1));
    }

    public String toString(){
        return numerator + "/" + denominator;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long)numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float)numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Fraction f = (Fraction)obj;
        if (numerator == f.numerator &&
            denominator == f.denominator) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
    
     @Override 
     public Fraction clone() throws CloneNotSupportedException {
         return (Fraction) super.clone();
     } 
}
