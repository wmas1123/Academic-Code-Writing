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