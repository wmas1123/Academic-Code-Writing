public class TestDequeOFStrings {
   public static void main(String[] args) {
      Queue deque = new Queue();
      Deque deque2 = new Deque();
      for(int i = 0; i < 13; i++) {
         deque.insert(" " + i);
         deque2.insertOnBack(" " + i);
      }
      System.out.println("QUEUE/INSERT - DELETE");
      System.out.println(deque.delete());
      System.out.println(deque.delete());
      System.out.println(deque.delete());
      System.out.println(deque.delete());
      System.out.println(deque.delete());
      System.out.println(deque);
      System.out.println("DEQUE/INSERT ON Back - DELETE FROM Front");
      System.out.println(deque2.deleteFromFront());
      System.out.println(deque2.deleteFromFront());
      System.out.println(deque2.deleteFromFront());
      System.out.println(deque2.deleteFromFront());
      System.out.println(deque2.deleteFromFront());
      System.out.println(deque2);
   }
}