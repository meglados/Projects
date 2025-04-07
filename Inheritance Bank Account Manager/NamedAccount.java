/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 2
 *
 *  File Name:	NamedAccount.java
 */


/**
  * Interface for the changing of names for account holders
  *
  */
public interface NamedAccount {
    public String getAccountHolderName();
    public void setAccountHolderName(final String theNewName);
}



