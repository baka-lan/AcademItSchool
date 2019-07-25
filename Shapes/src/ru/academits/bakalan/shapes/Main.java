package ru.academits.bakalan.shapes;

import ru.academits.bakalan.shapes.shapes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static Shape getFirstAreaShape(ArrayList<Shape> shapes) {
        shapes.sort(new SortByArea().reversed());

        return shapes.get(0);
    }

    static Shape getSecondPerimeterShape(ArrayList<Shape> shapes) {
        shapes.sort(new SortByPerimeter().reversed());

        return shapes.get(1);
    }

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(3));
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Square(3));
        shapes.add(new Triangle(0, 0, 0, 3, 3, 0));
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(2, 2));
        shapes.add(new Square(2));
        shapes.add(new Triangle(5, 0, 0, 5, 5, 5));

        System.out.println(getFirstAreaShape(shapes));
        System.out.println(getSecondPerimeterShape(shapes));
    }
}
