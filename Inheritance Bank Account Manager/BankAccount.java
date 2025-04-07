/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 2
 *
 *  File Name:	BankAccount.java
 */

/**
  * Represents a basic bank account
  *
  */
public class BankAccount implements NamedAccount {
    //constants
    private static final double MIN_BALANCE = 0.0;
    private static final double INTEREST_DIVISOR = 12.0;

    //fields
    private String myAccountHolderName;
    private double myBalance;
    private double myInterestRate;
    public int myMonthlyWithdrawCount;
    public double myMonthlyServiceCharges;

    /**
     * Constructor to initialize the passed parameters theNameOfOwner, and theInterestRate
     * sets other fields to 0
     *
     */
    public BankAccount(final String theNameOfOwner, final double theInterestRate) {
        myAccountHolderName = theNameOfOwner;
        
        if (theInterestRate >= 0.0) { //if interest rate >= 0.0, assigns to myInterestRate
             myInterestRate = theInterestRate;
        } else { //else catches invalid rates, assigns myInterestRate to 0.0
             myInterestRate = 0.0;
        }
        
        myBalance = 0.0;
        myMonthlyWithdrawCount = 0;
        myMonthlyServiceCharges = 0.0;
    }

  /**
    * Returns the current balance
    */    
    public double getBalance() {
        return myBalance;
    }

  /**
    * Adds the specified amount of money to the calling BankAccount object
    * 
    * If amount is not greater than 0, deposit fails, no changes are made to account
    * balance, returns false.
    */
    public boolean processDeposit(final double theAmount) {
        if (theAmount > 0) {
            myBalance += theAmount;
            return true;
        }
        return false;
    }

  /**
    * Subtracts the specified amount of money from the calling BankAccount object
    * 
    * If amount is not positive, withdrawal fails, no changes are made to account
    * balance, returns false.
    * If it passes, myMonthlyWithdrawCount is incremented
    * 
    */
    public boolean processWithdrawal(final double theAmount) {
        if (theAmount > 0 && theAmount <= myBalance) {
            myBalance -= theAmount;
            myMonthlyWithdrawCount++;
            return true;
        }
        return false;
    }
    
  /**
    * Returns the monthly interest based on the APR
    *
    * APR calculated by: myBalance * (myInterestRate / 12.0)
    *
    */
    public double calculateInterest() {
        return myBalance * myInterestRate / INTEREST_DIVISOR;
    }

  /**
    * Subtracts all the monthly service charges form the balance, adds the monthly accrued interest
    * through a call to calculateInterest() and resets the withdrawal count and service charge amount to 0
    * 
    * Balance cannot be set to anything less than 0, if service charges create negative balance, balance
    * is reset to 0.0
    *
    */
    public void performMonthlyProcess() {
        myBalance -= myMonthlyServiceCharges;
        myBalance += calculateInterest();
        if (myBalance < MIN_BALANCE) myBalance = MIN_BALANCE;
        myMonthlyWithdrawCount = 0;
        myMonthlyServiceCharges = 0.0;
    }
    
  /**
    * Constructs and returns a String representation of the current state of the BankAccount class
    * 
    */
    public String toString() {
        return String.format("BankAccount[owner: %s, balance: %.2f, interest rate: %.2f, " +
                             "\n\t\t  number of withdrawals this month: %d, service charges for this month: %.2f]",
                             myAccountHolderName, myBalance, myInterestRate, myMonthlyWithdrawCount, myMonthlyServiceCharges);
    }

    // interface methods for NamedAccount
    public String getAccountHolderName() {
        return myAccountHolderName;
    }

    public void setAccountHolderName(final String theNewName) {
        myAccountHolderName = theNewName;
    }
}