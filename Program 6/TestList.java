/***********************************************************************************
William Mastronardi CSC205 25993
This program will be used to test the List class, this will be done by giving the user
the option testing 3 different instances of teh List class, 2 strings and 1 InventoryItem 
object List. The will employ all methods from the List Object to manipulate teh objects.
***********************************************************************************/
import java.util.*;
public class TestList {
   public static Scanner kb = new Scanner(System.in);
   public static void main(String args[]) {
      List strings1 = new List();
      List strings2 = new List();
      List inventory = new List();
      System.out.println("Welcome to the Test List program!\n");
      System.out.println("In this program you will test 3 instances of the List data type");
      System.out.println("Two of which will use Strings as the object, and the last will use");
      System.out.println("InventoryItem objects. You will be able to go through all lists");
      System.out.println("and insert an object, delete a range of items, delete a single item");
      System.out.println("retrieve an item at a certain position in the list, find the indexes");
      System.out.println("where an item is found in the list, get the size of the list,");
      System.out.println("and view the entire contents of the list.\n\n");
      String name;
      int quantity;
      double cost;
      char choice;
      char manipChoice = ' ';
      do{
         do{
            System.out.println("Which List would you like to manipulate?");
            System.out.println("a - String List 1\nb - String List 2\nc - Inventory Item List\nd - Quit the Program");
            choice = kb.next().charAt(0);
            if(choice < 'a' && choice > 'd')
               System.out.println("Error, Invalid choice. Try again");
         }while(choice < 'a' && choice > 'd');
         switch(manipChoice) {
            case 'a':
               manipulateStringList(strings1);
               break;
            case 'b':
               manipulateStringList(strings2);
               break;
            case 'c':
               manipulateInventoryItemList(inventory);
               break;
         }
      }while(choice != 'd');
   }
   
   public static void manipulateStringList(List strings) {
      char choice = ' ';
      do{
         System.out.print("a - Insert a String\nb - Delete a range of Strings\nc - Delete an item from the List");
         System.out.println("(All Occurrences of the item)\nd - Retrieve the item at a specific position from the List");
         System.out.println("e - Find the indexes from all occurrences of an item\nf - Get the size of the List");
         System.out.print("\ng - Display the contents of the List\nEnter a choice from the menu above: ");
         if(choice < 'a' && choice > 'g')
            System.out.println("Error, Invalid choice. Try again");
      }while(choice < 'a' && choice > 'g');
      switch(choice) {
         case 'a':
            System.out.print("Enter a String to insert to the List: ");
            strings.insert(kb.next());
            break;
         case 'b':
            int start, end;
            do{
               System.out.print("Enter a start index to delete: ");
               start = kb.nextInt();
               System.out.print("Enter an end index for the deletion: ");
               end = kb.nextInt();
               if(end < start)
                  System.out.println("Error, end cannot be less than start. Try again");
            }while(end < start);
            strings.deleteRange(start, end);
            break;
         case 'c':
            System.out.print("Enter an object to delete from the List: ");
            strings.deleteItem(kb.next());
            break;
         case 'd':
            System.out.print("Enter a position to retrieve: ");
            int i = kb.nextInt();
            System.out.println("Item at position " + i + " " + strings.retrieve(i));
            break;
         case 'e':
            System.out.print("Enter an item to find the indexes of: ");
            String find = kb.next();
            System.out.println(strings.find(find));
            break;
         case 'f':
            System.out.println("The List is " + strings.getSize() + " big.");
            break;
         case 'g':
            System.out.println(strings);
            break;
      }
   }
      
