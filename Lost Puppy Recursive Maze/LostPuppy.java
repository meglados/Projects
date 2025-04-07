import java.io.*;
import java.util.*;

/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 4
 *
 *  File Name:	LostPuppy.java
 */

/**
  * This class reads data from a designated file of a character based maze. 
  * With exit and entry points never in corners, the goal is for a puppy to 
  * be able to find its way out of the maze through the means of recursive backtracking
  * upon going through an entry point. Walls of the maze are indicated through 'X',
  * Entry points are 'S', and Exit points are 'E'. Starting column and row sizing are
  * flexible, cols determined through string length of first line of input and 
  * rows are determined through a count of number of lines read. '*' is placed wherever moves
  * occur, and '-' is placed wherever recursive backtracking happens.
  */

public class LostPuppy {

/**
  * Main method calls other helper methods in order to read the file, create a 2d array representation
  * find the start exit locations, solve the maze recursively, and finally display the maze
  *
  */
    public static void main(String[] args) {
        //read maze from file
        char[][] maze = getMaze("MazeData#.txt");

        //get start and exit
        int[] start = getStartExitLocation(maze, 'S');
        int[] exit = getStartExitLocation(maze, 'E');

        //solve maze from start pos
        if (!doMaze(maze, start[0], start[1], exit[0], exit[1])) {
            System.out.println("No Path Found!"); //in the event that the maze is unsolvable
        } else {
            displayMaze(maze);
        }
    }


/**
  * Scanner reads maze from file. Num values are assigned to rows and cols. 2d array is created
  *
  * @param filename is name of current maze file used for scanner
  * @return returns the final assembled 2d char array representing the maze in the file
  *
  */
    //scanner reads maze from file
    public static char[][] getMaze(String filename) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found."); 
        }

        //get num of rows and cols
        int rows = lines.size();
        int cols = lines.get(0).length();

        char[][] maze = new char[rows][cols];

        //maze -> 2d array
        for (int i = 0; i < rows; i++) {
            maze[i] = lines.get(i).toCharArray();
        }

        return maze;
    }

/**
  * Finds the start or exit of the maze
  *
  * @param maze is the 2d char array that contains the current maze, target is either 'S' or 'E'
  * @return returns the row and column location of the 'S' or 'E'
  */
    public static int[] getStartExitLocation(char[][] maze, char target) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null; //if not found, returns null
    }

/**
  * Checks if a move is valid
  * 
  * @param maze in the 2d char array that contains the cur maze, row is the rows of the maze,
  * col is the columns of the maze.
  * 
  * @return returns the result of checking if the row and column size is >= 0,
  *                                        if the row and column size is less than the maze length and max row length respectively
  *                                        if the cur spot is empty or an exit        
  *
  */
    public static boolean canMove(char[][] maze, int row, int col) {
        //check bounds and whether the cell is empty (' ' or 'E')
        return row >= 0 && row < maze.length && col >= 0 && col < maze[row].length && (maze[row][col] == ' ' || maze[row][col] == 'E');
    }

/**
  * Solves the maze using recursion
  *
  * @param maze is the 2d char array containing the cur maze, row is the rows, col is the columns
  *        exitRow is the row the exit is found, exitCol is the column the exit is found
  * @return if a move is possible, will return true and move in possible direction, if no move
  *         is possible, will return false and place '-'.
  *
  */
    public static boolean doMaze(char[][] maze, int row, int col, int exitRow, int exitCol) {
        //base case: if exit is found
        if (row == exitRow && col == exitCol) {
            maze[row][col] = '*';
            return true;
        }

        //mark cur pos as part of the path
        maze[row][col] = '*';

        //move up
        if (canMove(maze, row - 1, col) && doMaze(maze, row - 1, col, exitRow, exitCol)) {
            return true;
        }

        //move down
        if (canMove(maze, row + 1, col) && doMaze(maze, row + 1, col, exitRow, exitCol)) {
            return true;
        }

        //move left
        if (canMove(maze, row, col - 1) && doMaze(maze, row, col - 1, exitRow, exitCol)) {
            return true;
        }

        //move right
        if (canMove(maze, row, col + 1) && doMaze(maze, row, col + 1, exitRow, exitCol)) {
            return true;
        }

        //if it can't move forward, backtrack and leave hyphen
        maze[row][col] = '-';
        return false;
    }

/**
  * Displays the modified maze
  *
  * @param maze is the 2d char array that contains the modified maze
  */
    public static void displayMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
