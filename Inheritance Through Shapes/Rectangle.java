/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 3
 *
 *  File Name:	Rectangle.java
 */

/**
  * Creates and checks conditions for the Rectangle object
  *
  */

public class Rectangle extends AbstractShape {
    private double myLength, myWidth;
    private static int myID = 0;

    public Rectangle() {
        this(1.0, 1.0);
    }

/**
  * Creates and checks conditions for the Rectangle object
  *
  */
    public Rectangle(double theLength, double theWidth) {
        super("Rectangle", ++myID);
        if (theLength <= 0 || theWidth <= 0) {
            myID--;
            throw new IllegalArgumentException("ERROR! Negative or 0 value(s) can't be applied to a rectangle.");
        }
        myLength = theLength;
        myWidth = theWidth;
    }

/**
  * ensures that the length is not <=0, then assigns the value to myLength
  *
  */
    public void setLength(final double theLength) {
        if (theLength <= 0) {
            myID--; // if not >0, decrement id #
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle length.");
        }
        myLength = theLength;
    }

/**
  * ensures that the width is not <=0, then assigns the value to myWidth
  *
  */
    public void setWidth(final double theWidth) {
        if (theWidth <= 0) {
            myID--; // if not >0, decrement id #
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle width.");
        }
        myWidth = theWidth;
    }

    @Override
    public double calculateArea() { //override to calculate the area of a rectangle
        return myLength * myWidth;
    }

    @Override
    public Shape copyShape() {
        return new Rectangle(myLength, myWidth);
    }

    @Override
    public String toString() {
        return getName() + " [Length: " + myLength + ", Width: " + myWidth + "] Area: " + String.format("%.2f", calculateArea());
    }
}
