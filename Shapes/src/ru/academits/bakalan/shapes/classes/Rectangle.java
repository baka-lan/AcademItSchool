package ru.academits.bakalan.shapes.classes;

import ru.academits.bakalan.shapes.interfaces.Shape;

public class Rectangle implements Shape {
    private double side1Length;
    private double side2Length;

    public Rectangle(double width, double height) {
        this.side1Length = width;
        this.side2Length = height;
    }

    @Override
    public double getWidth() {
        return side1Length;
    }

    @Override
    public double getHeight() {
        return side2Length;
    }

    @Override
    public double getArea() {
        return side1Length * side2Length;
    }

    @Override
    public double getPerimeter() {
        return (side1Length + side2Length) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle (width: " + side1Length + ", height: " + side2Length + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || o.getClass() != this.getClass()) {
            return false;
        }
        Rectangle p = (Rectangle) o;
        return side1Length == p.side1Length && side2Length == p.side2Length;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = prime * hash + Double.hashCode(side1Length);
        hash = prime * hash + Double.hashCode(side2Length);
        return hash;
    }
}