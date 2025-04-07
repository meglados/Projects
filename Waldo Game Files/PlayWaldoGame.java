/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Driver for Programming Assignment 1
 *
 *  File Name:	PlayWaldoGame.java
 */

import java.util.Random;
import java.util.Scanner;

/**
 * This program is used as a driver program to play the game from the
 * class WhereIsWaldo.
 *
 * Our friend Waldo is hiding in an auditorium seat represented in the class
 * WhereIsWaldo.class.  Two players will take turns searching the seats of the
 * auditorium by selecting a row and a seat where the Waldo might be.  As with
 * most auditoriums, rows are labeled with alphabetic letters starting at the
 * stage with row A, moving away from the stage with increasing alphabetic letters,
 * i.e. ...E D C B A [Stage].  Of course, seats on each row are numbered 1, 2, 3...
 * For example, A seat in the auditorium illustrated below appears as: (  |
 * thus, with a stage to the right and an auditorium of 5 rows with 4 seats per
 * row should appear as follows (letters E D C B A indicate rows and digits
 * 1 2 3 4 indicate seat numbers):
 *
 *   E   D   C   B   A    |S|
 *  (  |(  |(  |(  |(  |  |T| <-1
 *  (  |(  |(  |(  |(  |  |A| <-2
 *  (  |(  |(  |(  |(  |  |G| <-3
 *  (  |(  |(  |(  |(  |  |E| <-4
 *
 * Simulated in a 2-D array, indices [0][0] would be the seat at location A 1
 * in the above illustration.
 *
 * @author David Schuessler
 * @version Autumn 2024
 */

public class PlayWaldoGame {
  /**
   * Driver program to play WhereIsWaldo.
   *
   * @param theArgs may contain file names in an array of type String
   */
  public static void main(String[] theArgs){
    Scanner s = new Scanner(System.in);
    WhereIsWaldo game;
    int totalRows;
    int totalSeats;
    char row;
    int seat;
    char[] players = {'1', '2'};
    int playerIndex;
    boolean found = false;
    Random rand = new Random();

    do {
      System.out.print("To find Waldo, we need to know:\n"
                       + "\tHow many rows are in the auditorium\n"
                       + "\tHow many seats are on each row\n\n"
                       + "             Please enter the number of rows: ");
      totalRows = s.nextInt();
      System.out.print("Please enter the number of seats on each row: ");
      totalSeats = s.nextInt();
      s.nextLine();    // Consume previous newline character

      // Start the game: Create a WhereIsWaldo object:
      game = new WhereIsWaldo(totalRows, totalSeats);

      // Pick starting player
      playerIndex = rand.nextInt(2);

      System.out.println("\nRows start at A and seats start at one '1'");

      do {

        do {
          System.out.println("\nPlayer " + players[playerIndex]
                             + ", enter row letter and seat number to search separated by a space: ");
          row = s.next().charAt(0);
          seat = s.nextInt();

          //for testing, use random generation of row and seat
          //row = (char)(rand.nextInt(totalRows) + 'A');
          //seat = rand.nextInt(totalSeats) + 1;
        } while (!game.indicesOK(row, seat)
                 || game.seatSearchedAlready(row, seat));


        found = game.searchSeat(row, seat, players[playerIndex]);
        playerIndex = (playerIndex + 1) % 2;
 //       System.out.println("\n[" + row + "], [" + seat + "]");
        System.out.println(game.toString());
        s.nextLine();
      } while (!found);

      playerIndex = (playerIndex + 1) % 2;
      System.out.println("Great job player " + players[playerIndex] +"!");
      System.out.println("Would you like to find Waldo again[Y/N]? ");
    } while (s.nextLine().equalsIgnoreCase("Y"));
  }
}
