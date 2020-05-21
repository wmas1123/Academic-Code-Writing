/***********************************************************************************
William Mastronardi CSC205 25993

This program will read an outside .txt file containing information related to the 
State record. The value read in will include the State's name, the state's population,
each individual state's bird, and the year the state joined the United States. The data
collected from teh text file will then have 4 different uses based upon user input and 
delegated through a switch statement. Tasks implemented into the program will be 
A - Displaying the entire data file
B - Displaying only a selected record of the data file (Done by using the state name
    and a compare to)
C - A quiz on each state's state bird
D - A histogram of population distribution across the 50 states (Displayed in intervals
    of 5)
***********************************************************************************/
import java.io.*;
import java.util.*;

public class UnitedStatesTrivia {
   public static Scanner kb = new Scanner(System.in);
   public static void main(String[] args) {
      char userInput = '0';
      
      System.out.println("Welcome to State Trivia Program!");
      System.out.println("In this program there will be information about the current states");
      System.out.println("such as their current population (as of 2020), the state bird of all");
      System.out.println("50 states, and also the state's year of joing the USA. Enjoy! \n");
      State[] states = new State[100];
      
      
      do{
         states = initializeTheArray(states);   
         userInput = displayMenuReturnChoice();
            //Menu and choices with output
            switch(userInput){
               case 'a':
                  displayEntireContents(states);
                  break;
               case 'b':
                  displaySpecificContent(states);
                  break;
               case 'c':
                  userQuiz(states);
                  break;
               case 'd':
                  displayHistogram(states);
                  break;
            }
            System.out.print("Do you want to continue? (y/n)");
            if(kb.next().charAt(0) == 'y')
               displayMenuReturnChoice();
      }while(userInput == 'a' || userInput == 'b' || userInput == 'c' || userInput == 'd');
      System.out.println("Now exiting United States Trivia.");
   }
   public static State[] initializeTheArray(State[] states) {
      try{
         //Input from the file
         File file = new File("StateInfo.txt");
         Scanner fileIn = new Scanner(file);
         for(int i = 0; i < states.length; i++) {
            states[i] = new State();
            states[i].name = kb.next();
            states[i].yearFounded = kb.nextInt();
            states[i].bird = kb.next();
            states[i].population = kb.nextInt();
            if(states[i].name.equals("EOF"))
               return states;
         }
      }
      catch(IOException e) {
         System.out.println("Caught IOException: " + e);
      }
      catch(RuntimeException e) {
         System.out.println("Caught RuntimeException: " + e);
      }
      catch(Throwable e) {
         System.out.println("Caught Throwable" + e);
      }
      return states;
   }
   public static char displayMenuReturnChoice() {
      System.out.println("a - Display all states and their trivia.");
      System.out.println("b - Display a certain state and its trivia.");
      System.out.println("c - Do a quiz on the trivia of the states.");
      System.out.println("d - Display a histogram of the states population distribution.");
      System.out.println("any other character - Quit the program");
      System.out.print("Please enter a choice from the menu above: ");
      char userChoice = kb.next().charAt(0);
      return userChoice;
   }
   
   public static void displayEntireContents(State[] states) {
      System.out.println("State           Year  State Bird            Population");
      for(int i = 0; i < states.length && !states[i].name.equals("EOF"); i++) {
         System.out.printf("%14s  %4d %22s %10d",states[i].name,states[i].yearFounded,
                           states[i].bird,states[i].population);
      }
   }
   public static void displaySpecificContent(State[] states) {
      int i;
      do {
         System.out.print("Enter an index for the state");
         i = kb.nextInt();
      }while(i < states.length);
      System.out.println("State           Year  State Bird            Population");
      System.out.printf("%14s  %4d %22s %10d",states[i].name,states[i].yearFounded,
                        states[i].bird,states[i].population);
   }
   public static void userQuiz(State[] states) {
   
   }
   public static void displayHistogram(State[] states) {
   
   }
}
class State {
   public String name;
   public int yearFounded;
   public String bird;
   public int population;
}