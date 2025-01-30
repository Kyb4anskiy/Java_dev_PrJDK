package ru.kurbatov.oop.patterns.visitor;

public class StringWrapperForLength implements LengthVisiable {
    private String str;

    public StringWrapperForLength(String str) {
        this.str = str;
    }

    @Override
    public void setInVisitor(LengthVisitor visitor) {
        visitor.getValue(str);
    }
}
