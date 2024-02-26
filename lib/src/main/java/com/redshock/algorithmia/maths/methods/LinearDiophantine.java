package com.redshock.algorithmia.maths.methods;

import com.redshock.algorithmia.exceptions.NonZeroError;

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
}
