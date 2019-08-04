package ru.academits.bakalan.vector.main;

import ru.academits.bakalan.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(2);
        System.out.println("v1: " + v1);
        System.out.println("hashCode: " + v1.hashCode());

        Vector v2 = new Vector(v1);
        System.out.println("v2: " + v2);
        System.out.println("hashCode: " + v2.hashCode());

        double[] components = new double[]{1, 2, 3, 4, 5};
        Vector v3 = new Vector(components);
        System.out.println("v3: " + v3);
        System.out.println("hashCode: " + v3.hashCode());

        Vector v4 = new Vector(1, components);
        System.out.println("v4: " + v4);
        System.out.println("hashCode: " + v4.hashCode());

        Vector v5 = new Vector(7, components);
        System.out.println("v5: " + v5);
        System.out.println("hashCode: " + v5.hashCode());

        System.out.println();
        System.out.println("v1 is equals v2: " + v1.equals(v2));
        System.out.println("v1 is equals v3: " + v1.equals(v3));

        System.out.println();
        for (int i = 0; i < components.length; i++) {
            System.out.println("v3." + i + ": " + v3.getComponent(i));
        }
        v3.setComponent(4, 6);
        System.out.println("now v3.4 = 6");
        System.out.println("v3.4: " + v3.getComponent(4));

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

        System.out.println();
        System.out.println("length of v2: " + v2.getLength());
        System.out.println("size of v2: " + v2.getSize());
        System.out.println("v2 * v3: " + Vector.dotProduct(v2, v3));
        System.out.println("v2 + v3: " + Vector.sum(v2, v3));
        System.out.println("v2 - v3: " + Vector.difference(v2, v3));
        System.out.println("v3 - v2: " + Vector.difference(v3, v2));
    }
}
