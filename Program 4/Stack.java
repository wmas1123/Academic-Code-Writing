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