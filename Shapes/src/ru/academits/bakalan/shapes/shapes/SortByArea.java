package ru.academits.bakalan.shapes.shapes;

import java.util.Comparator;

public class SortByArea implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getArea(), b.getArea());
    }
}
