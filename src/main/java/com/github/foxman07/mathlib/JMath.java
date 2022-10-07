package com.github.foxman07.mathlib;

import static java.lang.Math.*;

public class JMath {

    public static ComplexNumber [] nthRootOfm(double n, double m) {
        int size = (int)Math.ceil(n);
        ComplexNumber[] result = new ComplexNumber[size];
        double magnitude = Math.pow(m,1d/n);
        double angle = 360/n;
        double currentAngle = 0;
        result[0] = new ComplexNumber(magnitude,0);

        for(int i=1; i<result.length; i++) {
            currentAngle += angle;
            ComplexNumber.Polar p = new ComplexNumber.Polar(magnitude,currentAngle*PI/180);
            result[i] = p.cartesian();
        }

        return result;
    }

}
