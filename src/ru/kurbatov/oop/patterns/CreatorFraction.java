//package ru.kurbatov.oop.patterns;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//public class CreatorFraction {
//
//    private static Map<Integer, Fraction> poolFractions = new HashMap<>();
//
//    static {
//        poolFractions.put(Objects.hash(0,1), new Fraction(0,1));
//        poolFractions.put(Objects.hash(1,1), new Fraction(1,1));
//        poolFractions.put(Objects.hash(-1,1), new Fraction(-1,1));
//    }
//
//    public static Fraction of(int numerator, int denominator){
//        if (denominator == 0) throw new IllegalArgumentException("Argument 'denominator' is 0");
//        if (denominator < 0){
//            numerator = -1 * numerator;
//            denominator = -1 * denominator;
//        }
//        int nod = euclideanAlgorithm(Math.abs(numerator),Math.abs(denominator));
//        numerator = numerator / nod;
//        denominator = denominator / nod;
//
//        int hash = Objects.hash(numerator, denominator);
//        Fraction tmpFraction = poolFractions.get(hash);
//        if (tmpFraction == null) {
//            tmpFraction = new Fraction(numerator, denominator);
//            poolFractions.put(hash, tmpFraction);
//            return tmpFraction;
//        }
//        return tmpFraction;
//
//    }
//
//    private static int euclideanAlgorithm(int firstNum, int secondNum) {
//        if (firstNum == 0 || secondNum == 0) return Math.max(firstNum, secondNum);
//        while (firstNum != secondNum) {
//            if (firstNum > secondNum)
//                firstNum = firstNum - secondNum;
//            else
//                secondNum = secondNum - firstNum;
//        }
//        return firstNum;
//    }
//
//}
