package ru.kurbatov.oop.any.geometry.points;

import ru.kurbatov.oop.any.geometry.Coordinate;
import ru.kurbatov.oop.any.geometry.Shiftable;

import java.util.Objects;

public class Point2D implements Cloneable, Shiftable {
    protected int X;
    protected int Y;

    protected Point2D(int X, int Y){
        this.X = X;
        this.Y = Y;
    }

    public void setXY(int X, int Y){
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString(){
        return  "{" + X + ";" + Y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Point2D p = (Point2D)obj;
        if (X == p.X && Y == p.Y) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public Point2D clone() throws CloneNotSupportedException {
        return (Point2D)super.clone();
    }

    @Override
    public void shift(Coordinate coord, int shift) {
        if (coord == Coordinate.X)
            this.X += shift;
        if (coord == Coordinate.Y)
            this.Y += shift;
    }
}
