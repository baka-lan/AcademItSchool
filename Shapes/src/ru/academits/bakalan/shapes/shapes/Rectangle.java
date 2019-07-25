package ru.academits.bakalan.shapes.shapes;

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
        return "Rectangle (sideLength1 = " + sideLength1 + "; sideLength2 = " + sideLength2 + ")";
    }
}