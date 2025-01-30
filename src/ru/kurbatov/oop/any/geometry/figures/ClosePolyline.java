package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.points.Point2D;

import java.util.Arrays;
import java.util.List;

public class ClosePolyline extends Polyline{

    public ClosePolyline(List<Point2D> points){ super(points);}

    public ClosePolyline(Point2D... points){ this(Arrays.asList(points)); }

    @Override
    public double getLength(){
        if (points.size() < 3) return super.getLength();
        Line tmpLine = new Line(points.getFirst(), points.getLast());
        return super.getLength() + tmpLine.getLength();
    }

    @Override
    public String toString() {
        return "Замкнутая линия " + points;
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
