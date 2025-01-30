package ru.kurbatov.exam.trafficLight;

public class TrafficLight {

    private Lightable light;

    public TrafficLight(Lightable light) {
        this.light = light;
    }

    public void setLight(Lightable light){
        this.light = light;
    }

    public Lightable getLight() {
        return light;
    }

    public void next(){
        this.light = light.changeColor();
        System.out.println(light.getColor());
    }


}
