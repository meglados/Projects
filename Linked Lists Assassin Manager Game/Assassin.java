/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory 
 *                        and Application
 *  Name:		    David Schuessler
 *  Instructor:	Mr. Schuessler
 *  Assignment:	Assassins - Programming Assignment 7
 *  
 *  File Name:	Assassin.java
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is a driver to run a game of assassins who target and terminate 
 * other assassins that are controlled by the class AssassinManager.java.
 *
 * This driver passes a list of assassin names to the AssassinManager and then
 * has the user enter names of assassins to be terminated until only one
 * assassin remains.
 *
 * @author David Schuessler
 * @version Winter 2020
 */
public class Assassin {

  /**
   * Driver program to play the Assassination game.
   *
   * @param theArgs may contain file names in an array of type String
   */
  public static void main(String[] theArgs){
	 		boolean ok = false;  // Used to assure legal victim
      String[] nameArray = {"Bruce", "Arnold", "Jennifer", "Sylvester", "Angelina"};
      // Put the names into an ArrayList so it can be shuffled
      List<String> names = new LinkedList<String>();
      for (int i = 0; i < nameArray.length; i++)
        names.add(nameArray[i]);
      Collections.shuffle(names); //shuffle the names into random order
      int i = 0;
      for (String str : names)    // Return the names to the array
        nameArray[i++] = str;
      // Create a new game with the shuffled array of names
      AssassinManager manager = new AssassinManager(nameArray);

      // Get Scanner for console input of names to assassinate
      Scanner console = new Scanner(System.in);

      //Repeat this loop until the game is over
      while (!manager.isGameOver()) {
         //print the kill ring
         System.out.println("Current kill ring:");
         manager.printKillRing();
        
         //print the graveyard
         System.out.println("Current graveyard:");
         manager.printGraveyard();
         System.out.println();
        
         //prompt for the next victim until victim is in the kill ring
         ok = false;
         do {
           		System.out.print("Enter next victim: ");
           		String name = console.nextLine();
           		if (manager.graveyardContains(name)) {
              		System.out.println(name + " is already dead.");
           		} else if (!manager.killRingContains(name)) {
              		System.out.println("Unknown person.");
           		} else {
        		ok = true;
              		manager.kill(name);
           		}
           		System.out.println();
         } while (!ok);
      }

      //announce the final results
      System.out.println("Game was won by " + manager.getWinner() + ".");
      System.out.println("Final graveyard:");
      manager.printGraveyard();

   }
}