   public static void manipulateInventoryItemList(List inventory) {
      char choice = ' ';
      do{
         System.out.print("a - Insert an item\nb - Delete a range of items\nc - Delete an item from the List");
         System.out.println("(All Occurrences of the item)\nd - Retrieve the item at a specific position from the List");
         System.out.println("e - Find the indexes from all occurrences of an item\nf - Get the size of the List");
         System.out.print("\ng - Display the contents of the List\nEnter a choice from the menu above: ");
         if(choice < 'a' && choice > 'g')
            System.out.println("Error, Invalid choice. Try again");
      }while(choice < 'a' && choice > 'g');
      switch(choice) {
         case 'a':
            System.out.print("Enter a name for the item: ");
            String name = kb.next();
            System.out.print("Enter a quantity for the item: ");
            int quantity = kb.nextInt();
            System.out.print("Enter a cost for the item: ");
            double cost = kb.nextDouble();
            InventoryItem item = new InventoryItem(name, quantity, cost);
            inventory.insert(item);
            break;
         case 'b':
            int start, end;
            do{
               System.out.print("Enter a start index to delete: ");
               start = kb.nextInt();
               System.out.print("Enter an end index for the deletion: ");
               end = kb.nextInt();
               if(end < start)
                  System.out.println("Error, end cannot be less than start. Try again");
            }while(end < start);
            inventory.deleteRange(start, end);
            break;
         case 'c':
            System.out.print("Enter an object to delete from the List: ");
            inventory.deleteItem(kb.next());
            break;
         case 'd':
            System.out.print("Enter a position to retrieve: ");
            int i = kb.nextInt();
            System.out.println("Item at position " + i + " " + inventory.retrieve(i));
            break;
         case 'e':
            System.out.print("Enter an item to find the indexes of: ");
            String find = kb.next();
            System.out.println(inventory.find(find));
            break;
         case 'f':
            System.out.println("The List is " + inventory.getSize() + " big.");
            break;
         case 'g':
            System.out.println(inventory);
            break;
      }
   }
}
/***********************************************************************************
William Mastronardi CSC205 25993
This object will model a List, which is a set of bjects held at a certain index, and 
can contain duplicates. This will implement the Link object to store the items within
the array.
insert - inserts an object into the list
getSize - returns the size of the List
find - returns a string of all instances of a give object
deleteRange - deletes a range of objects
deleteItem - deletes all instances of a gieven object
retrieve - returns the object at a given index
toString - returns a String summarizing the List

Data Members 
Link Object _head to return store the first Link of the List
int _size to store teh size of the List
***********************************************************************************/
public class List {
   private Link _head;
   private int _size;
   
   public List() {
      _head = null;
      _size = 0;
   }

   public int getSize() {
      return _size;
   }
   
   public void insert(Object o) {
      Link add = new Link();
      add.data = o;
      add.next = _head;
      _head = add;
      ++_size;
   }
   
   public String find(Object o) {
      String s = "";
      Link current = _head;
      for(int i = 0; i < _size; current = current.next, i++) {
         if(current.data.equals(o))
            s = s + "Found at index " + i + "\n";
      }
      if(!s.equals(""))
         return s;
      else
         return "Item not found in List";
   }
   
   public void deleteRange(int start, int end) {
      Link current = _head;
      Link previous = null;
      for(int i = 1; i <= end || i < _size; ++i, current = current.next) {
         if(i == start)
            previous = current;
         if(i == end)
            previous.next = current.next;
      }
   }
   
   public Object retrieve(int j) {
      Link current = _head;
      if(j < _size) {
         for(int i = 0;; current = current.next, i++) {
            if(i == j)
               return current.data;
         }  
      }
      else
         return null;
   }  
   
   public void deleteItem(Object o) {
      Link current = _head;
      Link previous = null;
      while(current!=null) {
         if(current.data.equals(o)) {
            if( previous != null )
                previous.next = current.next;
            else
               _head = current.next;
         }
         previous = current;
         current = current.next;
      }
   }
      
   public String toString() {
      String s = "";
      for(Link current = _head; current.next != null; current = current.next)
         s = s + " " + current.data;
      return s;
   }
}
/***********************************************************************************
William Mastronardi CSC205 25993
This program will model the inventory item, it will contain a name, a quantity and a 
cost. It is a simple object used to test the List with more complex objects.
***********************************************************************************/
public class InventoryItem {
   private String _name;
   private int _quantity;
   private double _cost;
   
   public InventoryItem(String name, int quantity, double cost) {
      _name = name;
      _quantity = quantity;
      _cost = cost;
   }
   
   public boolean equals(Object other) {
      if(other instanceof InventoryItem) {
         return _name.equals(((InventoryItem)other).getName());
      }
      else 
         return false;
   }
   
   public String getName() {
      return _name;
   }
   
   public int getQuantity() {
      return _quantity;
   }
   
   public double getCost() {
      return _cost;
   }
   
   public String toString() {   
      return "Item name: " + _name + " Item Cost: $" + _cost + " Item Quantity: " + _quantity;
   }
}
/***********************************************************************************
William Mastronardi CSC205 25993
This is a simple object employing recursion to minimize storage used.
Data members
Object data - used to store the data of the link
Link next - used to store the next Link
***********************************************************************************/
public class Link {
   public Object data;
   public Link next;
}
