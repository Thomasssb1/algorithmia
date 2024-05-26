package com.redshock.algorithmia.maths;

/**
 * Holds the general and particular solution of a solved linear diophantine equation
 */
public class Solution {
    /** general solution of the given linear diophantine equation */
    private General general;
    /** particular solution of the given linear diophantine equation */
    private Particular particular;

    /**
     * @param x unknown variable x
     * @param y unknown variable y
     * @param factor factor to multiply the particular solution (c/h provided h is a factor of c)
     */
    public Solution(int x,  int y, int a, int b, int factor) {
        // temporary
        this.general = new General(x, y, a, b, factor);
        this.particular = new Particular(x * factor, y * factor);
    }

    @Override
    public String toString() {
        return "General: " + general + " Particular: " + particular;
    }

    @Override
    public boolean equals(Object obj) {
        Solution solution = (Solution) obj;
        return general == solution.general && particular.equals(solution.particular);
    }
    public General getGeneral() {
        return general;
    }

    public Particular getParticular() {
        return particular;
    }
}
