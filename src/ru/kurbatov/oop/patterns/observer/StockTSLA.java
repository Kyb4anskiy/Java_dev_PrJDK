package ru.kurbatov.oop.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class StockTSLA implements Stockable{

    private final String name;
    protected double cost;
    protected List<StockUserable> users = new ArrayList<>();

    public StockTSLA(String name, double cost, List<StockUserable> users) {
        this.name = name;
        this.cost = cost;
        this.users = users;
    }

    public void changeCost(double cost){
        this.cost = cost;
        notifyUsers();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addUser(StockUserable user) {
        users.add(user);
    }

    @Override
    public void notifyUsers() {
        users.forEach(x->x.getNotify(this));
    }

}
