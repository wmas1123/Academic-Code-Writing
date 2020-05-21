/***********************************************************************************
William Mastronardi CSC205
This program will contain all parts and phases of Program 4, I used the Star Wars Heroes
deck of cards for Top Trump. Within the comments at the bottom will be the other parts 
of the program.


This program implements a tool menu for the 3 core abstract data types, those beign the
deque, the stack, and the queue. Furthermore this program will implement the game of cards
called top trump. It will implement a menu for the initial choice and after the user's 
choice is completed the program will run again until the user decides to exit.
***********************************************************************************/
import java.util.*;
public class Program4{
   public static Scanner kb = new Scanner(System.in);
   public static Random rgen = new Random();
   public static final int SCORE_INCREMENT = 2;
   public static final int CARD_SWAPS = 100; //For shuffle
   public static void main(String[] args){
      char input;
      System.out.println("Welcome to Program 4!");
      System.out.println("In this program there will be 2 options, one will be playing");
      System.out.println("the card game \"Top Trump\", or you can test the tools offered to you");
      System.out.println("\n");
      do{
         do{
            System.out.println("a - Enter the Test the Tools menu");
            System.out.println("b - Play Top Trump\nc - Exit the program");
            System.out.print("Enter a choice from the menu above: ");
            input = kb.next().charAt(0);
            if(input < 'a' || input > 'c')
               System.out.print("Invalid input, try again");
         }while(input < 'a' || input > 'c');
         switch(input) {
            case 'a':
               TestTheTools test = new TestTheTools();
               test.testToolsMenu();
               System.out.println("Sending you back to the main menu. . .");
               break;
            case 'b':
               playTopTrump();
               break;
         }
      }while(input != 'c');
   }
   public static void playTopTrump() {
      int computerScore = 0;
      int player1Score = 0;
      int p1Card = 0;
      int cpuCard = 0;
      Queue deck = createDeck();
      int turnCounter = 1;
      int categoryChoice;
      int scoreToAdd = SCORE_INCREMENT;
      Queue player1 = new Queue();
      Queue cpu = new Queue();
      StarWarsHero p1StorageCard, cpuStorageCard;
      System.out.println("Welcome to Top Trump\n");
      System.out.println("In this game the goal is to win by having the most cards in your pile.");
      System.out.println("You win cards for your pile by having the high card in the category ");
      System.out.println("that is chosen. You will be playing against the computer, and you both");
      System.out.println("will start off with the same amount of cards. If you tie a round with");
      System.out.println("the computer, those cards from the tied round will go to the winner");
      System.out.println("of the following round.");
      System.out.print("Enter your name: ");
      String name = kb.next();
      for(int i = 1; !deck.isEmpty(); i++){
         if(i % 2 == 0)
            cpu.insert(deck.delete());
         else 
            player1.insert(deck.delete());
      }
      System.out.println("PLAYER HAND: " + player1);
      System.out.println("CPU HAND: " + cpu);
      do{
         System.out.println("\n\nCurrent turn: " + turnCounter);
         System.out.println(name + "'s Score: " + player1Score);
         System.out.println("CPU's Score: " + computerScore);
         if(turnCounter % 2 == 0) {
            categoryChoice = rgen.nextInt(6);
            System.out.print("Computer ");
         }
         else {
            do{
               System.out.println("Choose a category from the following menu: ");
               System.out.println("1 - Brains\n2 - Dark Side\n3 - Jedi Power");
               System.out.println("4 - Battle Skills\n5 - Fear Factor");
               categoryChoice = kb.next().charAt(0);
               if(categoryChoice < 1 && categoryChoice > 5)
                  System.out.println("Invalid Input, try again.");
            }while(categoryChoice < 1 && categoryChoice > 5);
            System.out.print("You ");
         }
         p1StorageCard = (StarWarsHero)player1.delete();
         cpuStorageCard = (StarWarsHero)cpu.delete();
         switch(categoryChoice) {
            case 1:
               System.out.println("chose to compare Brains.");
               p1Card = p1StorageCard.getBrains();
               cpuCard = cpuStorageCard.getBrains();
               break;
            case 2:
               System.out.println("chose to compare Dark Side.");
               p1Card = p1StorageCard.getDarkSide();
               cpuCard = cpuStorageCard.getDarkSide();
               break;
            case 3:
               System.out.println("chose to compare Jedi Powers.");
               p1Card = p1StorageCard.getJediPowers();
               cpuCard = cpuStorageCard.getJediPowers();
               break;
            case 4:
               System.out.println("chose to compare Battle Skills.");
               p1Card = p1StorageCard.getBattleSkills();
               cpuCard = cpuStorageCard.getBattleSkills();
               break;
            case 5:
               System.out.println("chose to compare Force Factor.");
               p1Card = p1StorageCard.getForceFactor();
               cpuCard = cpuStorageCard.getForceFactor();
               break;
         }
         System.out.println("Player 1's Card:\n" + p1StorageCard);
         System.out.println("CPU's Card:\n" + cpuStorageCard);
         int result = compareCards(p1Card, cpuCard);
         switch(result) {
            case 1:
               player1Score += scoreToAdd;
               scoreToAdd = SCORE_INCREMENT;
               System.out.println("Adding points to " + name + ".");
               break;
            case 2:
               System.out.println("Adding points to Computer.");
               computerScore += scoreToAdd;
               scoreToAdd = SCORE_INCREMENT;
               break;
            case 3:
               System.out.println("Tie, adding 2 to the score increment.");
               scoreToAdd += SCORE_INCREMENT;
         }
         turnCounter++;
         System.out.print("Press Enter to continue");
         kb.nextLine();
      }while(!player1.isEmpty() || !cpu.isEmpty());
      if(player1.isEmpty()) 
         System.out.println("Congratulations, you won!");
      else
         System.out.println("You lost... Better Luck next time!");
      System.out.println("Thank you for playing Top Trump!");
      System.out.println("Sending you back to the main menu. . .");
   }
   
