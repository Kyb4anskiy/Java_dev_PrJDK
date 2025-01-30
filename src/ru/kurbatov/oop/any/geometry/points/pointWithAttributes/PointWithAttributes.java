package ru.kurbatov.oop.any.geometry.points.pointWithAttributes;

import ru.kurbatov.oop.any.geometry.points.Point2D;

import java.util.ArrayList;
import java.util.List;

public class PointWithAttributes {

    private Point2D X;
    private List<Attribute> attributes;

    public PointWithAttributes(Point2D X, List<Attribute> attributes){
        this.X = X;
        setAttributes(attributes);
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = new ArrayList<>();
        addAttributes(attributes);
    }

    public void addAttributes(List<Attribute> attributes){
        for (int i = 0; i < attributes.size(); i++){
            addAttribute(attributes.get(i));
        }
    }

    public void addAttribute(Attribute newAttribute){
        for (int i = 0; i < attributes.size(); i++){
            Attribute attribute = attributes.get(i);
            if (attribute.getName() == newAttribute.getName()) throw new IllegalArgumentException("The attribute is already there");
        }

        attributes.add(newAttribute);
    }

    @Override
    public String toString() {
        return "Point with attributes: " + attributes;
    }
}
