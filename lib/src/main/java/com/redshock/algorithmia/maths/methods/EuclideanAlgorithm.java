/**
 * @author Thomas Beer
 * Euclidean Algorithm implemention of hcf
 */
package com.redshock.algorithmia.maths.methods;

/**
 * Euclidean Algorithm implemention of hcf
 *
 */
public class EuclideanAlgorithm {

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

    /*
     * test harness
     * should return 2124 then 6
     */
    public static void main(String[] args) {
        int hcf = EuclideanAlgorithm.run(182664, 155052);
        System.out.println("HCF: " + hcf);
        // Outut: 2124
        hcf = EuclideanAlgorithm.run(630, 132);
        System.out.println("HCF: " + hcf);
        // Outut: 6
    }
}
