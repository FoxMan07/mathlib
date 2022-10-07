package com.github.foxman07.mathlib;

import static java.lang.Math.*;

public record ComplexNumber(double x, double y) {

    static double RADIANS_90 = PI/2;
    static double RADIANS_270 = 3*PI/2;
    static double RADIANS_360 = 2*PI;


    public ComplexNumber add(ComplexNumber c) {
        return new ComplexNumber(x+c.x, y+c.y);
    }

    public ComplexNumber subtract(ComplexNumber c) {
        return new ComplexNumber(x-c.x, y-c.y);
    }

    public ComplexNumber multiply(ComplexNumber complexNum) {
        double real = (x * complexNum.x) - (y * complexNum.y);
        double img = (y * complexNum.x) + (x * complexNum.y);

        return new ComplexNumber(real, img);
    }

    public ComplexNumber power(int positiveInt) {
        ComplexNumber result = this;
        for(int i=1; i<positiveInt; i++) {
            result = result.multiply(this);
        }
        return result;
    }

    public ComplexNumber divide(ComplexNumber complexNum) {
        double realNumerator = (x * complexNum.x) + (y * complexNum.y);
        double imgNumerator = (y * complexNum.x) + (x * complexNum.y);
        double denominator = (complexNum.x * complexNum.x) + (complexNum.y * complexNum.y);

        return new ComplexNumber(realNumerator / denominator, imgNumerator / denominator);
    }

    public double magnitude() {
        return Math.sqrt((x*x) + (y*y));
    }

    public double angle() {

        if(y==0) { //on x axis
            return x>=0 ? 0: PI;
        }

        if(x==0) { //on y axis
            return y>=0 ? RADIANS_90 : RADIANS_270;
        }

        double radians = Math.atan(y/x);

        if(firstQuadrant()) {
            return radians;
        }

        if(secondQuadrant() || thirdQuadrant()) {
            return PI + radians;
        }

        //Q4
        return (RADIANS_360 + radians);//%RADIANS_360;

    }

    public Polar polar() {
        return new Polar(magnitude(),angle());
    }

    private boolean firstQuadrant() {
        return x>=0 && y>=0;
    }

    private boolean secondQuadrant() {
        return x<0 && y>=0;
    }

    private boolean thirdQuadrant() {
        return x<0 && y<0;
    }

    @Override
    public String toString() {
        String x1 = String.format("%.2f", x);
        String y1 = String.format("%.2f",  Math.abs(y));

        String sign  = y<0.0 ? " - " : " + ";
        String yVal =  y == 1? "" : y1+"";
        return "( " + x1 + sign + yVal+ "i )";
    }

    public record Polar(double magnitude, double angle) {

        public Polar {
            angle = angle % RADIANS_360;
        }

        @Override
        public String toString() {
            double degree = Math.round(angle*180/PI);
            return "(|" + magnitude + "| , " + degree+")" ;
        }

        public Polar multiply(Polar other) {
            double a = angle + other.angle();
            //a = a % RADIANS_360;

            return new Polar( magnitude * other.magnitude,a);
        }

        public Polar power(int positiveInt) {
            Polar result = this;
            for(int i=1; i<positiveInt; i++) {
                result = result.multiply(this);
            }
            return result;
        }

        public double real() {
            return  magnitude * cos(angle);
        }

        public double imaginary() {
            return  magnitude * sin(angle);
        }

        public ComplexNumber cartesian() {
            return new ComplexNumber(real(),imaginary());
        }
    }
}
