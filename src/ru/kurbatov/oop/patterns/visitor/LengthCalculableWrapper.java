package ru.kurbatov.oop.patterns.visitor;

import ru.kurbatov.oop.any.geometry.figures.LengthCalculable;

public class LengthCalculableWrapper implements LengthVisiable{
    private LengthCalculable lenCul;

    public LengthCalculableWrapper(LengthCalculable lenCul) {
        this.lenCul = lenCul;
    }


    @Override
    public void setInVisitor(LengthVisitor visitor) {
        visitor.getValue(lenCul);
    }
}
