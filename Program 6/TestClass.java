public class TestClass {
   public static void main(String[] args) {
      List list = new List();
      for(int i = 0; i <= 10; i++)
         list.insert("Test " + i);
      list.insert("Test " + 1);
      System.out.println(list);
      list.deleteRange(2,5);
      System.out.println(list);
   }
}