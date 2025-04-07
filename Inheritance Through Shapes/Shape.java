/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 3
 *
 *  File Name:	Shape.java
 */

/**
  * Interface with abstract methods for use and implementation of subclasses
  *
  */

public interface Shape extends Comparable<Shape> {
    //abstract methods to be implemented by subclasses
    double calculateArea();
    Shape copyShape();
    String getName();
}
