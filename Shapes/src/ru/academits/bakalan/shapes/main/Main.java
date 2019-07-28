package ru.academits.bakalan.shapes.main;

import ru.academits.bakalan.shapes.classes.*;
import ru.academits.bakalan.shapes.interfaces.Shape;

import java.util.ArrayList;

public class Main {
    private static Shape getFirstAreaShape(ArrayList<Shape> shapes) {
        ArrayList<Shape> s = new ArrayList<>(shapes);

        s.sort(new AreaComparator().reversed());

        return s.get(0);
    }

    private static Shape getSecondPerimeterShape(ArrayList<Shape> shapes) {
        ArrayList<Shape> s = new ArrayList<>(shapes);

        s.sort(new PerimeterComparator().reversed());

        return s.get(1);
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
