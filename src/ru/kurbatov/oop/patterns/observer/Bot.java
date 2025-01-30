package ru.kurbatov.oop.patterns.observer;

public class Bot implements StockUserable{

    String name;

    public Bot(String name) {
        this.name = name;
    }

    @Override
    public void getNotify(Stockable stock) {
        System.out.println(name + ": cost changed - " + stock.getName());
    }

}
