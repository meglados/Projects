import java.io.*;
import java.util.*;

/*
 *  Course:	    TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                        and Application
 *  Name:		   Audrey Hale
 *  Instructor:	Dr. Wei Cai
 *  Assignment:	Programming Assignment 3
 *
 *  File Name:	Assignment4.java
 */


/**
  * Test driver class that includes main. Reads a file and outputs based on information taken from that file.
  * Accesses the AbstractShape subclasses for various operations to assist in output.
  *
  */
public class Assignment4 {
    public static void main(String[] args) {
        // input and output file initialization
        try (Scanner input = new Scanner(new File("in4.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("out4.txt"))) {
             
            // initialize the LinkedList to store shapes
            List<Shape> myList = new LinkedList<>();

            // get the list of shapes
            List<Shape> copyList = getOriginalList(input, myList);

            // output the original unsorted list
            writer.println("Original List[unsorted]:");
            outputList(myList, writer);

            // sort the copyList and output it
            Collections.sort(copyList);
            writer.println("\nCopied List[sorted]:");
            outputList(copyList, writer);

            // output the original list again
            writer.println("\nOriginal List[unsorted]:");
            outputList(myList, writer);

            // make the sets
            Set<Shape> myHashSet = new HashSet<>(myList);
            Set<Shape> myTreeSet = new TreeSet<>(myList);
            writer.println("\nHash Set:");
            writeSet(myHashSet, writer);
            writer.println("\nTree Set:");
            writeSet(myTreeSet, writer);

            // make the map
            Map<Double, Shape> myMap = buildMap(myList);
            writer.println("\nMap:");
            writeMap(myMap, writer);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found."); // if file is not found
        } catch (IOException e) {
            System.out.println("Error writing to output file."); // if issue occurs while writing
        }
    }
    
      public static List<Shape> getOriginalList(Scanner input, List<Shape> myList) {
          while (input.hasNextLine()) {
              String line = input.nextLine().trim();
              String splitter = "[\\s]+";  // split line by spaces to count tokens
      
              // split into tokens
              String[] tokens = line.split(splitter);
      
              // check if a readable double or not via scanner
              Scanner lineScanner = new Scanner(line);
      
              try {
                  if (tokens.length == 1) {
                      // if only one tokens its a circle
                      if (lineScanner.hasNextDouble()) {
                          double radius = lineScanner.nextDouble();
                          if (radius > 0) {  // check if value is valid
                              myList.add(new Circle(radius));
                          } 
                      } 
                  } else if (tokens.length == 2) {
                      // if only two tokens its a rectangle
                      if (lineScanner.hasNextDouble()) {
                          double length = lineScanner.nextDouble();
                          if (lineScanner.hasNextDouble()) {
                              double width = lineScanner.nextDouble();
                              if (length > 0 && width > 0) {  // check if dimensions are valid
                                  myList.add(new Rectangle(length, width));
                              }
                          }
                      } 
                  } else if (tokens.length == 3) {
                      // if 3 tokens, its a triangle
                      if (lineScanner.hasNextDouble()) {
                          double sideA = lineScanner.nextDouble();
                          if (lineScanner.hasNextDouble()) {
                              double sideB = lineScanner.nextDouble();
                              if (lineScanner.hasNextDouble()) {
                                  double sideC = lineScanner.nextDouble();
                                  if (sideA > 0 && sideB > 0 && sideC > 0) {  // check if all sides are valid
                                      myList.add(new Triangle(sideA, sideB, sideC));
                                  }
                              }
                          }
                      }
                  }
              } catch (Exception e) {
                  System.out.println("ERROR: " + e.getMessage());
              }
              lineScanner.close();
          }
          
          // defensive copy of the list
          List<Shape> newList = new ArrayList<Shape>();
          for(Shape element : myList) {
               Shape s = element.copyShape();
               newList.add(s);
          }
          return newList;
      }


/**
  * Outputs the shape to the output file
  *
  */
   
   public static void outputList(List<Shape> list, PrintWriter writer) {
       for (Shape shape : list) {
           writer.println(shape);  // uses the toString() method of Shape
       }
   }

/**
  * Outputs the set to the output file
  *
  */
   public static void writeSet(Set<Shape> set, PrintWriter writer) {
       for (Shape shape : set) {
           writer.println(shape);
       }
   }

/**
  * Outputs the map to the output file
  *
  */
   public static Map<Double, Shape> buildMap(List<Shape> myList) {
       Map<Double, Shape> myMap = new TreeMap<>();
       for (Shape shape : myList) {
           myMap.put(shape.calculateArea(), shape);
       }
       return myMap;
   }

/**
  * Outputs the map to the output file
  *
  */
   public static void writeMap(Map<Double, Shape> myMap, PrintWriter writer) {
       for (Map.Entry<Double, Shape> entry : myMap.entrySet()) {
           writer.println(entry.getValue());
       }
   }
   

}















/*
import java.io.*;
import java.util.*;

public class Assignment4 {

    public static void main(String[] args) {
        Scanner input = null;
        PrintWriter writer = null;
        String inFileName = "in4.txt";
        String outFileName = "out4.txt";
        boolean filesOk = false; //indicates if the files are accessible 
    
        
        try {
           input = new Scanner(new File(inFileName));
           writer = new PrintWriter(new File(outFileName));
           filesOk = true;
           
        } catch(FileNotFoundException e) {
               System.out.println("Error: input file not found." + e);
        }
        
        if (filesOk == true) {
            LinkedList<Shape> myList = new LinkedList<>();
            List<Shape> copyList = getOriginalList(input, myList);

            // Write original list to file
            writeListToFile(myList, writer);

            // Create a copy of the list and sort
            List<Shape> sortedList = new ArrayList<>(copyList);
            Collections.sort(sortedList);

            // Write sorted list and original list again
            writeListToFile(sortedList, writer);
            writeListToFile(myList, writer);

            // HashSet and TreeSet operations
            Set<Shape> myHashSet = new HashSet<>(myList);
            Set<Shape> myTreeSet = new TreeSet<>(myList);
            writeSet(myHashSet, writer);
            writeSet(myTreeSet, writer);

            // Create and write Map
            Map<Double, Shape> myMap = buildMap(myList);
            writeMap(myMap, writer);
        }
    }

    public static List<Shape> getOriginalList(Scanner input, List<Shape> myList) {
          while (input.hasNextLine()) {
              String line = input.nextLine().trim();
              Scanner lineScanner = new Scanner(line);
              
              try {
                  if (lineScanner.hasNextDouble() && !lineScanner.hasNext()) {
                      // Circle case (one value)
                      double radius = lineScanner.nextDouble();
                      myList.add(new Circle(radius));
                  } else if (lineScanner.hasNextDouble() && lineScanner.hasNextDouble()) {
                      // Rectangle case (two values)
                      double length = lineScanner.nextDouble();
                      double width = lineScanner.nextDouble();
                      myList.add(new Rectangle(length, width));
                  } else if (lineScanner.hasNextDouble() && lineScanner.hasNextDouble() && lineScanner.hasNextDouble()) {
                      // Triangle case (three values)
                      double sideA = lineScanner.nextDouble();
                      double sideB = lineScanner.nextDouble();
                      double sideC = lineScanner.nextDouble();
                      myList.add(new Triangle(sideA, sideB, sideC));
                  } else {
                      // Skip invalid input
                      System.out.println("Invalid input line: " + line);
                  }
              } catch (IllegalArgumentException e) {
                  // Print the error and continue to next line
                  System.out.println("ERROR: " + e.getMessage());
                }
             lineScanner.close();
         }
        return new ArrayList<>(myList);  // Return a new ArrayList for sorting
    }
 

    public static void writeListToFile(List<Shape> shapeList, PrintWriter writer) {
        // Implement writing list to file
      for (Shape shape : shapeList) {
         writer.println(shape);  // Calls the toString() method of Shape
      }
    }

    public static void writeSet(Set<Shape> set, PrintWriter writer) {
        // Implement writing set to file
        for (Shape shape : set) {
         writer.println(shape);
        }
    }

    public static void writeMap(Map<Double, Shape> myMap, PrintWriter writer) {
        // Implement writing map to file
        for (Map.Entry<Double, Shape> entry : myMap.entrySet()) {
            writer.println(entry.getValue());
        }
    }

    public static Map<Double, Shape> buildMap(List<Shape> shapeList) {
        // Build and return a map based on the area
        Map<Double, Shape> myMap = new TreeMap<>();
        for (Shape shape : shapeList) {
            myMap.put(shape.calculateArea(), shape);
        }
        return myMap;
    }
}
*/