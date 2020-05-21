/***********************************************************************************
William Mastronardi CSC205 25993

This program will manipulate 2 instances of the DequeOfStrings Object. The program 
will prompt the user on which deque instance they would like to manipulate, then perform
an action on the deque based upon a menu choice.
The menu includes the following possibilities:
a - insert a string on the front
b - insert a string on the back
c - delete a string from the front
d - delete a string from the back
e - display the deque from the front to back
f - display the deque from index 0 to index length - 1
g - check if the deque is empty
***********************************************************************************/
import java.util.*;

public class Program4Phase1 {
   public static Scanner kb = new Scanner(System.in);
   public static void main(String[] args) {
      DequeOfStrings deque1 = new DequeOfStrings();
      DequeOfStrings deque2 = new DequeOfStrings();
      char userInput = ' ';
      System.out.println("This program is used to test the deque of strings object\n");
      do{
         do{
            System.out.println("a for deque 1\nb for deque 2");
            System.out.print("Enter a deque to manipulate using the menu above: ");
            userInput = kb.next().charAt(0);
            if(userInput != 'a' && userInput != 'b')
               System.out.println("Error, enter 'a' or 'b'");
         }while(userInput != 'a' && userInput != 'b');
         switch(userInput) {
            case 'a':
               menuChoice(deque1);
               break;
            case 'b':
               menuChoice(deque2);
               break;
         }
         do{
            System.out.print("Would you like to repeat the program? (y/n) ");
            userInput = kb.next().charAt(0);
            if(userInput != 'y' && userInput != 'n')
               System.out.println("Error, enter 'y' or 'n'");
         }while(userInput != 'y' && userInput != 'n');
      }while(userInput != 'n');         
   }
   public static void menuChoice(DequeOfStrings deque) {
      char userInput;
      do{
         System.out.println("a - insert a string on the front\nb - insert a string on the back");
         System.out.println("c - delete a string from the front\nd - delete a string from the back");
         System.out.println("e - display the deque from front to back");
         System.out.println("f - display the deque from index 0 to the end of the deque");
         System.out.println("g - check if the deque is empty");
         System.out.print("Enter a choice from the menu above: ");
         userInput = kb.next().charAt(0);
         if(userInput != 'a' && userInput != 'b' && userInput != 'c' && userInput != 'd'
           && userInput != 'e' && userInput != 'f' && userInput != 'g')
            System.out.println("Error, enter 'a','b','c','d','e', or 'f'. Try again");
      }while(userInput != 'a' && userInput != 'b' && userInput != 'c' && userInput != 'd'
            && userInput != 'e' && userInput != 'f' && userInput != 'g');
      switch(userInput) {
         case 'a':
            insertOnFront(deque);
            break;
         case 'b':
            insertOnBack(deque);
            break;
         case 'c':
            System.out.println(deque.deleteFromFront());
            break;
         case 'd':
            System.out.println(deque.deleteFromBack());
            break;
         case 'e':
            System.out.println(deque);
            break;
         case 'f':
            System.out.println(deque.toStore());
            break;
         case 'g':
            checkIfDequeEmpty(deque);
            break;
      }
   }
   public static void insertOnFront(DequeOfStrings deque) {
      System.out.print("Enter a string to insert onto the deque: ");
      String in = kb.next();
      deque.insertOnFront(in);
   }
   public static void insertOnBack(DequeOfStrings deque) {
      System.out.print("Enter a string to insert onto the deque: ");
      String in = kb.next();
      deque.insertOnBack(in);
   }
   public static void checkIfDequeEmpty(DequeOfStrings deque) {
      if(deque.isEmpty())
         System.out.println("The deck is empty.");
      else
         System.out.println("The deck is NOT empty.");
   }
}