package ru.kurbatov.oop.generics;

public class ObjTmp {
    private static Storage<Integer>  instance;

    public static Storage<Integer> ofCount(){
        if (instance == null)
            synchronized (Storage.class){
                if (instance == null){
                    instance = new Storage<Integer>(5);
                }
            }
        System.out.println("STORAGE CREATE");
        return instance;
    }
}
