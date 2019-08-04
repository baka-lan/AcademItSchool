package ru.academits.bakalan.shapes.main;

import ru.academits.bakalan.shapes.interfaces.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getPerimeter(), b.getPerimeter());
    }
}
