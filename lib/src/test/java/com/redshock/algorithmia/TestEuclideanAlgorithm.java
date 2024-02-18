package com.redshock.algorithmia;

import com.redshock.algorithmia.maths.methods.EuclideanAlgorithm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEuclideanAlgorithm {
    @BeforeAll
    static void start() {
        System.out.println("Starting tests on " + TestEuclideanAlgorithm.class.getName() + " ...");
    }

    @AfterAll
    static void end() {
        System.out.println("Tests on " + TestEuclideanAlgorithm.class.getName() + " have ended.");
    }

    @Test
    public void testInteger1(){
        int hcf = EuclideanAlgorithm.run(630, 132);
        assertEquals(6, hcf);
    }

    @Test
    public void testInteger2(){
        int hcf = EuclideanAlgorithm.run(182664, 155052);
        assertEquals(2124, hcf);
    }

    @Test
    public void testNoRemainder(){
        int hcf = EuclideanAlgorithm.run(100, 50);
        assertEquals(50, hcf);
    }
}
