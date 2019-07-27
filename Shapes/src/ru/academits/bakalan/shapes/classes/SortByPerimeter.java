package ru.academits.bakalan.shapes.classes;

import ru.academits.bakalan.shapes.interfaces.Shape;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {
public int compare(Shape a, Shape b) {
        return Double.compare(a.getPerimeter(), b.getPerimeter());
        }
}
