package ru.kurbatov.oop.any.geometry.points;

public class CreatorPoint {

    public static Point2D empty(){
        return new Point2D(0,0);
    }

    public static Point2D of(int X, int Y){
        return new Point2D(X, Y);
    }

    public static Point3D of(int X, int Y, int Z){
        return new Point3D(X, Y, Z);
    }



}
