package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.Coordinate;
import ru.kurbatov.oop.any.geometry.Shiftable;
import ru.kurbatov.oop.any.geometry.points.Point2D;
import ru.kurbatov.oop.any.geometry.points.Point2DComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line<T extends Point2D> implements LengthCalculable, PolylineCalculable, Cloneable, Shiftable {

    T pointStart;
    T pointEnd;

    public Line(T pointStart, T pointEnd){
        setPointStart(pointStart);
        setPointEnd(pointEnd);
    }

    public T getPointStart() {
        return pointStart;
    }

    public void setPointStart(T pointStart) {
        this.pointStart = pointStart;
    }

    public T getPointEnd() {
        return pointEnd;
    }

    public void setPointEnd(T pointEnd) {
        this.pointEnd = pointEnd;
    }

    @Override
    public double getLength(){
        return Math.sqrt(Math.pow(pointStart.getX() - pointEnd.getX(), 2) + Math.pow(pointStart.getY() - pointEnd.getY(), 2));
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(pointStart, pointEnd);
    }

    @Override
    public String toString(){
        return String.format("Линия от %s до %s", pointStart, pointEnd);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Line l = (Line)obj;
        if (pointStart.equals(l.pointStart) &&
            pointEnd.equals(l.pointEnd) ||
            pointStart.equals(l.pointEnd) &&
            pointEnd.equals(l.pointStart)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        List<Point2D> lst = new ArrayList<>(Arrays.asList(pointStart, pointEnd));
        lst.sort(new Point2DComparator());
        return Objects.hash(lst);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line ln = (Line)super.clone();
        ln.pointStart = this.pointStart.clone();
        ln.pointEnd = this.pointEnd.clone();
        return ln;
    }

    @Override
    public void shift(Coordinate coord, int shift) {
        pointStart.shift(coord,shift);
        pointEnd.shift(coord,shift);
    }
}
