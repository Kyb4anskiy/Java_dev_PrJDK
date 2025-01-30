package ru.kurbatov.main.tmp;

import ru.kurbatov.oop.any.geometry.figures.LengthCalculable;

public class StringLengthAdapter implements LengthCalculable {

    private String str;

    public StringLengthAdapter(String str) {
        this.str = str;
    }

    @Override
    public double getLength() {
        return str.length();
    }
}
