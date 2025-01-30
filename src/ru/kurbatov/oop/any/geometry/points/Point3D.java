package ru.kurbatov.oop.any.geometry.points;

import ru.kurbatov.oop.any.geometry.Coordinate;

import java.util.Objects;

public class Point3D extends Point2D{

    private int Z;

    protected Point3D(int X, int Y, int Z){
        super(X, Y);
        setZ(Z);
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int z) {
        this.Z = z;
    }

    @Override
    public String toString() {
        return "{" + X + ";" + Y + ";" + Z + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Point3D p = (Point3D)obj;
        if (X == p.X &&
            Y == p.Y &&
            Z == p.Z) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, Z);
    }

    @Override
    public Point3D clone() throws CloneNotSupportedException {
        return (Point3D)super.clone();
    }

    @Override
    public void shift(Coordinate coord, int shift) {
        super.shift(coord, shift);
        if (coord == Coordinate.Z)
            this.Z += shift;
    }
}
