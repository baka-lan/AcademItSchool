package ru.academits.bakalan.shapes.classes;

import ru.academits.bakalan.shapes.interfaces.Shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double a;
    private double b;
    private double c;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        this.b = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));
        this.c = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));
    }

    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        double semiPerimeter = (a + b + c) / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle (x1: " + x1 + ", y1: " + y1 + ", x2: " + x2 + ", y2: " + y2 + ", x3: " + x3 + ", y3: " + y3 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || o.getClass() != this.getClass()) {
            return false;
        }
        Triangle p = (Triangle) o;
        return (x1 == p.x1 && y1 == p.y1 && x2 == p.x2 && y2 == p.y2 && x3 == p.x3 && y3 == p.y3);
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime*hash + Double.hashCode(x1);
        hash = prime*hash + Double.hashCode(y1);
        hash = prime*hash + Double.hashCode(x2);
        hash = prime*hash + Double.hashCode(y2);
        hash = prime*hash + Double.hashCode(x3);
        hash = prime*hash + Double.hashCode(y3);
        return hash;
    }
}