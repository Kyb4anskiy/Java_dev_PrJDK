package ru.kurbatov.oop.patterns.BD;

public class ConnectionToBD {
    private BaseData BD;

    public ConnectionToBD(BaseData BD) {
        if (!BD.connect(this))
            throw new IllegalArgumentException("BD have full connection");
        this.BD = BD;
    }

    public String getValue(int index){
        return BD.getValue(this, index);
    }

    public void setValue(int index, String value){
        BD.setValue(this, index, value);
    }

    @Override
    public String toString() {
        return "Connection to BD";
    }
}
