package com.redshock.algorithmia.maths;

/**
 * Holds the particular solution a solved linear diophantine equation
 * The particular solution is the solution
 * x = cs/h and y = ct/h
 * where, as + bt = h, where h = hcf(a,b)
 * @param x x value of the particular solution
 * @param y y value of the particular solution
 */
public record Particular(int x, int y) {

    /**
     * prints in the format x = x, y = y
     */
    @Override
    public String toString() {
        return "x = " + x + ", y =  " + y;
    }
}
