/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 1
 *
 *  File Name:	WhereIsWaldo.java
 */

import java.util.Random;

/**
 * This class models a "Where's Waldo" game in an auditorium where Waldo is placed randomly
 * and players search for Waldo by choosing a seat. 
 * The program hides Waldo until found and provides methods for searching, validating
 * indices, and outputting the auditorium's state.
 */

public class WhereIsWaldo {
    private char[][] myAuditorium;
    private int myRowLocation;
    private int mySeatLocation;
    private char myWinner;
    private boolean myFound;

   /**
     * Constructor that initializes the auditorium with a random seat configuration.
     * Waldo is placed randomly in the auditorium.
     *
     * @param rows Number of rows in the auditorium.
     * @param seatsPerRow Number of seats per row in the auditorium.
     */

    public WhereIsWaldo(int rows, int seatsPerRow) {
        // Initialize the auditorium
        myAuditorium = new char[seatsPerRow][rows];
        for (int i = 0; i < seatsPerRow; i++) {
            for (int j = 0; j < rows; j++) {
                myAuditorium[i][j] = ' '; // Empty seat
            }
        }

        // Randomly place Waldo in the auditorium
        Random rand = new Random();
        myRowLocation = rand.nextInt(rows);
        mySeatLocation = rand.nextInt(seatsPerRow);
        myAuditorium[mySeatLocation][myRowLocation] = 'W'; // Place Waldo
        
        // Initialize other fields
        myWinner = ' '; // No winner yet
        myFound = false;
    }

   /**
     * Checks if the seat has already been searched.
     *
     * @param row The row character to identify the row.
     * @param seat The seat number.
     * @return Returns true if the seat has been searched, false otherwise.
     */

    public boolean seatSearchedAlready(char row, int seat) {
        boolean invalidGuess = false;
        int rowIndex = row - 'A'; //row from char to index
        int seatIndex = seat - 1; //seat number to index
        
        //
        if (myAuditorium[seatIndex][rowIndex] != ' '){
            invalidGuess = true;
        }
        
        if (waldoLocation(row, seat) == true){
            invalidGuess = false;
        }
        
        
        return invalidGuess;
    }

   /**
     * Checks if Waldo is at the given seat.
     *
     * @param row The row character to identify the row.
     * @param seat The seat number.
     * @return Returns true if Waldo is located at the given seat, false otherwise.
     */

    public boolean waldoLocation(char row, int seat) {
        int rowIndex = row - 'A'; 
        int seatIndex = seat - 1;
        return myAuditorium[seatIndex][rowIndex] == 'W'; // Check if it's Waldo's seat
    }

   /**
     * Checks if the row and seat indices are valid in the auditorium.
     *
     * @param row The row character to identify the row.
     * @param seat The seat number.
     * @return Returns true if the indices are within bounds, false otherwise.
     */

    public boolean indicesOK(char row, int seat) {
        int rowIndex = row - 'A';
        int seatIndex = seat - 1; 
        return rowIndex >= 0 && rowIndex < myAuditorium[0].length && seatIndex >= 0 && seatIndex < myAuditorium.length;
        //return rowIndex >= 0 && rowIndex < myAuditorium.length && seatIndex >= 0 && seatIndex < myAuditorium[0].length;
    }

   /**
     * Returns the number of rows in the auditorium.
     *
     * @return The number of rows in the auditorium.
     */

    public int numberOfRows() {
        return myAuditorium[0].length;
    }

   /**
     * Returns the number of seats per row in the auditorium.
     *
     * @return The number of seats per row.
     */

    public int numberOfSeats() {
        return myAuditorium.length;
    }

   /**
     * Searches a given seat for Waldo and updates the auditorium accordingly.
     *
     * @param row The row character to identify the row.
     * @param seat The seat number.
     * @param player The player who is searching for Waldo.
     * @return Returns true if Waldo is found at the seat, false otherwise.
     */

    public boolean searchSeat(char row, int seat, char player) {
        int rowIndex = row - 'A'; //row from char to index
        int seatIndex = seat - 1; //seat number to index

        if (myAuditorium[seatIndex][rowIndex] == 'W') {
            myWinner = player; // set winner
            myFound = true; // waldo found
            return true;
        } else {
            myAuditorium[seatIndex][rowIndex] = player; //seat marked searched
            return false; // waldo not found
        }
    }
    
    /**
     * Returns a formatted string representing the auditorium state.
     * Waldo is hidden until found.
     *
     * @return A string representation of the auditorium with seats marked.
     */
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
                
        for (int i = 0; i < myAuditorium[0].length*4; i++){
            sb.append("=");
        }
        sb.append("\n");

        for (int i = 0; i <= myAuditorium.length - 1; i++) {
            sb.append("( "); 
            for (int j = myAuditorium[i].length - 1; j >= 0 ; j--) {
                if (myAuditorium[i][j] == 'W' && !myFound) {
                     if (j == 0) {
                        sb.append(myAuditorium[i][j]).append(" | "); 
                     } else {        
                        sb.append(" |( "); // hide Waldo until found
                     }
                } else if(j == 0) {
                    sb.append(myAuditorium[i][j]).append("| ");
                } else {
                    sb.append(myAuditorium[i][j]).append("|( ");
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < myAuditorium[0].length*4; i++){
            sb.append("=");
        }
            
        return sb.toString(); //return formatted toString
    }
}
