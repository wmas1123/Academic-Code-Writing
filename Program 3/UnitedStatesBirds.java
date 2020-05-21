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

public class UnitedStatesBirds {
   public static Scanner kb = new Scanner(System.in);
   public static void main(String[] args) {
      char userInput = '0';
      int endFileIndex = 0;
      System.out.println("Welcome to State Trivia Program!");
      System.out.println("In this program there will be information about the current states");
      System.out.println("such as their current population (as of 2020), the state bird of all");
      System.out.println("50 states, and also the state's year of joing the USA. Enjoy! \n");
      State[] states = new State[100];
      //Initializing the array and Input from the file
      endFileIndex = loadUpTheArray(states);
      //Processing and Input from the user
      do{
         System.out.println("a - Display all states and their trivia.");
         System.out.println("b - Display a certain state and its trivia.");
         System.out.println("c - Do a quiz on the trivia of the states.");
         System.out.println("d - Display a histogram of the states population distribution.");
         System.out.println("e - Quit the program");
         System.out.print("Please enter a choice from the menu above: ");
         userInput = validateAThroughEInput();
         switch(userInput){
            case 'a':
               displayEntireContents(states, endFileIndex);
               break;
            case 'b':
               displaySpecificContent(states, endFileIndex);
               break;
            case 'c':
               userQuiz(states, endFileIndex);
               break;
            case 'd':
               displayHistogram(states, endFileIndex);
               break;
            case 'e':
               System.out.println("Now exiting United States Trivia.");
         }
      }while(userInput != 'e');
   }
   //This method display teh contents of the entire array 
   //@param states array and the index for the end of the file
   public static void displayEntireContents(State[] states, int endFileIndex) {
      System.out.printf("|%-15s |%-5s |%-20s |%-10s\n","State","Year","Bird","Population");
      for(int i = 0; i < endFileIndex; i++) {
         System.out.printf("|%-15s |%-5d |%-20s |%-10d\n", states[i].name, states[i].yearFounded,
                          states[i].bird, states[i].population);
         if(i % 14 == 0) {
            System.out.print("Type any letter and press enter to continue. ");
            kb.next();
         }
      }
      System.out.println("\n");
   }
   //This method displays a specific index of the array
   //@param states array and the end of the array
   public static void displaySpecificContent(State[] states, int endFileIndex) {
      System.out.print("Enter a state name: ");
      String s = kb.next();
      boolean found = false;
      int i;
      for(i = 0; i < endFileIndex && !found; ++i) {
         if(states[i].name.equalsIgnoreCase(s)) {
            found = true;
            i--;
         }
      }
      if(found) {
            System.out.printf("|%-15s |%-5s |%-20s |%-10s\n","State","Year","Bird","Population");
            System.out.printf("|%-15s |%-5d |%-20s |%-10d\n", states[i].name, states[i].yearFounded,
                          states[i].bird, states[i].population);
      }
      else
         System.out.println("The given string " + s + " was not found in the file.");
      System.out.println("\n");
   }
   //This method loads the array from the .txt file
   //@param states array
   public static int loadUpTheArray(State[] states) {
      int endFileIndex = 0; 
      try{
         File file = new File("StateInfo.txt");
         Scanner fileIn = new Scanner(file);
         for(int i = 0; i<states.length; i++){
            states[i] = new State();
            states[i].name = fileIn.next();
            states[i].yearFounded = fileIn.nextInt();
            states[i].bird = fileIn.next();
            states[i].population = fileIn.nextInt();
            if(states[i].name.equals("EOF")) 
               return endFileIndex = i;
         }
      }
      catch(IOException e) {
         System.out.println("Caught IOException: " + e);
      }  
      return 0;
   }
   //This method quizzes the user and keeps track of teh user's right and wrong answers
   //@param states array and the end of the file index
   public static void userQuiz(State[] states, int endFileIndex) {
      char userInput = '0';
      String answer = "";
      boolean correctAnswer = false;
      int i = 0;
      int correct = 0;
      int wrong = 0;
      do{
         System.out.printf("What is the state bird of " + states[i].name +"? (No Spaces) ");
         answer = kb.next();
         if(answer.equalsIgnoreCase(states[i].bird)) {
            correct++;
            correctAnswer = true;
         }
         else {
            wrong++;
            correctAnswer = false;  
         }   
         if(correctAnswer)
            System.out.println("Good Job! you got the question right!");
         else
            System.out.println("That was incorrect, the correct answer was " + states[i].bird);
         System.out.print("Would you like to continue? (y/n) ");
         userInput = validateYOrNInput();
         if(userInput == 'y')
            i++;
      }while(userInput == 'y' && i < endFileIndex);
      System.out.printf("You got %-3d correct and %-3d wrong. Thank you for playing!\n\n", 
                       correct, wrong);
   }
   //This method displays a histogram of teh arrays population contents
   //@param states array and the end file index
   public static void displayHistogram(State[] states, int endFileIndex) {
      double decadeGap;
      int totalPopulation = 0;
      int min = findMinimum(states, endFileIndex);
      int max = findMaximum(states, endFileIndex);
      int range = max - min;
      int count = 0;
      String histo = "decade : count" + "\n";
      decadeGap = Math.ceil((double)range / 10);
      for(int k = 0; k < 10; k++) {
         histo += (decadeGap + (decadeGap * k)) + "     ";
         for(int i = 0; i < endFileIndex; i++) {
            if(Math.floor((states[i].population - min)/decadeGap) == k)
               count++;
         }
         for(int i = 0; i < count; i++)
            histo += "*";
         count = 0;
         histo += "\n";
      }
      System.out.print(histo + "\n\n");      
   }
   //This method seaches the array for the min and returns an integer with the min
   public static int findMinimum(State[] states, int endFileIndex) {
      int min = states[0].population;
      for(int i = 0; i < endFileIndex; i++) {
         if(states[i].population < min)
            min = states[i].population;
      }
      return min;
   }
   //This method seaches the array for the max and returns an integer with the max
   public static int findMaximum(State[] states, int endFileIndex) {
      int max = states[0].population;
      for(int i = 0; i < endFileIndex; i++) {
         if(states[i].population > max)
            max = states[i].population;
      }   
      return max;
   }
   //This method validates a menu choice and returns a char with the user's choice
   public static char validateAThroughEInput() {
      char input = '0';
      do{
         input = kb.next().charAt(0);
         if(input!='a' && input!='b' && input!='c' && input!='d' && input!='e')
            System.out.println("Invalid input; Input a character from a to e");
      }while(input!='a' && input!='b' && input!='c' && input!='d' && input!='e');
      return input;
   }
   //This method collects a yes or no input from the user and returns it to main
   public static char validateYOrNInput() {
      char input = '0';
      do{
         input = kb.next().charAt(0);
         if(input!='y' && input!='n')
            System.out.print("Error invalid input. Enter 'y' or 'n'");
      }while(input!='y' && input!='n');
      return input;
   }
}
class State {
   public String name;
   public int population;
   public String bird;
   public int yearFounded;
}