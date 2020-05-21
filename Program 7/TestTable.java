public class TestTable {
   public static void main(String[] args) {
      Table test = new Table();
      for(int i = 10; i > 0; i--){
         KeyedNumber insert = new KeyedNumber(i);
         test.insert(insert);
      }
      System.out.print(test.toString());
   }
}