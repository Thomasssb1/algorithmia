package com.redshock.algorithmia;

import com.redshock.algorithmia.exceptions.NoPossibleSolutionError;
import com.redshock.algorithmia.exceptions.NonZeroError;
import com.redshock.algorithmia.maths.Solution;
import com.redshock.algorithmia.maths.methods.EuclideanAlgorithm;
import com.redshock.algorithmia.maths.methods.LinearDiophantine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinearDiophantine {
    @BeforeAll
    static void start() {
        System.out.println("Starting tests on " + TestEuclideanAlgorithm.class.getName() + " ...");
    }

    @AfterAll
    static void end() {
        System.out.println("Tests on " + TestEuclideanAlgorithm.class.getName() + " have ended.");
    }

    @Test
    public void testLinearDiophantine1(){
        Solution xy = null;
        try {
            LinearDiophantine test = new LinearDiophantine(630, 132, 6);
            try {
                xy = test.solve();
            } catch (NoPossibleSolutionError e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (NonZeroError e){
            System.out.println("Error: " + e.getMessage());
        } finally {
            int factor = 6 / EuclideanAlgorithm.run(630, 132);
            assertEquals(xy, new Solution(-9, 43, 630, 132, factor));
        }
    }

    @Test
    public void testLinearDiophantineNoSolutions(){
        try {
            LinearDiophantine test = new LinearDiophantine(12, 8, 1);
            NoPossibleSolutionError thrown = assertThrows(NoPossibleSolutionError.class, test::solve);
        } catch (NonZeroError e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void testLinearDiophantineZeroError1(){
        NonZeroError thrown = assertThrows(NonZeroError.class, () -> {
            LinearDiophantine test = new LinearDiophantine(0, 0, 0);
        });
    }

    @Test
    public void testLinearDiophantineZeroError2(){
        NonZeroError thrown = assertThrows(NonZeroError.class, () -> {
            LinearDiophantine test = new LinearDiophantine(0, 0, 1);
        });
    }
}
