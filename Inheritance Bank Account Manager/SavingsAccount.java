/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 2
 *
 *  File Name:	SavingsAccount.java
 */

/**
  * Represents a specialized Savings Account, extends capabilites of a BankAccount Object
  * additionally records the activity status of the account based on balance
  *
  */
public class SavingsAccount extends BankAccount {
    //constants
    private static final double MIN_ACTIVE_BALANCE = 25.00;
    private static final double MAX_WITHDRAWALS = 5;

    //fields
    private boolean myStatusIsActive;
    
  /**
    * Calls SavingsAccounts super class contructor and intializes the myStatusIsActive field
    * 
    */
    public SavingsAccount(final String theNameOfOwner, final double theInterestRate) {
        super(theNameOfOwner, theInterestRate);
        myStatusIsActive = getBalance() >= MIN_ACTIVE_BALANCE;
    }

  /**
    * Adds “theAmount” to the SavingsAccount object’s balance following the same rules as 
    * the deposit method of the
    * BankAccount class
    * 
    */
    @Override
    public boolean processDeposit(final double theAmount) {
        boolean success = super.processDeposit(theAmount);
        if (success) {
            myStatusIsActive = getBalance() >= MIN_ACTIVE_BALANCE;
        }
        return success;
    }

  /**
    * Subtracts “theAmount” from the SavingsAccount object’s balance, as with the 
    * processWithdrawal method of the
    * BankAccount class
    *
    */
    @Override
    public boolean processWithdrawal(final double theAmount) {
        if (!myStatusIsActive) {
            return false;
        }
        if (myMonthlyWithdrawCount >= 5) { //tests if the user has exceed max withdrawls and assigns service fee
            myMonthlyServiceCharges = (myMonthlyWithdrawCount - MAX_WITHDRAWALS) + 2;
        }
        boolean success = super.processWithdrawal(theAmount);
        if (success && getBalance() < MIN_ACTIVE_BALANCE) {
            myStatusIsActive = false;
        }
        return success;
    }

  /**
    * This method performs the same monthly processing as is done in the super class but also, updates the
    * myStatusIsActive value based on the balance
    * 
    */
    @Override
    public void performMonthlyProcess() {
        super.performMonthlyProcess();
        myStatusIsActive = getBalance() >= MIN_ACTIVE_BALANCE;
    }

  /**
    * Constructs and returns a String representation of the current state of the SavingsAccount class
    * 
    */
    @Override
    public String toString() {
        return String.format("SavingsAccount[owner: %s, balance: %.2f, interest rate: %.2f, " +
                             "\n number of withdrawals this month: %d, service charges for this month: %.2f, " +
                             "myStatusIsActive: %b]", 
                             getAccountHolderName(), getBalance(), 0.05, 
                             myMonthlyWithdrawCount, myMonthlyServiceCharges, myStatusIsActive);
    }
}