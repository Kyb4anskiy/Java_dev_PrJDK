package ru.kurbatov.oop.any.infrastructure;

import java.util.Objects;

public class Way {

    private City city;
    private int cost;

    public Way(City city, int cost){
        this.city = city;
        this.cost = cost;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toString(){
        return city.getName() + ": " + cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Way way = (Way) obj;
        return city == way.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city.getName());
    }
}
