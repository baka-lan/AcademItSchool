package ru.academits.bakalan.vector.main;

import ru.academits.bakalan.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(2);
        System.out.println("v1: " + v1);

        Vector v2 = new Vector(v1);
        System.out.println("v2: " + v2);

        Vector v3 = new Vector(new double[]{1, 2, 3, 4, 5});
        System.out.println("v3: " + v3);

        Vector v4 = new Vector(1, v3.getComponents());
        System.out.println("v4: " + v4);

        Vector v5 = new Vector(7, v3.getComponents());
        System.out.println("v5: " + v5);

        System.out.println();
        v3.plus(v4);
        System.out.println("v3 + v4");
        System.out.println("v3: " + v3);
        v4.plus(v3);
        System.out.println("v4 + v3");
        System.out.println("v4: " + v4);

        System.out.println();
        v4.minus(v3);
        System.out.println("v4 - v3");
        System.out.println("v4: " + v4);
        v2.minus(v3);
        System.out.println("v2 - v3");
        System.out.println("v2: " + v2);
        v3.minus(v4);
        System.out.println("v3 - v4");
        System.out.println("v3: " + v3);

        System.out.println();
        v2.multiplyToNumber(2);
        System.out.println("v2 * 2");
        System.out.println("v2: " + v2);
        v2.invert();
        System.out.println("invert v2");
        System.out.println("v2: " + v2);
    }
}
