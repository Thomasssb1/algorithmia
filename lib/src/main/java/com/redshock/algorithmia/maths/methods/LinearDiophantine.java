package com.redshock.algorithmia.maths.methods;

import com.redshock.algorithmia.exceptions.NonZeroError;
import com.redshock.algorithmia.exceptions.NoPossibleSolutionError;

import java.util.HashMap;

/**
 * Linear diophantine equation implementation in the form
 * ax + by = c
 */
public class LinearDiophantine {
    private int a, b, c;

    public LinearDiophantine(int a, int b, int c) throws NonZeroError {
        if (a == 0 && b == 0){
            throw new NonZeroError("a and b cannot be zero");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

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
    
    public void update(int a, int b, int c) throws NonZeroError {
        if (a == 0 && b == 0){
            throw new NonZeroError("a and b cannot be zero");
        }
        this.a = a; this.b = b; this.c = c;
    }


    public HashMap<String, Integer> solve() throws NoPossibleSolutionError {
        int hcf = EuclideanAlgorithm.run(a, b);
        // note that it does work if it is a factor of hcf
        if (hcf != c) {
            throw new NoPossibleSolutionError("No possible solution for " + this.toString());
        }
        return EuclideanAlgorithm.extended(a, b);
    }

    public static void main(String[] args){
        try {
            LinearDiophantine test = new LinearDiophantine(630, 132, 6);
            System.out.println(test);
            try {
                HashMap<String, Integer> xy = test.solve();
            } catch (NoPossibleSolutionError e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (NonZeroError e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
