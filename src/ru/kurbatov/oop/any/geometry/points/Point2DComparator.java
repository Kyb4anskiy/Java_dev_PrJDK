package ru.kurbatov.oop.any.geometry.points;

import java.util.Comparator;

public class Point2DComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        if (o1.X == o2.X) return o1.Y - o2.Y;
        return  o1.X - o2.X;
    }
}
