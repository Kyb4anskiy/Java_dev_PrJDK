package ru.kurbatov.oop.generics;

public class Box<T>{

    private T obj;

    public void setObj(T obj) {
        if (!isEmpty()) throw new RuntimeException("Box no empty!");
        this.obj = obj;
    }

    public T getObj() {
        T objTemp = obj;
        obj = null;
        return objTemp;
    }

    public boolean isEmpty(){
        if (obj == null) return true;
        return false;
    }

}
