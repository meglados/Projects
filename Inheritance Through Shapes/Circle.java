/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 3
 *
 *  File Name:	Circle.java
 */

/**
  * Creates and checks conditions for the Circle object
  *
  */

public class Circle extends AbstractShape {
    private double myRadius;
    private static int myID = 0;

    public Circle() {
        this(1.0);
    }
    
/**
  * Creates and ensure the radius is >0
  *
  */   
    public Circle(final double theRadius) {
        super("Circle", ++myID);
        if (theRadius <= 0) {
            myID--; // if not >0, decrement id #
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a circle radius."); // if radius <= 0
        }
        myRadius = theRadius; // if not, assigns myRadius
    }

/**
  * Checks if radius is >0, assigns myRadius
  *
  */
    public void setRadius(final double theRadius) {
        if (theRadius <= 0) {
            myID--; // if not >0, decrement id #
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a circle radius.");
        }
        myRadius = theRadius;
    }

    @Override
    public double calculateArea() { // overridden to calculate the area of a circle
        return Math.PI * myRadius * myRadius;
    }

    @Override
    public final Shape copyShape() {
        Circle newC = new Circle();
        newC.myRadius = myRadius;
        return newC;
    }

    @Override
    public String toString() {
        return getName() + " [Radius: " + myRadius + "] Area: " + String.format("%.2f", calculateArea());
    }
}
