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