package ru.kurbatov.exam.macros;

import java.util.*;

public class Macros<T> implements Action<T>{

    private String name;
    private List<T> data;
    private List<Action<T>> actions = new ArrayList<>();
    private static final Map<String, Macros<?>> poolMacros = new HashMap<>();

    private Macros(String name, List<T> data) {
        this.name = name;
        this.data = new ArrayList<>(data);
    }

    public static <T> Macros<T> create(String name, List<T> data){
        if (poolMacros.containsKey(name))
            throw new IllegalArgumentException("Macros with this name already created");
        poolMacros.put(name, new Macros<>(name,data));
        return (Macros<T>)poolMacros.get(name);
    }

    public static <T> Macros<T> find(String name){
        if (!poolMacros.containsKey(name))
            throw new NoSuchElementException("Macros not found");
        return (Macros<T>)poolMacros.get(name);
    }

    public String getName() {
        return name;
    }

    public void addAction(Action<T> action){
        this.actions.add(action);
    }

    public List<T> run(){
        return runAction(data);
    }

    @Override
    public List<T> runAction(List<T> data) {
        List<T> tmpData = new ArrayList<>(data);
        for (Action<T> action: actions){
            tmpData = action.runAction(tmpData);
        }
        return tmpData;
    }


}
