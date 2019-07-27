package ru.academits.bakalan.vector;

public class Vector {
    private int n;
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        this.n = n;
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        n = vector.n;
        components = new double[n];

        System.arraycopy(vector.components, 0, components, 0, n);
    }

    public Vector(double[] components) {
        if (components.length < 1) {
            throw new IllegalArgumentException("double[].length must be > 0");
        }

        n = components.length;
        this.components = new double[n];

        System.arraycopy(components, 0, this.components, 0, n);
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        if (components.length < 1) {
            throw new IllegalArgumentException("double[].length must be > 0");
        }

        this.n = n;
        this.components = new double[n];

        System.arraycopy(components, 0, this.components, 0, Math.min(n, components.length));

        if (n > components.length) {
            for (int i = components.length; i < n; i++) {
                this.components[i] = 0;
            }
        }
    }

    public int getSize() {
        return n;
    }

    private void increaseSize(int newSize) {
        if (newSize <= n) {
            throw new IllegalArgumentException("new size must be larger than old");
        }

        double[] temporaryComponents = new double[n];
        System.arraycopy(components, 0, temporaryComponents, 0, n);

        int marker = n;
        n = newSize;

        components = new double[n];
        System.arraycopy(temporaryComponents, 0, components, 0, marker);
        for (int i = marker; i < n; i++) {
            components[i] = 0;
        }
    }

    public double getComponent(int index) {
        if (index < 0 || index > n) {
            throw new IllegalArgumentException("index must be from zero to vector size");
        }

        return components[index];
    }

    public void setComponent(int index, double newValue) {
        if (index < 0 || index > n) {
            throw new IllegalArgumentException("index must be from zero to vector size");
        }

        components[index] = newValue;
    }

    public double[] getComponents() {
        return components;
    }

    public double getLength() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += components[i] * components[i];
        }
        return Math.sqrt(sum);
    }

    public void plus(Vector v) {
        if (n >= v.n) {
            for (int i = 0; i < v.n; i++) {
                components[i] += v.components[i];
            }
        } else {
            this.increaseSize(v.n);
            for (int i = 0; i < n; i++) {
                components[i] += v.components[i];
            }
        }
    }

    public void minus(Vector v) {
        if (n >= v.n) {
            for (int i = 0; i < v.n; i++) {
                components[i] -= v.components[i];
            }
        } else {
            this.increaseSize(v.n);
            for (int i = 0; i < n; i++) {
                components[i] -= v.components[i];
            }
        }
    }

    public void multiplyToNumber(double x) {
        for (int i = 0; i < n; i++) {
            components[i] *= x;
        }
    }

    public void invert() {
        for (int i = 0; i < n; i++) {
            components[i] *= -1;
        }
    }

    public static Vector sumOfTwoVectors(Vector v1, Vector v2) {
        Vector vector = new Vector(Math.max(v1.n, v2.n));

        if (v1.n >= v2.n) {
            for (int i = 0; i < v2.n; i++) {
                vector.components[i] = v1.components[i] + v2.components[i];
            }
            System.arraycopy(v1.components, v2.n, vector.components, v2.n, v1.n - v2.n);
        } else {
            for (int i = 0; i < v1.n; i++) {
                vector.components[i] = v1.components[i] + v2.components[i];
            }
            System.arraycopy(v2.components, v1.n, vector.components, v1.n, v2.n - v1.n);
        }

        return vector;
    }

    public static Vector differenceOfTwoVectors(Vector v1, Vector v2) {
        Vector vector = new Vector(Math.max(v1.n, v2.n));

        if (v1.n >= v2.n) {
            for (int i = 0; i < v2.n; i++) {
                vector.components[i] = v1.components[i] - v2.components[i];
            }
            System.arraycopy(v1.components, v2.n, vector.components, v2.n, v1.n - v2.n);
        } else {
            for (int i = 0; i < v1.n; i++) {
                vector.components[i] = v1.components[i] + v2.components[i];
            }
            for (int i = v1.n; i < v2.n; i++) {
                vector.components[i] -= v2.components[i];
            }
        }

        return vector;
    }

    public static Vector compositionOfTwoVectors(Vector v1, Vector v2) {
        Vector vector = new Vector(Math.max(v1.n, v2.n));

        for (int i = 0; i < Math.min(v1.n, v2.n); i++) {
            vector.components[i] = v1.components[i] * v2.components[i];
        }

        return vector;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (int i = 0; i < n; i++) {
            sb.append(components[i]);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");

        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;

        for (int i = 0; i < n; i++) {
            hash = prime * hash + Double.hashCode(components[i]);
        }

        return hash;
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

        if (n != vector.n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }
}