   public static Queue createDeck() {
      Queue deck = new Queue();
      StarWarsHeroArray cardArray = new StarWarsHeroArray();
      StarWarsHero[] cards = cardArray.getCards();
      shuffleDeck(cards);
      for(int i = 0; i < cards.length; i++)
         deck.insert(cards[i]);   
      System.out.println(deck);  
      return deck;
   }

   public static int compareCards(int p1, int cpu) {
      if(p1 > cpu)
         return 1;
      else if(cpu > p1)
         return 2;
      else
         return 3;
   }
   
   public static void shuffleDeck(StarWarsHero[] cards) {
      int c;
      int k;
      StarWarsHero temp;
      for(int i = 0; i < CARD_SWAPS; i++, c++) {
         k = rgen.nextInt(cards.length - 1);
         do{
            c = rgen.nextInt(cards.length - 1);
         }while(c == k);
         temp = cards[c];
         cards[c] = cards[k];
         cards[k] = temp; 
      }
   }
}

/***********************************************************************************
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
/*
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
/************************************************************************************
This program will use the Deque object to simulate a queue. A queue is a data type 
that only allows insertion on the rear of the queue and only allows deletion from the
front.
************************************************************************************/
/*
public class Queue {
   private Deque _queue;
   
   public Queue() {
      _queue = new Deque();
   }
   
   public void insert(Object in) {
      _queue.insertOnBack(in);
   }
   
   public Object delete() {
      return _queue.deleteFromFront();
   }
   
   public boolean isEmpty() {
      return _queue.isEmpty();
   }
   
   public String toString() {
      return "--FRONT--" + _queue.toString() + "--REAR--";
   }
}
/***********************************************************************************
This program is a simple object used to store the information used for a customer
in the test the tools menu.
***********************************************************************************/
/*
public class Customer {
   int _number;
   String _name;
   public Customer(String name, int number) {
      _name = name;
      _number = number;
   }
   public String toString(){
      return _name + " " + _number;
   }
   public int getNumber() {
      return _number;
   }
   public String getName() {
      return _name;
   }
}
/***********************************************************************************
This program uses the Deque object to simulate the stack.
The stack allows both insertion and deletion from the front and the front only.
***********************************************************************************/
/*
public class Stack{
   private Deque _stack;
   
   public Stack() {
      _stack = new Deque();
   }
   
   public void push(Object in) {
      _stack.insertOnFront(in);
   }
   
   public Object pop() {
      return _stack.deleteFromFront();
   }
   
   public boolean isEmpty() {
      return _stack.isEmpty();
   }
   
   public String toString() {
      return "--TOP--" + _stack.toString() + "--BOTTOM--";
   }
}
/***********************************************************************************
This program simulates an abstract data type called a deque, a deque allows insertion
from both ends and deletion from both ends as well. This can be used to simulate other
abstract data types such as the queue and stack.
***********************************************************************************/
/*
import java.util.*;
public class Deque{
   public static final int ALLOC = 100;
   private Object[] _deque;
   private int _front;
   private int _back;
   private int _size;
   private Scanner kb = new Scanner(System.in);
   public Deque() {
      _deque = new Object[ALLOC];
      _front = 2;
      _back = 2;
      _size = 0;
   }
   
   public void insertOnFront(Object in) {
      if(_size >= _deque.length)
          allocateMoreSpaceFromFront();
      _deque[_front] = in;
      if(_front < _deque.length - 1)
         _front++;
      else
         _front = 0;
      _size++;
   }
   
   public Object deleteFromFront() {
      if(!isEmpty()){
         if(_front > 0){
            _front--;
            _size--;
            return _deque[_front];
         }
         else{
            _front = _deque.length - 1;
            _size--;
            return _deque[_front];
         }
      }
      else 
         return null;
   }  
       
   public void insertOnBack(Object in) {
      if(_size >= _deque.length)
         allocateMoreSpaceFromBack();
      _size++;
      _back--;
      if(_back < 0)
         _back = _deque.length - 1;
      _deque[_back] = in;
   }
   
   public Object deleteFromBack() {
      if(!isEmpty()){
         if(_back < _deque.length - 1) {
            _back++;
            _size--;
            return _deque[_back + 1];
         }
         else {
            _back = 0;
            _size--;
            return _deque[_deque.length - 1];
         }
      }
      else
         return null;
   }
   
   public boolean isEmpty() {
      return (_size == 0);
   }
   
   public String toString() {
      String str = "";
      int c = _front - 1;
      if(!isEmpty()) {
         for(int i = 0; i < _size; ++i, --c) {
            if(c < 0)
               c = _deque.length - 1;
            str += _deque[c] + " ";
         }
      }
      return str;
   }
   public String toStore() {
      String str = "";
      if(!isEmpty()) {
         for(int i = 0; i < _deque.length; i++) {
            str = str + " " + _deque[i];
         }
      }
      return str;
   }
   
   public void allocateMoreSpaceFromFront() {
      Object[] temp = new Object[_deque.length + ALLOC];
      int c = _front ;
      for(int i = 0; i <= _size; i++, c++) {
         if(c >= _deque.length)
            c = 0;
         temp[i] = _deque[c];
      }
       _front = _deque.length;
       _back = _size;
      _deque = temp;
   }
   
   public void allocateMoreSpaceFromBack() {
      Object[] temp = new Object[_deque.length + ALLOC];
      int c = _front - 1;
      int k = 0;
      for(int i = temp.length - 1; k < _size && i > 0; i--, c--, k++) {
         if(c < 0)
            c = _size - 1;
         temp[i] = _deque[c];
      }
      _front = temp.length;
      _back = _size;
      _deque = temp;
      
   }

}
/***********************************************************************************
This program is an implementation of the Stack, Queue, and Deque objects for testing.
The Deque will use customers as a data type, the stack will use integers and the
Queue will use Strings. Each Abstract Data Type will allow use of all methods located
inside their respective classes.
***********************************************************************************/
/*
import java.util.*;
public class TestTheTools {
   public Scanner kb = new Scanner(System.in);
   public void testToolsMenu() {
      Stack _integers = new Stack();
      Queue _strings = new Queue();
      Deque _customers = new Deque();
      char menuInput;
      System.out.println("Welcome to Test the Tools!");
      System.out.println("In this program there will be instances of a Deque, Queue, and Stack");
      System.out.println("available for testing.\n\n");
      do{
         do{
            System.out.println("Which instance would you like to test?");
            System.out.println("a - Stack of Integers\nb - Queue of Strings\nc - Deque of Customers");
            System.out.println("d - Exit the Program ");
            menuInput = kb.next().charAt(0);
            if(menuInput > 'd' || menuInput < 'a')
               System.out.println("Invalid input, try again.");
         }while(menuInput > 'd' || menuInput < 'a');
         switch(menuInput) {
            case 'a':
               stackFunctions(_integers);
               break;
            case 'b':
               queueFunctions(_strings);
               break;
            case 'c':
               dequeFunctions(_customers);
               break;
            }
      }while(menuInput != 'd');
   }
   public char validateInputAToE(){
      char input;
      do{
         System.out.print("Enter a choice from the menu above: ");
         input = kb.next().charAt(0);
         if(input > 'e' || input < 'a')
            System.out.println("Invalid input, try again.");
      }while(input > 'e' || input < 'a');
      return input;
   }
   public char validateInputAToG(){
      char input;
      do{
         System.out.print("Enter a choice from the menu above: ");
         input = kb.next().charAt(0);
         if(input > 'g' || input < 'a')
            System.out.println("Invalid input, try again.");
      }while(input > 'g' || input < 'a');
      return input;
   }
   public void stackFunctions(Stack stack){
      char userInput;
      do{
         System.out.println("Stack Functions:");
         System.out.println("a - Push\nb - Pop");
         System.out.println("c - Check if the Stack is Empty\nd - View the Contents of the Stack");
         System.out.println("e - Finish Manipulating the Stack");
         userInput = validateInputAToE();
         switch(userInput){
         case 'a':
            System.out.print("Enter an integer to add to the Stack: ");
            int insert = kb.nextInt();
            stack.push(insert);
            break;
         case 'b':
            System.out.println(stack.pop());
            break;
         case 'c':
            if(!stack.isEmpty())
               System.out.println("The Stack has integers");
            else
               System.out.println("The Stack is empty.");
            break;
         case 'd':
            System.out.println(stack);
            break;
         }
      }while(userInput != 'e');
   }
   public void queueFunctions(Queue queue){
      char userInput;
      do{
         System.out.println("Queue Functions:");
         System.out.println("a - Insert\nb - Delete");
         System.out.println("c - Check if the Queue is Empty\nd - View the Contents of the Queue");
         System.out.println("e - Finish Manipulating the Queue");
         userInput = validateInputAToE();
         switch(userInput){
         case 'a':
            System.out.print("Enter a String to add to the Queue: ");
            String insert = kb.next();
            queue.insert(insert);
            break;
         case 'b':
            System.out.println(queue.delete());
            break;
         case 'c':
            if(!queue.isEmpty())
               System.out.println("The Queue has integers");
            else
               System.out.println("The Queue is empty.");
            break;
         case 'd':
            System.out.println(queue);
            break;
         }
         
      }while(userInput != 'e');
   }
   public void dequeFunctions(Deque deque){
      char userInput;
      String name;
      int number;
      Customer cust;
      do{
         System.out.println("Queue Functions:");
         System.out.println("a - Insert on Front\nb - Delete from Front");
         System.out.println("c - Insert on Back\nd - Delete from Back");
         System.out.println("e - Check if the Deque is Empty\nf - View the Contents of the Deque");
         System.out.println("g - Finish Manipulating the Queue");  
         userInput = validateInputAToG();  
         switch(userInput){
         case 'a':
            System.out.print("Enter a name for a customer: ");
            name = kb.next();
            System.out.print("Enter a number for the customer: ");
            number = kb.nextInt();
            cust = new Customer(name, number);
            deque.insertOnFront(cust);
            break;
         case 'b':
            System.out.println(deque.deleteFromFront());
            break;
         case 'c':
            System.out.print("Enter a name for a customer: ");
            name = kb.next();
            System.out.print("Enter a number for the customer: ");
            number = kb.nextInt();
            cust = new Customer(name, number);
            deque.insertOnBack(cust);
            break;
         case 'd':
            System.out.println(deque.deleteFromBack());
            break;

         case 'e':
            if(!deque.isEmpty())
               System.out.println("The Deque has integers");
            else
               System.out.println("The Deque is empty.");
            break;
         case 'f':
            System.out.println(deque);
            break;
         }
                    
      }while(userInput != 'g');
   }
}
*/