/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 3
 *
 *  File Name:	AbstractShape.java
 */

/**
  * Implements the shape interface for use of shape subclasses
  *
  */

public abstract class AbstractShape implements Shape {
    private String name; // cur name of the passed shape

    public AbstractShape(String name, int id) {
        this.name = name + id; //creates shape name and id
    }

    @Override
    public String getName() { //returns constructed shape name
        return this.name;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.calculateArea(), other.calculateArea());
    }
}
