/***********************************************************************************
This program is an implementation of the Stack, Queue, and Deque objects for testing.
The Deque will use customers as a data type, the stack will use integers and the
Queue will use Strings. Each Abstract Data Type will allow use of all methods located
inside their respective classes.
***********************************************************************************/
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