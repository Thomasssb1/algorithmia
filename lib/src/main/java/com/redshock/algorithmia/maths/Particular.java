package com.redshock.algorithmia.maths;


/**
 * Holds the particular solution a solved linear diophantine equation
 * The particular solution is the solution
 * x = cs/h and y = ct/h
 * where, as + bt = h, where h = hcf(a,b)
 */
public class Particular {

    private int x, y;

    /**
     * Holds the particular solution a solved linear diophantine equation
     * The particular solution is the solution
     * x = cs/h and y = ct/h
     * where, as + bt = h, where h = hcf(a,b)
     * @param x - x value of the particular solution
     * @param y - y value of the particular solution
     */
    public Particular(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Particular particular = (Particular) obj;
        return this.getX() == particular.getX() &&
                this.getY() == particular.getY();
    }

    /**
     * prints in the format x = x, y = y
     */
    @Override
    public String toString() {
        return "x = " + x + ", y =  " + y;
    }
}
