package ru.kurbatov.oop.patterns.observer;

public class Printer implements StockUserable{

    String name;

    public Printer(String name) {
        this.name = name;
    }

    @Override
    public void getNotify(Stockable stock) {
        System.out.println(name + ": cost changed - " + stock.getName());
    }
}
