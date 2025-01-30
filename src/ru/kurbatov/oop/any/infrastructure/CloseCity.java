package ru.kurbatov.oop.any.infrastructure;

public class CloseCity extends City{

    public CloseCity(String name, Way... ways){
        super(name, ways);
    }

    @Override
    public void addWay(Way newWay){
        super.addWay(newWay);
        newWay.getCity().updateWay(new Way(this, newWay.getCost()));
    }

    @Override
    public void removeWay(City delCity){
        super.removeWay(delCity);
        for (int i = 0; i < delCity.ways.size(); i++){
            if (delCity.ways.get(i).getCity() == this){
                delCity.ways.remove(i);
                break;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}