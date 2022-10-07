package com.github.foxman07.mathlib;

import com.github.foxman07.mathlib.ComplexNumber.Polar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class TestComplexNumber {

    double one_by_root2 = 1.0/sqrt(2);
    double root3_by_2 = sqrt(3)/2;
    double delta = 0.000000001;
    double toDegree = 180/PI;

    //Q1
    ComplexNumber cn_unit_circle_angle_0 = new ComplexNumber(1d, 0);
    ComplexNumber cn_unit_circle_angle_30 = new ComplexNumber(root3_by_2, 0.5);
    ComplexNumber cn_unit_circle_angle_45 = new ComplexNumber(one_by_root2, one_by_root2);
    ComplexNumber cn_unit_circle_angle_60 = new ComplexNumber(0.5, root3_by_2);
    ComplexNumber cn_unit_circle_angle_90 = new ComplexNumber(0, 1d);

    //Q2
    ComplexNumber cn_unit_circle_angle_120 = new ComplexNumber(-0.5, root3_by_2);
    ComplexNumber cn_unit_circle_angle_135 = new ComplexNumber(-one_by_root2, one_by_root2);
    ComplexNumber cn_unit_circle_angle_150 = new ComplexNumber(-root3_by_2, 0.5);
    ComplexNumber cn_unit_circle_angle_180 = new ComplexNumber(-1d, 0d);

    //Q3
    ComplexNumber cn_unit_circle_angle_210 = new ComplexNumber(-root3_by_2, -0.5);
    ComplexNumber cn_unit_circle_angle_225 = new ComplexNumber(-one_by_root2, -one_by_root2);
    ComplexNumber cn_unit_circle_angle_240 = new ComplexNumber(-0.5, -root3_by_2);
    ComplexNumber cn_unit_circle_angle_270 = new ComplexNumber(0d, -1d);

    //Q3
    ComplexNumber cn_unit_circle_angle_300 = new ComplexNumber(0.5, -root3_by_2);
    ComplexNumber cn_unit_circle_angle_315 = new ComplexNumber(one_by_root2, -one_by_root2);
    ComplexNumber cn_unit_circle_angle_330 = new ComplexNumber(root3_by_2, -0.5);
    ComplexNumber cn_unit_circle_angle_360 = new ComplexNumber(1d, 0d);



    @Test
    public void shouldCalculateCorrectAngleForUnitCircle() {

        Assertions.assertEquals(0,cn_unit_circle_angle_0.angle()*toDegree);
        Assertions.assertEquals(30,cn_unit_circle_angle_30.angle()*toDegree,delta);
        Assertions.assertEquals(45,cn_unit_circle_angle_45.angle()*toDegree);
        Assertions.assertEquals(60,cn_unit_circle_angle_60.angle()*toDegree,delta);
        Assertions.assertEquals(90,cn_unit_circle_angle_90.angle()*toDegree);
        Assertions.assertEquals(120,cn_unit_circle_angle_120.angle()*toDegree,delta);
        Assertions.assertEquals(135,cn_unit_circle_angle_135.angle()*toDegree);
        Assertions.assertEquals(150,cn_unit_circle_angle_150.angle()*toDegree,delta);
        Assertions.assertEquals(180,cn_unit_circle_angle_180.angle()*toDegree);
        Assertions.assertEquals(210,cn_unit_circle_angle_210.angle()*toDegree,delta);
        Assertions.assertEquals(225,cn_unit_circle_angle_225.angle()*toDegree);
        Assertions.assertEquals(240,cn_unit_circle_angle_240.angle()*toDegree,delta);
        Assertions.assertEquals(270,cn_unit_circle_angle_270.angle()*toDegree);
        Assertions.assertEquals(300,cn_unit_circle_angle_300.angle()*toDegree);
        Assertions.assertEquals(315,cn_unit_circle_angle_315.angle()*toDegree);
        Assertions.assertEquals(330,cn_unit_circle_angle_330.angle()*toDegree);
        Assertions.assertEquals(0,cn_unit_circle_angle_360.angle()*toDegree);
    }

    @Test
    public void shouldCalculateCorrectMagnitudeForUnitCircle() {

        Assertions.assertEquals(1,cn_unit_circle_angle_0.magnitude());
        Assertions.assertEquals(1,cn_unit_circle_angle_45.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_90.magnitude());
        Assertions.assertEquals(1,cn_unit_circle_angle_120.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_135.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_150.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_180.magnitude());
        Assertions.assertEquals(1,cn_unit_circle_angle_210.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_225.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_240.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_270.magnitude());
        Assertions.assertEquals(1,cn_unit_circle_angle_300.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_315.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_330.magnitude(),delta);
        Assertions.assertEquals(1,cn_unit_circle_angle_360.magnitude());

    }

    @Test
    public void testUnitCircleMultiplicationInCartesianForm() {

        //30 X 60 in unitCircle = 90
        ComplexNumber product = cn_unit_circle_angle_30.multiply(cn_unit_circle_angle_60);
        Assertions.assertEquals(cn_unit_circle_angle_90.x(),product.x());
        Assertions.assertEquals(cn_unit_circle_angle_90.y(),product.y(),delta);

        //60 X 90 in unitCircle = 150
        product = cn_unit_circle_angle_60.multiply(cn_unit_circle_angle_90);
        Assertions.assertEquals(cn_unit_circle_angle_150.x(),product.x());
        Assertions.assertEquals(cn_unit_circle_angle_150.y(),product.y());
    }


    @Test
    public void testUnitCircleMultiplicationInPolarForm() {

        //30 X 60 in unitCircle = 90
        Polar product = cn_unit_circle_angle_30.polar().multiply(cn_unit_circle_angle_60.polar());
        Assertions.assertEquals(90, product.angle()* toDegree);
        Assertions.assertEquals(1, product.magnitude(),delta);

        //60 X 90 in unitCircle = 150
        product = cn_unit_circle_angle_60.polar().multiply(cn_unit_circle_angle_90.polar());
        Assertions.assertEquals(150, product.angle()* toDegree,delta);
        Assertions.assertEquals(1, product.magnitude(),delta);
    }

    @Test
    public void testMultiplicationInCartesianForm() {

        ComplexNumber c1 = new ComplexNumber(3,4);
        ComplexNumber c2 = new ComplexNumber(4,3);
        ComplexNumber c3 = c1.multiply(c2);

        Assertions.assertEquals(c1.magnitude()*c2.magnitude(), c3.magnitude());
        Assertions.assertEquals(c1.angle() + c2.angle(), c3.angle());
    }

    @Test
    public void testMultiplicationInPolarForm() {

        ComplexNumber c1 = new ComplexNumber(3,4);
        ComplexNumber c2 = new ComplexNumber(4,3);
        Polar c3 = c1.polar().multiply(c2.polar());

        Assertions.assertEquals(c1.magnitude()*c2.magnitude(), c3.magnitude());
        Assertions.assertEquals(c1.angle() + c2.angle(), c3.angle());
    }

    @Test
    public void testComplexNumberAtOrigin() {
        ComplexNumber origin = new ComplexNumber(0, 0);
        Assertions.assertEquals(0, origin.magnitude());
        Assertions.assertEquals(0,origin.angle());
    }

}
