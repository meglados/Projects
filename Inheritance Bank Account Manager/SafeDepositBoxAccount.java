/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 2
 *
 *  File Name:	SafeDepositBoxAccount.java
 */

/**
  * Through the implementation of NamedAccount, this class accesses, returns, and sets 
  * the account holders name.
  *
  */
public class SafeDepositBoxAccount implements NamedAccount {
    private String myAccountHolderName;

  /**
    * Sets theOwnerName to the current myAccountHolderName value
    *
    */
    public SafeDepositBoxAccount(final String theOwnerName) {
        myAccountHolderName = theOwnerName;
    }

  /**
    * Returns the current value of the myAccountHolderName
    *
    */
    @Override
    public String getAccountHolderName() {
        return myAccountHolderName;
    }

  /**
    * Sets myAccountHolderName to another value
    *
    */
    @Override
    public void setAccountHolderName(final String theNewName) {
        myAccountHolderName = theNewName;
    }

  /**
    * toString to format the print return properly
    *
    */
    @Override
    public String toString() {
        return String.format("SafeDepositBoxAccount[owner: %s]", myAccountHolderName);
    }
}
 
 
 