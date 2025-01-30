package ru.kurbatov.oop.patterns.observer;

public interface Stockable {

    void addUser(StockUserable user);
    void notifyUsers();
    String getName();
}
