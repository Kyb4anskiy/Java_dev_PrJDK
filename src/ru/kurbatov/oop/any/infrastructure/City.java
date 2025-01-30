package ru.kurbatov.oop.any.infrastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class City {

    private String name;
    protected List<Way> ways;

    public City(String name, Way... ways){
        this.name = name;
        setWays(ways);
    }

    public String getName(){ return name; }

    public void setWays(Way... ways){
        this.ways = new ArrayList<>();
        addWays(Arrays.asList(ways));
    }

    protected void updateWay(Way newWay){
        for (int i = 0; i < ways.size(); i++){
            if (ways.get(i).getCity() == newWay.getCity()){
                ways.get(i).setCost(newWay.getCost());
                return;
            }
        }
        ways.add(new Way(newWay.getCity(),newWay.getCost()));
    }

    public void addWay(Way newWay){
        for (int i = 0; i < ways.size(); i++){
            if (ways.get(i).getCity() == newWay.getCity()){
                updateWay(newWay);
                return;
            }
        }
        ways.add(new Way(newWay.getCity(), newWay.getCost()));
    }

    public void addWays(List<Way> newWays){
        if (newWays == null) return;
        for(int i = 0; i < newWays.size(); i++){
            Way newWay = newWays.get(i);
            if (this == newWay.getCity()) continue;
            addWay(newWay);
        }
    }

    public void removeWay(City delCity){
        for (int i = 0; i < ways.size(); i++){
            if (ways.get(i).getCity() == delCity){
                ways.remove(i);
                break;
            }
        }
    }

    public String toString(){
        return name + " " + ways;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof City c)) return false;

        if (ways.isEmpty() && c.ways.isEmpty()) return false;
        if (ways.size() != c.ways.size()) return false;

        for (int i = 0; i < ways.size(); i++){
            if (!(ways.contains(c.ways.get(i)) && c.ways.contains(ways.get(i)))) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (Way way : ways) {
            hashCode += way.hashCode();
        }
        return hashCode;
    }
}
