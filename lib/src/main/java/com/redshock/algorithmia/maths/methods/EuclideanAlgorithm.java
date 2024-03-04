/**
 * @author Thomas Beer
 * Euclidean Algorithm implemention of hcf
 */
package com.redshock.algorithmia.maths.methods;

import java.util.HashMap;

/**
 * Euclidean Algorithm implementation of hcf
 *
 */
public abstract class EuclideanAlgorithm {

    /**
     * Run Euclidean Algorithm to find the hcf of a and b
     *
     * @param a first integer
     * @param b second integer
     * @return highest common factor of a and b
     */
    public static int run(int a, int b) {
        while (b != 0) {
            int last_b = b;
            b = a % b;
            a = last_b;
        }
        return a;
    }

    /**
     * Run Extended Euclidean Algorithm to find x and y for hcf(a,b) = ax + by
     * @param a first integer
     * @param b second integer
     * @return array of x and y
     */
    public static HashMap<String, Integer> extended(int a, int b) {
        HashMap<String, Integer> result = new HashMap<>(2);

        int s1 = 1, s2 = 0, s3 = 1;
        int t1 = 0, t2 = 1;
        while (a % b != 0) {
            int last_a = a;
            a = b;
            b = last_a % b;
            int last_s1 = s1;
            s1 = s2;
            s2 = last_s1 - (last_a / a) * s2;
            int last_t1 = t1;
            t1 = t2;
            t2 = last_t1 - (last_a / a) * t2;
        }
        result.put("x", s2);
        result.put("y", t2);
        return result;
    }

    /*
     * test harness
     * should return 2124 then 6
     */
    public static void main(String[] args) {
        int hcf = EuclideanAlgorithm.run(182664, 155052);
        System.out.println("HCF: " + hcf);
        // Output: 2124
        hcf = EuclideanAlgorithm.run(630, 132);
        System.out.println("HCF: " + hcf);
        // Output: 6
    }
}
