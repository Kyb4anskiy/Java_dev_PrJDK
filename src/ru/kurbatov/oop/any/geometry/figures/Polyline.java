package ru.kurbatov.oop.any.geometry.figures;

import ru.kurbatov.oop.any.geometry.points.Point2D;

import java.util.*;

public class Polyline implements LengthCalculable, PolylineCalculable{

    protected List<Point2D> points;

    public Polyline(List<Point2D> points){
        setPoints(points);
    }

    public Polyline(Point2D... points){ this(Arrays.asList(points)); }

    public double getLength(){
        double length = 0;
        for (int i = 0; i < points.size()-1; i++){
            length += new Line(points.get(i),points.get(i+1)).getLength();
        }
        return length;
    }


    public void setPoints(List<Point2D> points) {
        this.points = new ArrayList<Point2D>();
        addPoints(points.toArray(new Point2D[points.size()]));
    }

    public List<Point2D> getPoints() {
        return new ArrayList<>(points);
    }

    public void addPoints(Point2D... points){
        this.points.addAll(Arrays.asList(points));
    }

    public void addPoints(List<Point2D> points){
        this.points.addAll(points);
    }

    public void replacePoint(int index, Point2D newPoint){
        if (0 > index || index > points.size() - 1) throw new ArrayIndexOutOfBoundsException();
        points.set(index, newPoint);
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(points);
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }

    private List<Point2D> ifIsClosePolyline(Polyline p, List<Point2D> lst){
        List<Point2D> newList = new ArrayList<>(lst);

        if (p instanceof ClosePolyline) newList.add(lst.getFirst());
        return newList;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Polyline p)) return false;

        List<Point2D> lstThis = ifIsClosePolyline(this, points);
        List<Point2D> lstObj = ifIsClosePolyline(p, p.points);
        List<Point2D> lstRev = new ArrayList<>(lstObj);
        Collections.reverse(lstRev);

        return Objects.equals(lstThis, lstObj) || Objects.equals(lstThis, lstRev);
    }

    @Override
    public int hashCode() {
        List<Point2D> lst = ifIsClosePolyline(this, points);
        int hashCode = 0;
        for (Point2D p : lst) {
            hashCode += p.hashCode();
        }
        return hashCode;
    }
}
