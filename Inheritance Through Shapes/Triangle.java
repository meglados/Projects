/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 3
 *
 *  File Name:	Triangle.java
 */

/**
  * Creates and checks conditions for the Triangle object
  *
  */

public class Triangle extends AbstractShape {
    private double mySideA, mySideB, mySideC;
    private static int myID = 0;

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

/**
  * ensures that the width is not <=0, then assigns the value to myWidth
  *
  */
    public Triangle(double theSideA, double theSideB, double theSideC) {
        super("Triangle", ++myID);
        if (theSideA <= 0 || theSideB <= 0 || theSideC <= 0 || (theSideA + theSideB <= theSideC) || (theSideB + theSideC <= theSideA) || (theSideC + theSideA <= theSideB)) {
            myID--; // if not >0, decrement id #
            throw new IllegalArgumentException("ERROR! Not a Triangle. Longest side too long.");
        }
        mySideA = theSideA;
        mySideB = theSideB;
        mySideC = theSideC;
    }

/**
  * ensures that the setSideA is not <=0, then assigns the value to mySideA
  *
  */
    public void setSideA(double theSideA) {
        if (theSideA <= 0) { // ensures value is >0
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a triangle side.");
        }
        mySideA = theSideA;
    }

/**
  * ensures that the setSideB is not <=0, then assigns the value to mySideB
  *
  */
    public void setSideB(double theSideB) {
        if (theSideB <= 0) { // ensures value is >0

            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a triangle side.");
        }
        mySideB = theSideB;
    }

/**
  * ensures that the setSideC is not <=0, then assigns the value to mySideC
  *
  */
    public void setSideC(double theSideC) {
        if (theSideC <= 0) { // ensures value is >0
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a triangle side.");
        }
        mySideC = theSideC;
    }

    @Override
    public double calculateArea() { //override to calculate the area of a triangle
        double s = (mySideA + mySideB + mySideC) / 2;
        return Math.sqrt(s * (s - mySideA) * (s - mySideB) * (s - mySideC));
    }

    @Override
    public Shape copyShape() {
        return new Triangle(mySideA, mySideB, mySideC);
    }

    @Override
    public String toString() {
        return getName() + " [SideA: " + mySideA + ", SideB: " + mySideB + ", SideC: " + mySideC + "] Area: " + String.format("%.2f", calculateArea());
    }
}
