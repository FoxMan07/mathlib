package com.github.foxman07.mathlib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;

public class TestJMath {

    static double delta = 0.0000001;

    @Test
    public void testNthRootOfMShouldHaveCorrectAngle() {
        for(int n=1; n<=100; n++) {
            testNthRootOfMShouldHaveCorrectAngle(n);
        }
    }

    private void testNthRootOfMShouldHaveCorrectAngle(int n) {

        int m=1;
        ComplexNumber[] roots =  JMath.nthRootOfm(n,m);
        double angleDiff = 360.0/n;

        double angle = 0;
        for(ComplexNumber root: roots) {
            Assertions.assertEquals(angle, root.angle()*180/Math.PI, delta);
            Assertions.assertEquals(1,root.magnitude(),delta);
            angle +=angleDiff;
        }
    }

    @Test
    public  void testCubeRootOfUnity() {
        ComplexNumber[] roots =  JMath.nthRootOfm(3,1);

        //first root
        Assertions.assertEquals(1,roots[0].x());
        Assertions.assertEquals(0,roots[0].y());

        //second root
        Assertions.assertEquals(-0.5,roots[1].x(), delta);
        Assertions.assertEquals(sqrt(3)/2,roots[1].y(),delta);

        //third root
        Assertions.assertEquals(-0.5,roots[2].x(),delta);
        Assertions.assertEquals(-sqrt(3)/2,roots[2].y(),delta);
    }

    @Test
    public  void testFourthRootOfUnity() {
        ComplexNumber[] roots =  JMath.nthRootOfm(4,1);

        //first root (1 + 0i)
        Assertions.assertEquals(1,roots[0].x());
        Assertions.assertEquals(0,roots[0].y());

        //second root (0 + i)
        Assertions.assertEquals(0,roots[1].x(),delta);
        Assertions.assertEquals(1,roots[1].y());

        //third root (-1 + 0i)
        Assertions.assertEquals(-1,roots[2].x());
        Assertions.assertEquals(0,roots[2].y(),delta);

        //fourth root (0 - i)
        Assertions.assertEquals(0,roots[3].x(),delta);
        Assertions.assertEquals(-1,roots[3].y());
    }

    @Test
    public void multiplyingNthRootNTimesInPolarFormShouldResultOriginalValue() {

        int n=4;
        int m = 16;

        ComplexNumber[] roots = JMath.nthRootOfm(n,m);
        for(ComplexNumber c: roots) {
            ComplexNumber.Polar result = c.polar().power(n);
            Assertions.assertEquals(m,result.magnitude());
            Assertions.assertEquals(0,result.angle());
        }
    }

    @Test
    public void multiplyingNthRootNTimesInCartesianFormShouldResultOriginalValue() {

        int n=4;
        int m = 16;

        ComplexNumber[] roots = JMath.nthRootOfm(n,m);
        for(ComplexNumber c: roots) {
            ComplexNumber result = c.power(n);
            Assertions.assertEquals(m,result.magnitude());
            Assertions.assertEquals(0,result.y(),delta);
        }
    }
}
