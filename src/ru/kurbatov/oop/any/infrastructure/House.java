package ru.kurbatov.oop.any.infrastructure;

public class House {

    private final int floor;

    public House(int floor){
        if (floor > 0)
            this.floor = floor;
        else
            throw new IllegalArgumentException("The number of floors must be positive");
    }


    public String toString(){
        String gramFloor;
        if (floor % 10 == 1 && floor % 100 != 11) gramFloor = "этажом";
        else gramFloor = "этажами";
        return String.format("дом с %d %s", floor, gramFloor);
    }
}

