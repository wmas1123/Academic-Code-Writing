/************************************************************************************
This program will use the Deque object to simulate a queue. A queue is a data type 
that only allows insertion on the rear of the queue and only allows deletion from the
front.
************************************************************************************/
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