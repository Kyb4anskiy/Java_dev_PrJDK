package ru.kurbatov.main.tmp;

import ru.kurbatov.oop.any.geometry.figures.LengthCalculable;

import java.util.Arrays;
import java.util.stream.Stream;

public class Utils {

    public static double getSum(LengthCalculable... args){
        return Stream.of(args)
                .map(LengthCalculable::getLength)
                .reduce(0.0, Double::sum);
    }

}
