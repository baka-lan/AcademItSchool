package ru.academits.bakalan.shapes.main;

import ru.academits.bakalan.shapes.interfaces.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getArea(), b.getArea());
    }
}
