package ru.academits.bakalan.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public Vector(double[] components) {
        if (components.length < 1) {
            throw new IllegalArgumentException("double[].length must be > 0");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        if (components.length < 1) {
            throw new IllegalArgumentException("double[].length must be > 0");
        }

        this.components = Arrays.copyOf(components, n);
    }

    public int getSize() {
        return components.length;
    }

    public double getComponent(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("index must be in range of vector");
        }

        return components[index];
    }

    public void setComponent(int index, double newValue) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("index must be in range of vector");
        }

        components[index] = newValue;
    }

    public double getLength() {
        double sum = 0;
        for (double e:
             components) {
            sum += e * e;
        }
        return Math.sqrt(sum);
    }

    public void plus(Vector v) {
        int n = getSize();
        int vn = v.getSize();

        for (int i = 0; i < (n >= vn ? vn : n); i++) {
            components[i] += v.components[i];
        }
    }

    public void minus(Vector v) {
        int n = getSize();
        int vn = v.getSize();

        for (int i = 0; i < (n >= vn ? vn : n); i++) {
            components[i] -= v.components[i];
        }
    }

    public void multiplyToNumber(double x) {
        int n = getSize();

        for (int i = 0; i < n; i++) {
            components[i] *= x;
        }
    }

    public void invert() {
        multiplyToNumber(-1);
    }

    public static Vector sum(Vector v1, Vector v2) {
        Vector vector = new Vector(Math.max(v1.getSize(), v2.getSize()));

        vector.plus(v1);
        vector.plus(v2);

        return vector;
    }

    public static Vector difference(Vector v1, Vector v2) {
        Vector vector = new Vector(Math.max(v1.getSize(), v2.getSize()));

        vector.plus(v1);
        vector.minus(v2);

        return vector;
    }

    public static double dotProduct(Vector v1, Vector v2) {
        double sum = 0;
        int n = Math.min(v1.getSize(), v2.getSize());

        for (int i = 0; i < n; i++) {
            sum += v1.components[i] * v2.components[i];
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        int n = getSize();
        for (int i = 0; i < n; i++) {
            sb.append(components[i]);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.deleteCharAt(sb.lastIndexOf(" "));
        sb.append("}");

        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (getSize() != vector.getSize()) {
            return false;
        }

        int n = getSize();
        for (int i = 0; i < n; i++) {
            if (components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }
}
