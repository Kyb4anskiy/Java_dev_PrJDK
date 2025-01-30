package ru.kurbatov.oop.patterns.BD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseData {
    private List<String> values;
    private List<ConnectionToBD> connections;
    private int currentConnectionSize = 0;
    private final int COUNT_CONNECTIONS;

    public BaseData(int maxConnections){
        COUNT_CONNECTIONS = maxConnections;
        connections = new ArrayList<>(COUNT_CONNECTIONS);
        randomValues();
    }

    private void randomValues() {
        values = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            values.add(String.valueOf(new Random().nextInt(10001)));
        }
    }

    public String getValue(ConnectionToBD connection, int index){
        if (!connections.contains(connection)) throw new IllegalArgumentException("Invalid connection");
        if (index < 0 || index > values.size()) return null;
        String tmp = values.get(index);
        values.set(index, null);
        return tmp;
    }

    public void setValue(ConnectionToBD connection, int index, String value){
        if (!connections.contains(connection)) throw new IllegalArgumentException("Invalid connection");
        if (index < 0 || index > values.size()) throw new IndexOutOfBoundsException("Cannot found index");
        values.set(index, value);
    }

    public boolean connect(ConnectionToBD connection) {
        if (currentConnectionSize < COUNT_CONNECTIONS) {
            connections.add(connection);
            currentConnectionSize++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BaseData{" +
                "values=" + values +
                ", connections=" + connections;
    }
}
