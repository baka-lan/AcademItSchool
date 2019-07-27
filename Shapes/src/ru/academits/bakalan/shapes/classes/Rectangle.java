package ru.academits.bakalan.shapes.classes;

import ru.academits.bakalan.shapes.interfaces.Shape;

public class Rectangle implements Shape {
    private double sideLength1;
    private double sideLength2;

    public Rectangle(double sideLength1, double sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    public double getWidth() {
        return Math.max(sideLength1, sideLength2);
    }

    public double getHeight() {
        return Math.min(sideLength1, sideLength2);
    }

    public double getArea() {
        return sideLength1 * sideLength2;
    }

    public double getPerimeter() {
        return (sideLength1 + sideLength2) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle (sideLength1: " + sideLength1 + ", sideLength2: " + sideLength2 + ")";
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
        return sideLength1 == p.sideLength1 && sideLength2 == p.sideLength2;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = prime*hash + Double.hashCode(sideLength1);
        hash = prime*hash + Double.hashCode(sideLength2);
        return hash;
    }
}