package ru.kurbatov.oop.generics;

public class Storage<T> {

    private final T obj;
    private static final Storage<?> NULL_STORAGE = new Storage<>(null);

    protected Storage(T obj){
        this.obj = obj;
    }

    public static Storage<?> getNull(){
        return NULL_STORAGE;
    }

    public static <T> Storage<T> of(T obj){
        if (obj == null)
            return (Storage<T>) NULL_STORAGE;
        return new Storage<>(obj);
    }

    public  T getValue(T alterVal){
        if (obj == null)
            return alterVal;
        return obj;
    }

    @Override
    public String toString() {
        return "Storage with " + obj +" of " + obj.getClass();
    }
}
