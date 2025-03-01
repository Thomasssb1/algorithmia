package com.redshock.algorithmia.maths;

public class General {
    private int x;
    private int y;
    private int a;
    private int b;
    private int factor;

    public General(int x, int y, int a, int b, int factor) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
        this.factor = factor;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getA() {
        return a;
    }

    int getB() {
        return b;
    }

    int getFactor() {
        return factor;
    }

    public int substituteK(int k, boolean isX) {
        return isX ? x + b/factor * k : y - a/factor * k;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        General general = (General) obj;
        return this.getX() == general.getX() &&
                this.getY() == general.getY() &&
                this.getA() == general.getA() &&
                this.getB() == general.getB() &&
                this.getFactor() == general.getFactor();
    }

    @Override
    public String toString() {
        // need to handle negative values
        return "x = " + x + " + " + b/factor + "k\n" + "y = " + y + " - " + a/factor + "k";
    }
}
