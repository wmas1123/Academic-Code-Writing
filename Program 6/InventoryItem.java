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