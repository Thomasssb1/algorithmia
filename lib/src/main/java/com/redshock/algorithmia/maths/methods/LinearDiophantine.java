package com.redshock.algorithmia.maths.methods;

import com.redshock.algorithmia.exceptions.NonZeroError;
import com.redshock.algorithmia.exceptions.NoPossibleSolutionError;
import com.redshock.algorithmia.maths.Solution;

import java.util.HashMap;

/**
 * Linear diophantine equation implementation in the form
 * ax + by = c
 */
public class LinearDiophantine {
    /** variable for ax + by = c */
    private int a, b, c;

    /**
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer result of ax + by
     * @throws NonZeroError if a and b are both zero
     */
    public LinearDiophantine(int a, int b, int c) throws NonZeroError {
        if (a == 0 && b == 0){
            throw new NonZeroError("a and b cannot be zero");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /** prints in the format ax + by = c */
    @Override
    public String toString() {
        return a + "x + " + b + "y = " + c;
    }


    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public int getC() {
        return c;
    }

    /**
     * @param a first integer
     * @param b second integer
     * @param c third integer result of ax + by
     * @throws NonZeroError if a and b are both zero
     */
    public void update(int a, int b, int c) throws NonZeroError {
        if (a == 0 && b == 0){
            throw new NonZeroError("a and b cannot be zero");
        }
        this.a = a; this.b = b; this.c = c;
    }

    /**
     * Solve the linear diophantine equation to find the unknown variables x and y
     * @return the general and particular solution to the linear diophantine equation x and y
     * @throws NoPossibleSolutionError if there are no possible integer solutions
     */
    public Solution solve() throws NoPossibleSolutionError {
        int hcf = EuclideanAlgorithm.run(a, b);
        // note that it does work if it is a factor of hcf
        if (c % hcf != 0) {
            throw new NoPossibleSolutionError("No possible integer solutions for " + this);
        }
        int factor = c / hcf;
        HashMap<String, Integer> xy = EuclideanAlgorithm.extended(a, b);
        return new Solution(
                xy.get("x"), xy.get("y"), a, b, factor
        );
    }

    public static void main(String[] args){
        try {
            LinearDiophantine test = new LinearDiophantine(630, 132, 6);
            System.out.println(test);
            try {
                Solution xy = test.solve();
                System.out.println(xy);
            } catch (NoPossibleSolutionError e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (NonZeroError e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
