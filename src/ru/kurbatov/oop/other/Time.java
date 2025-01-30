package ru.kurbatov.oop.other;

public class Time {

    private int seconds;

    static final int HOUR_IN_DAY = 24;
    static final int MIN_IN_HOUR = 60;
    static final int SEC_IN_MIN = 60;

    public Time(int seconds){
        if (checkTime(seconds)) this.seconds = seconds;
        else this.seconds = SEC_IN_MIN * MIN_IN_HOUR * HOUR_IN_DAY;
    }

    public Time(int hour, int min, int sec){
        this(sec + min * SEC_IN_MIN + hour * SEC_IN_MIN * MIN_IN_HOUR);
    }

    public int getHour(){
        return seconds / (SEC_IN_MIN * MIN_IN_HOUR);
    }

    public int getMin(){
        return seconds / SEC_IN_MIN - getHour() * MIN_IN_HOUR;
    }

    public int getSec(){
        return seconds - getMin() * SEC_IN_MIN - getHour() * SEC_IN_MIN * MIN_IN_HOUR;
    }

    private boolean checkTime(int seconds){
        return seconds < SEC_IN_MIN * MIN_IN_HOUR * HOUR_IN_DAY;
    }

    private void timeTranslation(int hour, int min, int sec){
        seconds = sec + min * SEC_IN_MIN + hour * SEC_IN_MIN * MIN_IN_HOUR;
    }

    public String toString(){
        return String.format("%02d:%02d:%02d", getHour(), getMin(), getSec());
    }
}
