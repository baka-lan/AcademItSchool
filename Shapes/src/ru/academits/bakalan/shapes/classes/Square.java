package ru.academits.bakalan.shapes.classes;

import ru.academits.bakalan.shapes.interfaces.Shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Square (sideLength: " + sideLength + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || o.getClass() != this.getClass()) {
            return false;
        }
        Square p = (Square) o;
        return sideLength == p.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }
}